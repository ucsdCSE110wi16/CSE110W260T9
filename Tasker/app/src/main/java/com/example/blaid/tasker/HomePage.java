package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;




public class HomePage extends AppCompatActivity {

    Button SettingsButton;
    Button UserProfileEditButton;
    Button ViewUserProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

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

    public void settingsPage(View view) {
        startActivity(new Intent(HomePage.this, settings.class));
    }
    public void userProfileEditPage(View view) {
        startActivity(new Intent(HomePage.this, User_Settings.class));
    }
    public void viewUserProfilePage(View view) {
        startActivity(new Intent(HomePage.this, UserProfile.class));
    }
}