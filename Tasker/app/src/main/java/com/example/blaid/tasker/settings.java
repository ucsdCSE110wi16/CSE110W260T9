package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {

    Button generalButton, soundButton, displayButton, notificationsButton, historyButton;

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


    }
    public void generalPage(View view) {
        startActivity(new Intent(settings.this, GeneralSettings.class));
    }

    public void soundPage(View view) {
        startActivity(new Intent(settings.this, GeneralSettings.class));
    }

    public void displayPage(View view) {
        startActivity(new Intent(settings.this, GeneralSettings.class));
    }

    public void notificationsPage(View view) {
        startActivity(new Intent(settings.this, GeneralSettings.class));
    }

    public void historyPage(View view) {
        startActivity(new Intent(settings.this, GeneralSettings.class));
    }

}
