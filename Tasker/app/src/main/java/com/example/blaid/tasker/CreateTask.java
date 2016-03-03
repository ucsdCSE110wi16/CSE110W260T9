package com.example.blaid.tasker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;


public class CreateTask extends AppCompatActivity {
    private int year = 2016;
    private int month = 2;
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

    }

    public void goHome(View v) {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }
}
