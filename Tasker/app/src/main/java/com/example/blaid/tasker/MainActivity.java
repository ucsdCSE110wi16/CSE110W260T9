package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public static final String APPLICATION_ID = "B1JHogV7pRql8v3xKuvuxNxRZjWWOUbGK04GzbK3";
    public static final String CLIENT_ID = "B9BB44VfrV96Dlq28bP13yi7QRD5lyIBGc0FOGER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ParseACL defaultACL = new ParseACL();
        Parse.initialize(this, APPLICATION_ID, CLIENT_ID);
        //defaultACL.setPublicReadAccess(true);
        //ParseObject.registerSubclass(Task.class);
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
