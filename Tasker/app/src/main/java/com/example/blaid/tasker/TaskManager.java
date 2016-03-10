package com.example.blaid.tasker;

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

    private static TaskManager _instance = null;

    public static TaskManager getInstance(){
        if(_instance == null)
            _instance = new TaskManager();
        return _instance;
    }

    /*
     * This constructor grabs all the tasks in the database and initializes the
     * taskList.
     */
    public TaskManager() {
        /* get taskList from database */
        /* filter by newest before displaying to user */
        taskList = new ArrayList<Task>();
        taskList.add(new Task("Laundry Task", 13.29, PictureChoices.LAUNDRY));
        taskList.add(new Task("Dishes", 5.00, PictureChoices.DISHES));
        taskList.add(new Task("Food Run", 15.69, PictureChoices.FOOD));
        taskList.add(new Task("Homework Help", 20.00, PictureChoices.DEFAULT));
        taskList.add(new Task("House Cleaning", 15.99, PictureChoices.CAR));
        taskList.add(new Task("Get Food", 2.00, PictureChoices.FOOD));
        taskList.add(new Task("Drop off Paper", 15.69, PictureChoices.CAR));
        taskList.add(new Task("Sell Chair", 45, PictureChoices.DEFAULT));
        taskList.add(new Task("Pick up Clothes", 10, PictureChoices.LAUNDRY));
        taskList.add(new Task("Change Tire", 15.99, PictureChoices.CAR));
        taskList.add(new Task("Cook Meal", 2.00, PictureChoices.FOOD));
        taskList.add(new Task("Drop off Books", 15.69, PictureChoices.CAR));
        taskList.add(new Task("Buy Groceries", 45, PictureChoices.FOOD));
        taskList.add(new Task("Write Letter", 10, PictureChoices.DEFAULT));
    }

    /*
     * This method uses Collections.sort to apply cascading filters to the
     * task list.
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
                    if (t.getUsername().equals(Login.user.getUsername())) {
                        usersTasks.add(t);
                    }
                }
                break;
        }
    }

    /*
     * This is a helper method for filterTasks, it implements a comparing
     * method to arrange tasks by soonest date.
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
