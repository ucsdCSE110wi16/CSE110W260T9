package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.blaid.tasker.Login;

import com.parse.Parse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

<<<<<<< HEAD
        Parse.initialize(this);

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
=======
        startActivity(new Intent(getApplicationContext(), Login.class));
>>>>>>> master
    }

}