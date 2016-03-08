package com.example.blaid.tasker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
    List<Task> taskList;

    private static TaskManager _instance = null;
    public static TaskManager getInstance(){
        if(_instance == null)
            _instance= new TaskManager();
        return _instance;
    }

    /*
     * This constructor grabs all the tasks in the database and initializes the
     * taskList.
     */
    public TaskManager() {
        /* get taskList from database */
        /* filter by newest before displaying to user */
    }

    /*
     * This method uses Collections.sort to apply cascading filters to the
     * task list.
     */
    public void filterTasks(FilterOption option) {
        /* This switch statement determines which filter to sort with */
        switch (option) {
            /* Sorting by NEW will be the default filter option */
            case SOON:
                Collections.sort(taskList, new Comparator<Task>() {
                    @Override
                    public int compare(Task lhs, Task rhs) {
                        /* Compare the dates */
                        int comp = compareByDate(lhs, rhs);
                        if (comp == 0) {
                            return comp;
                        }
                        /* If dates are equal, compare by time */
                        return compareByTime(lhs, rhs);
                    }
                });
                break;

            case PRICE:
                Collections.sort(taskList, new Comparator<Task>() {
                    @Override
                    public int compare(Task lhs, Task rhs) {
                        Integer val1 = lhs.getPrice();
                        Integer val2 = rhs.getPrice();

                        return val1.compareTo(val2);
                    }
                });
                break;

            case LOCATION:
                /* To Be Determined */
                break;
        }
    }

    /*
     * This is a helper method for filterTasks, it implements a comparing
     * method to arrange tasks by soonest date.
     */
    public int compareByDate(Task lhs, Task rhs) {
        /* First compare the year */
        Integer val1 = lhs.getYear();
        Integer val2 = rhs.getYear();

        int comp = val1.compareTo(val2);

        if (comp != 0) {
            return comp;
        }

        /* Now compare the month */
        val1 = lhs.getMonth();
        val2 = rhs.getMonth();

        comp = val1.compareTo(val2);

        if (comp != 0) {
            return comp;
        }

        /* Now compare the day */
        val1 = lhs.getDay();
        val2 = rhs.getDay();

        comp = val1.compareTo(val2);

        if (comp != 0) {
            return comp;
        }

        /* Returning 0 means the tasks are for the same date */
        return 0;
    }

    /*
     * This helper method for filterTasks compares tasks by time only, it does
     * not compare date values.
     */
    public int compareByTime(Task lhs, Task rhs) {
        /* First compare AM vs. PM */
        Integer val1 = lhs.getAMPM();
        Integer val2 = rhs.getAMPM();

        int comp = val1.compareTo(val2);

        if (comp != 0) {
            return comp;
        }

        /* Now compare the hour value */
        val1 = lhs.getHour();
        val2 = rhs.getHour();

        comp = val1.compareTo(val2);

        if (comp != 0) {
            return comp;
        }

        /* Now compare the minute */
        val1 = lhs.getMin();
        val2 = rhs.getMin();

        comp = val1.compareTo(val2);

        if (comp != 0) {
            return comp;
        }

        /* Returning 0 means the tasks are for the same date */
        return 0;
    }
}