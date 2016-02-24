package com.example.blaid.tasker;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> master
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
=======
>>>>>>> master

import com.example.blaid.tasker.R;

public class HomePage extends AppCompatActivity {

<<<<<<< HEAD
    Button createTaskButton;

=======
>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

<<<<<<< HEAD
        createTaskButton = (Button) findViewById(R.id.createTaskButtonId);

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCreateTask(v);
            }
        });

=======
>>>>>>> master
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

<<<<<<< HEAD
    public void goCreateTask(View v) {
        startActivity(new Intent(getApplicationContext(), CreateTask.class));
    }
=======
>>>>>>> master
}
