package com.example.blaid.tasker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.Parse;
import com.parse.ParseUser;

import org.w3c.dom.Text;

public class UserProfile extends AppCompatActivity {

    TextView username;
    String pUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (TextView) findViewById(R.id.Profile_username);

        pUser = ParseUser.getCurrentUser().getUsername();

        username.setText(pUser);
    }

}
