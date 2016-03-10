package com.example.blaid.tasker;
import com.parse.ParseObject;
import com.parse.ParseClassName;
import com.parse.ParseUser;

/**
 * Author: James McCullough
 * Date: 3/6/2016
 *
 * This class contains all the necessary information for a task.  Instances of this class
 * will be stored in the parse database.  This class implements comparable to allow lists
 * of tasks to be filtered.
 */
public class Task {
    /* For accessing values from date array */
    private int MONTH_INDEX = 0;
    private int DAY_INDEX = 1;
    private int YEAR_INDEX = 2;

    /* For accessing values from time array */
    private int HOUR_INDEX = 0;
    private int MINUTE_INDEX = 1;
    private int AMPM_INDEX = 2;

    /* Keep track of who created this task */
    private final int USER_ID;

    private boolean accepted;
    private PictureChoices img_src;
    private String title, description, location;
    private int[] date = new int[3];
    private int[] time = new int[3];
    private double price;
    private String username;

    public Task() {
        /* Initialize member variables */
        this.title = "Default Title";
        this.description = "Default Description";
        this.location = "";
        this.USER_ID = 0;
        this.price = 0;
        this.accepted = false;
        this.img_src = PictureChoices.DEFAULT;
        this.username = ParseUser.getCurrentUser().getUsername();
    }

    public Task(String title, double price, PictureChoices choice) {
        /* Initialize member variables */
        this.img_src = choice;
        this.title = title;
        this.description = "Default Description";
        this.location = "Default Location";
        this.USER_ID = 0;
        this.price = price;
        this.accepted = false;
        this.date[MONTH_INDEX] = (int)(Math.random()*10 + 3);
        this.date[DAY_INDEX] = (int)(Math.random()*30 + 1);
        this.date[YEAR_INDEX] = 2016;
        this.time[HOUR_INDEX] = 6;
        this.time[MINUTE_INDEX] = 30;
        this.username = ParseUser.getCurrentUser().getUsername();
    }

    public Task(String title, String description, String location, int[] time,
                int[] date, int USER_ID, double price, boolean accepted,
                PictureChoices choice) {
        /* Initialize member variables */
        this.title = title;
        this.description = description;
        this.location = location;
        this.time = time;
        this.date = date;
        this.USER_ID = USER_ID;
        this.price = price;
        this.accepted = false;
        this.img_src = choice;
        this.username = ParseUser.getCurrentUser().getUsername();
    }

    /* Implement toString() for list view */
    @Override
    public String toString() {
        String price = String.format("%.2f", this.price);
        return this.title + " : $" + price + "  :  " +
               this.date[MONTH_INDEX] + "/" + this.date[DAY_INDEX];
    }


    /* Getters and Setters */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTime(int[] time) {
        this.time = time;
    }

    public int[] getTime() {
        return this.time;
    }

    public void setAMPM(int AMPM) {
        this.time[AMPM_INDEX] = AMPM;
    }

    public int getAMPM() {
        return this.time[AMPM_INDEX];
    }

    public void setHour(int hour) {
        this.time[HOUR_INDEX] = hour;
    }

    public int getHour() {
        return this.time[HOUR_INDEX];
    }

    public void setMin(int min) {
        this.time[MINUTE_INDEX] = min;
    }

    public int getMin() {
        return this.time[MINUTE_INDEX];
    }

    public void setDate(int[] date) {
        this.date = date;
    }

    public int[] getDate() {
        return this.date;
    }

    public void setYear(int year) {
        this.date[YEAR_INDEX] = year;
    }

    public int getYear() {
        return this.date[YEAR_INDEX];
    }

    public void setMonth(int month) {
        this.date[MONTH_INDEX] = month;
    }

    public int getMonth() {
        return this.date[MONTH_INDEX];
    }

    public void setDay(int day) {
        this.date[DAY_INDEX] = day;
    }

    public int getDay() {
        return this.date[DAY_INDEX];
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public PictureChoices getImg_src() {
        return this.img_src;
    }

    public void setImg_src(PictureChoices img_src) {
        this.img_src = img_src;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /* Note there is no setUserID method, userID cannot be changed */
    public int getUserID() {
        return this.USER_ID;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean getAccepted() {
        return this.accepted;
    }
}
