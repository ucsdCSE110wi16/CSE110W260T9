package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class User_Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupActionBar();

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

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_logout) {
            return true;
        }*/
        switch (id){
            case R.id.action_logout:
                Toast.makeText(User_Settings.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(User_Settings.this, Login.class));
                break;

            case R.id.action_settings:
                startActivity(new Intent(User_Settings.this, SettingsNEW_Activity.class));
                break;

            case R.id.action_edit_profile:
                Toast.makeText(User_Settings.this, "You are already viewing Edit Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_create_task:
                startActivity(new Intent(User_Settings.this, CreateTask.class));
                break;

            case R.id.action_home_page:
                startActivity(new Intent(User_Settings.this, Home_Page.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
