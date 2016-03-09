package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ViewProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
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

        switch (id){
            case R.id.action_logout:
                Toast.makeText(ViewProfile.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ViewProfile.this, Login.class));
                break;

            case R.id.action_settings:
                Toast.makeText(ViewProfile.this, "Welcome to General Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ViewProfile.this, SettingsPage.class));
                break;

            case R.id.action_edit_profile:
                Toast.makeText(ViewProfile.this, "Preparing to edit User Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ViewProfile.this, EditProfile.class));
                break;

            case R.id.action_create_task:
                Toast.makeText(ViewProfile.this, "New Blank Task...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ViewProfile.this, CreateTask.class));
                break;

                case R.id.action_home_page:
                    Toast.makeText(ViewProfile.this, "Welcome Home", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ViewProfile.this, Home_Page.class));
                    break;

        }

        return super.onOptionsItemSelected(item);
    }

}
