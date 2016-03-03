package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;




/*public class HomePage extends AppCompatActivity {

    Button SettingsButton;
    Button UserProfileEditButton;
    Button ViewUserProfileButton;
    Button FilterButton; */

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

/*<<<<<<< HEAD
        SettingsButton = (Button) findViewById(R.id.settingsButton);
        UserProfileEditButton = (Button) findViewById(R.id.userProfileID);
        ViewUserProfileButton = (Button) findViewById(R.id.viewMyProfileID);
        FilterButton = (Button) findViewById(R.id.viewFilterOptions);

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
=======
        createTaskButton = (Button) findViewById(R.id.createTaskButtonId);

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCreateTask(v);
            }
        });*/


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
>>>>>>> abbec3815d14c4acefe161dc00c9bbeae0217c97
            }
        });
        ViewUserProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewUserProfilePage(v);
            }
        });

    }

  /*  public void settingsPage(View view) {
        startActivity(new Intent(HomePage.this, settings.class));
    }
    public void userProfileEditPage(View view) {
        startActivity(new Intent(HomePage.this, User_Settings.class));
    }
    public void viewUserProfilePage(View view) {
        startActivity(new Intent(HomePage.this, UserProfile.class));
    }*/
}
    public void goCreateTask(View v) {
        startActivity(new Intent(getApplicationContext(), CreateTask.class));
    }

    public void settingsPage(View view) {
        startActivity(new Intent(getApplicationContext(), settings.class));
    }
    public void userProfileEditPage(View view) {
        startActivity(new Intent(getApplicationContext(), User_Settings.class));
    }
    public void viewUserProfilePage(View view) {
        startActivity(new Intent(getApplicationContext(), UserProfile.class));
    }
}
