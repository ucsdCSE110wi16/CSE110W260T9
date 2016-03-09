package com.example.blaid.tasker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class CreateTask extends AppCompatActivity {

    private int setTimeId = 1000;
    private int setDateId = 9999;

    /* Get the current date */
    final Calendar cal = Calendar.getInstance();
    private int year = cal.get(Calendar.YEAR);
    private int month = cal.get(Calendar.MONTH);
    private int day = cal.get(Calendar.DAY_OF_MONTH);
    private int[] date = {month, day, year};

    private int[] time = new int[3];

    private String title, description, location;
    private int price;
    private int hour, min;
    private int ampm = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set task image
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.profile_pic_default);
        ImageView myImageView = (ImageView) findViewById(R.id.imageView4);
        myImageView.setImageBitmap(bm);

        //set task image spinner
        Spinner s = (Spinner) findViewById(R.id.spin);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Task_Types, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Task = parent.getSelectedItem().toString();

                Bitmap nbm = BitmapFactory.decodeResource(getResources(), R.drawable.supermanprofile);
                ImageView superManImageView = (ImageView) findViewById(R.id.imageView4);
                superManImageView.setImageBitmap(nbm);

                switch (Task) {
                    case "Select Type":
                        Bitmap selectbm = BitmapFactory.decodeResource(getResources(), R.drawable.selecticon);
                        ImageView selectImageView = (ImageView) findViewById(R.id.imageView4);
                        selectImageView.setImageBitmap(selectbm);
                        break;

                    case "Laundry":
                        Bitmap laundrybm = BitmapFactory.decodeResource(getResources(), R.drawable.laundryicon);
                        ImageView laundryImageView = (ImageView) findViewById(R.id.imageView4);
                        laundryImageView.setImageBitmap(laundrybm);
                        break;

                    case "Dishes":
                        Bitmap dishesbm = BitmapFactory.decodeResource(getResources(), R.drawable.dishesicon);
                        ImageView dishesImageView = (ImageView) findViewById(R.id.imageView4);
                        dishesImageView.setImageBitmap(dishesbm);
                        break;

                    case "Car":
                        Bitmap carbm = BitmapFactory.decodeResource(getResources(), R.drawable.caricon);
                        ImageView carImageView = (ImageView) findViewById(R.id.imageView4);
                        carImageView.setImageBitmap(carbm);
                        break;

                    case "Food":
                        Bitmap foodbm = BitmapFactory.decodeResource(getResources(), R.drawable.foodicon);
                        ImageView foodImageView = (ImageView) findViewById(R.id.imageView4);
                        foodImageView.setImageBitmap(foodbm);
                        break;

                    case "Video Games":
                        Bitmap gamebm = BitmapFactory.decodeResource(getResources(), R.drawable.gameicon);
                        ImageView gameImageView = (ImageView) findViewById(R.id.imageView4);
                        gameImageView.setImageBitmap(gamebm);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button createTaskButton;
        createTaskButton = (Button) findViewById(R.id.createTaskButtonId);
        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = createTask();
                if (task != null) {
                    TaskManager.getInstance().taskList.add(0, task);
                    startActivity(new Intent(CreateTask.this, Home_Page.class));
                } else {
                    Toast.makeText(CreateTask.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setupActionBar();

    }

    private DatePickerDialog.OnDateSetListener myDateListener =
                                               new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker view, int year_val, int month_val, int day_val) {
             year = year_val;
             month = month_val;
             day = day_val;
         }
    };

    private TimePickerDialog.OnTimeSetListener myTimeListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hour_val, int min_val) {
                    hour = hour_val;
                    min = min_val;
                }
    };


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(setDateId);
    }

    @SuppressWarnings("deprecation")
    public void setTime(View view) {
        showDialog(setTimeId);
    }

    @Override
    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        if (id == setDateId) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }

        if (id == setTimeId) {
            return new TimePickerDialog(this, myTimeListener, 0, 0, true);
        }

        return null;
    }

    public void goHome(View v) {
        startActivity(new Intent(getApplicationContext(), Home_Page.class));
    }


    /*
     * Get values from from widgets and create task.
     */
    private Task createTask() {
        String title, description, location;
        double price;
        EditText text;

        /* Get title text */
        text = (EditText) findViewById(R.id.editText);
        title = text.getText().toString();
        if (title.isEmpty()) {
            return null;
        }

        /* Get price */
        text = (EditText) findViewById(R.id.editText3);
        try {
            price = Double.parseDouble(text.getText().toString());
        } catch (Exception e) {
            return null;
        }

        /* Get description */
        text = (EditText) findViewById(R.id.editText2);
        description = text.getText().toString();
        if (description.isEmpty()) {
            return null;
        }

        /* Get location */
        text = (EditText) findViewById(R.id.editText4);
        location = text.getText().toString();
        if (location.isEmpty()) {
            return null;
        }

        /* Create new task */
        date[0] = month;
        date[1] = day;
        date[2] = year;

        time[0] = hour;
        time[1] = min;
        time[2] = ampm;

        Task task = new Task(title, description, location,
                time, date, 0, price, false);
        return task;
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
                Toast.makeText(CreateTask.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateTask.this, Login.class));
                break;

            case R.id.action_settings:
                startActivity(new Intent(CreateTask.this, SettingsPage.class));
                break;

            case R.id.action_edit_profile:
                startActivity(new Intent(CreateTask.this, EditProfile.class));
                break;

            case R.id.action_create_task:
                Toast.makeText(CreateTask.this, "You are already viewing Create Task", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_home_page:
                startActivity(new Intent(CreateTask.this, Home_Page.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
