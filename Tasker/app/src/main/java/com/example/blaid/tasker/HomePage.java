package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    Button createTaskButton;
    Button SettingsButton;
    Button UserProfileEditButton;
    Button ViewUserProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Login/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_logout) {
            return true;
        }*/
        switch (id){
            case R.id.action_logout:
                Toast.makeText(getApplicationContext(), "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Login.class));

            case R.id.action_settings:
                startActivity(new Intent(getApplicationContext(), settings.class));

            case R.id.action_edit_profile:
                startActivity(new Intent(HomePage.this, User_Settings.class));

            case R.id.action_view_profile:
                startActivity(new Intent(getApplicationContext(), UserProfile.class));
        }

        return super.onOptionsItemSelected(item);
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
