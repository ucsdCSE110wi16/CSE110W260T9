package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewTask extends AppCompatActivity {

    Button acceptTask, back;
    TextView title, date, time, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title = (TextView) findViewById(R.id.textViewTaskTitle);
        date = (TextView) findViewById(R.id.textViewTaskDate);
        time = (TextView) findViewById(R.id.textViewTaskTime);
        description = (TextView) findViewById(R.id.textViewTaskDescription);

        back = (Button) findViewById(R.id.buttonTaskBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome(v);
            }
        });

        acceptTask = (Button) findViewById(R.id.buttonTaskAccept);
        acceptTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Task: " + title.getText() + " accepted!", Toast.LENGTH_SHORT);
                backHome(v);
            }
        });
    }

    public void backHome(View v) {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }

}
