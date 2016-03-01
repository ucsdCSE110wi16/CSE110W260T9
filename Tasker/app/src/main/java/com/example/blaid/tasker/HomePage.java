package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button createTaskButton;
    Button SettingsButton;
    Button UserProfileEditButton;
    Button ViewUserProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        createTaskButton = (Button) findViewById(R.id.createTaskButtonId);

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCreateTask(v);
            }
        });


        SettingsButton = (Button) findViewById(R.id.settingsButton);
        UserProfileEditButton = (Button) findViewById(R.id.userProfileID);
        ViewUserProfileButton = (Button) findViewById(R.id.viewMyProfileID);


        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsPage(v);
            }
        });
        UserProfileEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProfileEditPage(v);
            }
        });
        ViewUserProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewUserProfilePage(v);
            }
        });
    }

    public void goCreateTask(View v) {
        startActivity(new Intent(getApplicationContext(), CreateTask.class));
    }

    public void settingsPage(View view) {
        startActivity(new Intent(getApplicationContext(), Settings.class));
    }
    public void userProfileEditPage(View view) {
        startActivity(new Intent(getApplicationContext(), EditMyProfile.class));
    }
    public void viewUserProfilePage(View view) {
        startActivity(new Intent(getApplicationContext(), ViewProfile.class));
    }
}
