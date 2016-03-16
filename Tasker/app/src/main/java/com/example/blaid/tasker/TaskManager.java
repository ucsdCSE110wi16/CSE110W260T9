package com.example.blaid.tasker;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

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
    public static ArrayList<Task> taskList;
    public static ArrayList<Task> taskHistory;
    public static ArrayList<Task> acceptedTaskHistory;
    public static ArrayList<Task> completedTaskHistory;
    private static String username = ParseUser.getCurrentUser().getUsername();


    /**
     * This method retrieves a list of ParseObjects to be displayed on the home page.
     */
    public static ArrayList<Task> getTaskList() {
        /* Fill new task list */
        taskList = new ArrayList<>();

        /* Get new ParseQuery */
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        query.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.whereEqualTo("accepted", false);
        try {
            List<ParseObject> result = query.find();

            for (int i = 0; i < result.size(); i++) {
                Task t = createTask(result.get(i));
                taskList.add(t);
            }
            return taskList;

        } catch (ParseException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * This method retrieves a list of ParseObjects to be displayed on the home page.
     */
    public static ArrayList<Task> getTaskHistory() {
        /* Fill new task list */
        taskHistory = new ArrayList<>();

        /* Get new ParseQuery */
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");

        try {
            query.whereEqualTo("username", username);
            List<ParseObject> result = query.find();


            for (int i = 0; i < result.size(); i++) {
                Task t = TaskManager.createTask(result.get(i));
                taskHistory.add(t);
            }
            return taskHistory;

        } catch (ParseException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * This method retrieves a list of "accepted" ParseObjects to be displayed on the home page.
     */
    public static ArrayList<Task> getAcceptedTaskHistory() {
        /* Fill new task list */
        acceptedTaskHistory = new ArrayList<>();

        /* Get new ParseQuery */
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");

        try {
            query.whereEqualTo("useraccepted", username);
            query.whereEqualTo("completed", false);
            List<ParseObject> result = query.find();


            for (int i = 0; i < result.size(); i++) {
                Task t = TaskManager.createTask(result.get(i));
                acceptedTaskHistory.add(t);
            }
            return acceptedTaskHistory;

        } catch (ParseException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * This method retrieves a list of "completed" ParseObjects to be displayed on the home page.
     */
    public static ArrayList<Task> getCompletedTaskHistory() {
        /* Fill new task list */
        completedTaskHistory = new ArrayList<>();

        /* Get new ParseQuery */
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");

        try {
            query.whereEqualTo("useraccepted", username);
            query.whereEqualTo("completed", true);
            List<ParseObject> result = query.find();


            for (int i = 0; i < result.size(); i++) {
                Task t = TaskManager.createTask(result.get(i));
                acceptedTaskHistory.add(t);
            }
            return acceptedTaskHistory;

        } catch (ParseException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * This method stores a task as a ParseObject in the online database.
     *
     * @param task - The task to store.
     */
    public static void storeTask(final Task task) {
        /* Create new parse object */
        final ParseObject parseTask = new ParseObject("Task");

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
        parseTask.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    task.setObjectID(parseTask.getObjectId());
                }
            }
        });
    }

    public static void acceptTask(Task task, final String id) {
        final String user = ParseUser.getCurrentUser().getUsername();
        task.setAccepted(true);
        task.setUserAccepted(user);

        ParseQuery<ParseObject> parseTask = ParseQuery.getQuery("Task");
        parseTask.getInBackground(id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseTask, ParseException e) {
                if (e == null) {
                    parseTask.put("accepted", true);
                    parseTask.put("useraccepted", user);
                    parseTask.saveInBackground();
                } else {
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
                } else {
                    System.out.println("Something went wrong with parse!");
                }
            }
        });

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
                          obj.getString("username"),
                          obj.getObjectId());
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

    /* This is a helper method for filterTasks, it implements a comparing
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
