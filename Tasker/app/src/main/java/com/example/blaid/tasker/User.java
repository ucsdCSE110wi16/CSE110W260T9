package com.example.blaid.tasker;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j.mcc3093 on 3/10/16.
 *
 * This class is used to handle the user's accepted and outgoing tasks!
 */
public class User {
    private static String username = ParseUser.getCurrentUser().getUsername();
    public static ArrayList<Task> taskHistory =  new ArrayList<>();
    public static ArrayList<Task> acceptedTaskHistory = new ArrayList<>();
    public static ArrayList<Task> completedTaskHistory = new ArrayList<>();

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
}
