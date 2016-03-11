package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/**
 * Created by deneyew on 2/23/16.
 */
public class Home_Page extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {


        Button createTaskButton;
        Button SettingsButton;
        Button UserProfileEditButton;
        Button ViewUserProfileButton;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drawer_activity);
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
           /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });*/

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.drawer_activity, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_closest) {
                // Handle the camera action
            } else if (id == R.id.nav_household) {

            } else if (id == R.id.nav_food) {

            } else if (id == R.id.nav_labor) {

            } else if (id == R.id.nav_delivery) {

            } else if (id == R.id.nav_delivery) {

            } else if (id == R.id.nav_fivezero) {

            } else if(id == R.id.nav_ftoone) {

            } else if(id == R.id.nav_onetwofifty) {

            } else if(id == R.id.nav_Twofifty) {

            } else if(id == R.id.nav_deals){

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
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




