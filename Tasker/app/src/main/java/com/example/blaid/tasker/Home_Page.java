package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Home_Page extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayAdapter<Task> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final ListView listView1 = (ListView) findViewById(R.id.listView1);

        adapter = new ArrayAdapter<Task>(this,
                                    R.layout.listview_layout,
                                    TaskManager.getInstance().taskList);

        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task listItem = (Task) listView1.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), listItem.getTitle(), Toast.LENGTH_SHORT).show();
                viewTask(view);
            }
        });
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
        // automatically handle clicks on the Login/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_logout:
                Toast.makeText(Home_Page.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Page.this, Login.class));
                break;

            case R.id.action_settings:
                startActivity(new Intent(Home_Page.this, SettingsPage.class));
                break;

            case R.id.action_edit_profile:
                startActivity(new Intent(Home_Page.this, EditProfile.class));
                break;

            case R.id.action_create_task:
                startActivity(new Intent(Home_Page.this, CreateTask.class));
                break;

            case R.id.action_home_page:
                Toast.makeText(Home_Page.this, "You are already viewing Home Page", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_newest) {
            TaskManager.filterTasks(FilterOption.SOON);
            adapter.notifyDataSetChanged ();
        } else if (id == R.id.nav_nearest) {
            TaskManager.filterTasks(FilterOption.LOCATION);
            adapter.notifyDataSetChanged();
        } else if (id == R.id.nav_price) {
            TaskManager.filterTasks(FilterOption.PRICE);
            adapter.notifyDataSetChanged ();
        } else if (id == R.id.nav_price_inc) {
            TaskManager.filterTasks(FilterOption.PRICE_INC);
            adapter.notifyDataSetChanged();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void viewTask(View v) {
        startActivity(new Intent(getApplicationContext(), ViewTask.class));
    }
}



