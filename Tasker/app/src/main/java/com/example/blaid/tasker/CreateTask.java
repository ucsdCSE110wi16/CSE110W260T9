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
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;


public class CreateTask extends AppCompatActivity {
    private int year = 2016;
    private int month = 3;
    private int day;

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

        Spinner s = (Spinner) findViewById(R.id.spin);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Task = parent.getSelectedItem().toString();

                //File f = new File("/res/drawable/laundry_icon.jpg");
                //Bitmap bmap = BitmapFactory.decodeFile(f.getAbsolutePath());
                //Drawable drawable = getDrawable(R.drawable.fast_food_icon);
                //android.widget.ImageView myImageView = (android.widget.ImageView)findViewById(R.id.image_of_taskID);
                //myImageView.setImageBitmap(bmap);
                Toast.makeText(CreateTask.this, "You selected " + Task + " as your task type", Toast.LENGTH_SHORT).show();

                //image_of_taskID.src "@drawable/laundry-icon";
                //android:src="@drawable/dirty-dishes-icon";
                //Toast.makeText(CreateTask.this, "this part needs to be finished", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void goHome(View v) {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }
}
