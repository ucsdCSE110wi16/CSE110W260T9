package com.example.blaid.tasker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CreateTask extends AppCompatActivity {
    private int year = 2016;
    private int month = 3;
    private int day;

    ImageButton buttonBack;

    private DatePickerDialog.OnDateSetListener myDateListener =
                                               new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {}
                                               };
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonBack = (ImageButton) findViewById(R.id.button_backID);

        Spinner s = (Spinner) findViewById(R.id.menu_spinnerID);

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
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();

                switch (item){
                    case "Logout":
                        Toast.makeText(CreateTask.this, "Logging out...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CreateTask.this, Login.class));
                        break;

                    case "Edit Profile":
                        startActivity(new Intent(CreateTask.this, EditMyProfile.class));
                        break;

                    case "Settings":
                        startActivity(new Intent(CreateTask.this, Settings.class));
                        break;

                    case "Create Task":
                        startActivity(new Intent(CreateTask.this, CreateTask.class));
                        break;

                    case "View Profile":
                        startActivity(new Intent(CreateTask.this, ViewProfile.class));
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
                login(v);

            }
        });

    }

    public void login(View v) {
        startActivity(new Intent(getApplicationContext(), Login.class));
    }
}
