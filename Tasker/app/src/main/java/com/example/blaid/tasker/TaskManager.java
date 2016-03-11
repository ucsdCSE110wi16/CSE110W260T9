package com.example.blaid.tasker;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.lang.Integer;

/**
 * Created by j.mcc3093 on 3/7/16.
 *
 * This class is instantiated when the home page activity is launched.  It grabs
 * the list of tasks from the parse database, and it provides methods
 * for sorting the task list.
 */
public class TaskManager {

    /* This stores our task list for sorting */
    public static ArrayList<Task> taskList = new ArrayList<>();

    /*
     * This constructor grabs all the tasks in the database and initializes the
     * taskList.
     */
    public TaskManager() {
        getTaskList();
    }

    /**
     * This method stores a task as a ParseObject in the online database.
     *
     * @param task - The task to store.
     */
    public static void storeTask(Task task) {
        /* Create new parse object */
        ParseObject parseTask = new ParseObject("Task");

        parseTask.put("title", task.getTitle());
        parseTask.put("description", task.getDescription());
        parseTask.put("location", task.getLocation());
        parseTask.put("price", task.getPrice());
        parseTask.put("accepted", false);
        parseTask.put("username", task.getUsername());
        parseTask.put("imagesource", task.getImageSourceName());
        parseTask.put("hour", task.getHour());
        parseTask.put("min", task.getMin());
        parseTask.put("ampm", task.getAMPM());
        parseTask.put("year", task.getYear());
        parseTask.put("month", task.getMonth());
        parseTask.put("day", task.getDay());
        parseTask.put("completed", false);
        parseTask.put("useraccepted", "");

        /* Save task to database */
        parseTask.saveInBackground();
        task.setObjectID(parseTask.getObjectId());
    }

    public static void acceptTask(Task task) {
        String id = task.getObjectID();
        final String user = ParseUser.getCurrentUser().getUsername();
        task.setAccepted(true);
        task.setUserAccepted(user);

        ParseQuery<ParseObject> parseTask = ParseQuery.getQuery("Task");
        parseTask.getInBackground(id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    object.put("accepted", true);
                    object.put("useraccepted", user);
                }
                else {
                    System.out.println("Something went wrong with parse!");
                }
            }
        });

    }

    public static void completeTask(Task task) {
        task.setCompleted(true);
        String id = task.getObjectID();
        ParseQuery<ParseObject> parseTask = ParseQuery.getQuery("Task");
        parseTask.getInBackground(id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    object.put("completed", true);
                }
                else {
                    System.out.println("Something went wrong with parse!");
                }
            }
        });

    }

    /**
     * This method retrieves a list of ParseObjects to be displayed on the home page.
     */
    public static void getTaskList() {
        /* Fill new task list */
        taskList = new ArrayList<>();

        /* Get new ParseQuery */
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        query.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
        try {
            List<ParseObject> result = query.find();

            for (int i = 0; i < result.size(); i++) {
                Task t = createTask(result.get(i));
                taskList.add(t);
            }

        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    /**
     * Create a task object from ParseObject
     *
     * @param obj - the parse object to convert
     * @return - the newly created task object
     */
    public static Task createTask(ParseObject obj) {

        return new Task(obj.getString("title"),
                          obj.getString("description"),
                          obj.getString("location"),
                          obj.getInt("year"),
                          obj.getInt("month"),
                          obj.getInt("day"),
                          obj.getInt("hour"),
                          obj.getInt("min"),
                          obj.getInt("ampm"),
                          obj.getDouble("price"),
                          obj.getBoolean("accepted"),
                          obj.getString("imagesource"),
                          obj.getString("username"));
    }

    /**
     * This method uses Collections.sort to apply cascading filters to the
     * task list.
     *
     * @param option - An enum indicating which filter to apply.
     */
    public static void filterTasks(FilterOption option) {
        /* This switch statement determines which filter to sort with */
        switch (option) {
            /* Sorting by NEW will be the default filter option */
            case SOON:
                Collections.sort(taskList, new Comparator<Task>() {
                    @Override
                    public int compare(Task lhs, Task rhs) {
                        /* Compare the dates */
                        int comp = compareByDate(lhs, rhs);
                        if (comp != 0) {
                            return comp;
                        }
                        /* If dates are equal, compare by time */
                        return -1*compareByTime(lhs, rhs);
                    }
                });
                break;

            case PRICE:
                Collections.sort(taskList, new Comparator<Task>() {
                    @Override
                    public int compare(Task lhs, Task rhs) {
                        Double val1 = lhs.getPrice();
                        Double val2 = rhs.getPrice();

                        return -1 * val1.compareTo(val2);
                    }
                });
                break;

            case PRICE_INC:
                Collections.sort(taskList, new Comparator<Task>() {
                    @Override
                    public int compare(Task lhs, Task rhs) {
                        Double val1 = lhs.getPrice();
                        Double val2 = rhs.getPrice();

                        return val1.compareTo(val2);
                    }
                });
                break;

            case LOCATION:
                /* To Be Determined */
                break;

            case USER:
                ArrayList<Task> usersTasks = new ArrayList<Task>();
                for (Task t: taskList) {
                    if (t.getUsername().equals(ParseUser.getCurrentUser().getUsername())) {
                        usersTasks.add(t);
                    }
                }
                break;
        }
    }

    /**
     * This is a helper method for filterTasks, it implements a comparing
     * method to arrange tasks by soonest date.
     *
     * @param lhs - the first task to compare
     * @param rhs - the second task to compare
     */
    public static int compareByDate(Task lhs, Task rhs) {
        Calendar cal1 = new GregorianCalendar(lhs.getYear(), lhs.getMonth(),
                                              lhs.getDay());
        Calendar cal2 = new GregorianCalendar(rhs.getYear(), rhs.getMonth(),
                                              rhs.getDay());
        return cal1.compareTo(cal2);
    }

    /*
     * This helper method for filterTasks compares tasks by time only, it does
     * not compare date values.
     */
    public static int compareByTime(Task lhs, Task rhs) {
        /* First compare AM vs. PM */
        Integer val1 = lhs.getAMPM();
        Integer val2 = rhs.getAMPM();

        int comp = val1.compareTo(val2);

        if (comp != 0) {
            return -1*comp;
        }

        /* Now compare the hour value */
        val1 = lhs.getHour();
        val2 = rhs.getHour();

        comp = val1.compareTo(val2);

        if (comp != 0) {
            return -1*comp;
        }

        /* Now compare the minute */
        val1 = lhs.getMin();
        val2 = rhs.getMin();

        comp = val1.compareTo(val2);

        if (comp != 0) {
            return -1*comp;
        }

        /* Returning 0 means the tasks are for the same date */
        return 0;
    }
}
