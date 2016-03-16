package com.example.blaid.tasker;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class HomePage extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayAdapter<Task> adapter;
    private ArrayList<Task> taskList;
    final Context context = this;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskList = TaskManager.getTaskList();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final ListView listView1 = (ListView) findViewById(R.id.listView1);
        listView1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        adapter = new MyAdapter(this, taskList);

        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Task listItem = (Task) listView1.getItemAtPosition(position);
                String objectID = listItem.getObjectID();
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.home_page_dialog);
                dialog.setTitle(listItem.getTitle());

                text = (TextView) dialog.findViewById(R.id.dialogPrice);
                String price = String.format("%.2f", listItem.getPrice());
                text.setText("$" + price);

                text = (TextView) dialog.findViewById(R.id.dialogDate);
                text.setText(listItem.getMonth() + "/" + listItem.getDay() +
                             "/" + listItem.getYear());

                text = (TextView) dialog.findViewById(R.id.dialogDescription);
                text.setText(listItem.getDescription());

                text = (TextView) dialog.findViewById(R.id.dialogLocation);
                text.setText(listItem.getLocation());

                text = (TextView) dialog.findViewById(R.id.dialogUserText);
                text.setText(listItem.getObjectID());

                /* Set image view */
                ImageView img = (ImageView) dialog.findViewById(R.id.imageView3);
                switch (listItem.getImageSource()) {
                    case LAUNDRY:
                        img.setImageResource(R.drawable.laundryicon);
                        break;
                    case DISHES:
                        img.setImageResource(R.drawable.dishesicon);
                        break;
                    case DEFAULT:
                        img.setImageResource(R.drawable.profile_pic_default);
                        break;
                    case FOOD:
                        img.setImageResource(R.drawable.foodicon);
                        break;
                    case CAR:
                        img.setImageResource(R.drawable.caricon);
                        break;
                    case GAMES:
                        img.setImageResource(R.drawable.gameicon);
                        break;
                }

                Button dialogExitButton = (Button) dialog.findViewById(R.id.buttonTaskBack);
                // if button is clicked, close the custom dialog
                dialogExitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button dialogAcceptButton = (Button) dialog.findViewById(R.id.buttonTaskAccept);
                // if button is clicked, accept the task
                /* Find way to hide the task after accepted, and link it to the current user */
                dialogAcceptButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TaskManager.acceptTask(listItem, listItem.getObjectID());
                        Toast.makeText(getApplicationContext(), "Task accepted!", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
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
                Toast.makeText(HomePage.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;

                case R.id.action_settings:
                      Toast.makeText(HomePage.this, "Welcome to General Settings", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(getApplicationContext(), SettingsPage.class));
                      break;



            case R.id.action_edit_profile:
                startActivity(new Intent(getApplicationContext(), EditProfile.class));
                break;

            case R.id.action_create_task:
                startActivity(new Intent(getApplicationContext(), CreateTask.class));
                break;

            case R.id.action_home_page:
                Toast.makeText(getApplicationContext(), "You are already viewing Home Page", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_view_profile:
                startActivity(new Intent(getApplicationContext(), ViewProfile.class));
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
}
