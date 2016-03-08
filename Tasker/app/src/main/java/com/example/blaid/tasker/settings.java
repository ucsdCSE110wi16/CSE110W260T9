package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Settings extends AppCompatActivity {

    Button generalButton, soundButton, displayButton, notificationsButton, historyButton,settingsButton, editProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        generalButton = (Button) findViewById(R.id.generalID);
        soundButton = (Button) findViewById(R.id.soundID);
        displayButton = (Button) findViewById(R.id.displayID);
        notificationsButton = (Button) findViewById(R.id.notificationID);
        historyButton = (Button) findViewById(R.id.historyID);
        settingsButton = (Button) findViewById(R.id.menu_settingsID);
        editProfileButton = (Button) findViewById(R.id.edit_profileID);

        generalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generalPage(v);
            }
        });

        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPage(v);
            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPage(v);
            }
        });

        notificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationsPage(v);
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyPage(v);
            }
        });

        setupActionBar();

        ImageButton buttonBack;

            buttonBack = (ImageButton) findViewById(R.id.imageButton2);

            Spinner s = (Spinner) findViewById(R.id.spinnerIDMenu);

            // Spinner Drop down elements
            List<String> categories = new ArrayList<String>();
            categories.add("Menu");
            categories.add("Logout");
            categories.add("Edit Profile");
            categories.add("Settings");
            categories.add("Create Task");
            categories.add("View Profile");

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            s.setAdapter(dataAdapter);

            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item = parent.getItemAtPosition(position).toString();

                    switch (item) {
                        case "Logout":
                            Toast.makeText(Settings.this, "Logging out...", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Settings.this, Login.class));
                            break;

                        case "Edit Profile":
                            startActivity(new Intent(Settings.this, EditMyProfile.class));
                            break;

                        case "Settings":
                            startActivity(new Intent(Settings.this, Settings.class));
                            break;

                        case "Create Task":
                            startActivity(new Intent(Settings.this, CreateTask.class));
                            break;

                        case "View Profile":
                            startActivity(new Intent(Settings.this, ViewProfile.class));
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            buttonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToHome(v);

                }
            });
    }

    public void goToHome(View v) {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }


    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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

        switch (id){
            case R.id.action_logout:
                Toast.makeText(Settings.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Settings.this, Login.class));
                break;

            case R.id.action_edit_profile:
                startActivity(new Intent(Settings.this, EditMyProfile.class));
                break;

            case R.id.action_menu_settings:
                startActivity(new Intent(Settings.this, Settings.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void generalPage(View view) {
        startActivity(new Intent(Settings.this, GeneralSettings.class));
    }

    public void soundPage(View view) {
        startActivity(new Intent(Settings.this, SettingsNEW_Activity.class));
    }

    public void displayPage(View view) {
        startActivity(new Intent(Settings.this, GeneralSettings.class));
    }

    public void notificationsPage(View view) {
        startActivity(new Intent(Settings.this, GeneralSettings.class));
    }

    public void historyPage(View view) {
        startActivity(new Intent(Settings.this, GeneralSettings.class));
    }

}
