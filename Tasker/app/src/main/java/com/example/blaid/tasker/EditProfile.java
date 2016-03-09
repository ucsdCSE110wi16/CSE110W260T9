package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
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
                Toast.makeText(EditProfile.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditProfile.this, Login.class));
                break;

            case R.id.action_settings:
                Toast.makeText(EditProfile.this, "Welcome to General Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditProfile.this, SettingsPage.class));
                break;

            case R.id.action_edit_profile:
                Toast.makeText(EditProfile.this, "You are already viewing Edit Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_create_task:
                Toast.makeText(EditProfile.this, "New Blank Task...",
                Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditProfile.this, CreateTask.class));
                break;

            case R.id.action_home_page:
                Toast.makeText(User_Settings.this, "Welcome Home",
                Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditProfile.this, Home_Page.class));
                break;

              }

        return super.onOptionsItemSelected(item);
    }

}
