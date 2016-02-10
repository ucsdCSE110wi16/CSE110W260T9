package com.example.blaid.tasker;

import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseObject;
import com.parse.ParseUser;

import android.app.Application;

/**
 * Created by Blaid on 01/02/2016.
 */
public class ParseApplication extends Application{
    public static final String APPLICATION_ID = "B1JHogV7pRql8v3xKuvuxNxRZjWWOUbGK04GzbK3";
    public static final String CLIENT_ID = "B9BB44VfrV96Dlq28bP13yi7QRD5lyIBGc0FOGER";

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, APPLICATION_ID, CLIENT_ID);

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
