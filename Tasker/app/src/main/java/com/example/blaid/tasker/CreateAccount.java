package com.example.blaid.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.blaid.tasker.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

public class CreateAccount extends AppCompatActivity {
    String emailTxt, usernameTxt, passwordTxt, passwordCfmTxt;
    EditText email, username, password, passwordCfm;
    Button button;
    ImageButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        email = (EditText) findViewById(R.id.editTextEmail);
        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPassword);
        passwordCfm = (EditText) findViewById(R.id.editTextPasswordConfirm);
        button = (Button) findViewById(R.id.createButton);

        buttonBack = (ImageButton) findViewById(R.id.button_menu_backID);

        Spinner s = (Spinner) findViewById(R.id.spinner_menuID);

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
                        Toast.makeText(CreateAccount.this, "Logging out...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CreateAccount.this, Login.class));
                        break;

                    case "Edit Profile":
                        startActivity(new Intent(CreateAccount.this, EditMyProfile.class));
                        break;

                    case "Settings":
                        startActivity(new Intent(CreateAccount.this, Settings.class));
                        break;

                    case "Create Task":
                        startActivity(new Intent(CreateAccount.this, CreateTask.class));
                        break;

                    case "View Profile":
                        startActivity(new Intent(CreateAccount.this, ViewProfile.class));
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailTxt = email.getText().toString();
                usernameTxt = username.getText().toString();
                passwordTxt = password.getText().toString();
                passwordCfmTxt = passwordCfm.getText().toString();


                if (usernameTxt.equals("") || passwordTxt.equals("") || emailTxt.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter your email, username, and password.", Toast.LENGTH_LONG).show();
                } else {
                    if (!passwordTxt.equals(passwordCfmTxt)) {
                        Toast.makeText(getApplicationContext(), "Password and Password Confirmation do not match.", Toast.LENGTH_LONG).show();
                    } else {
                        ParseUser user = new ParseUser();
                        user.setEmail(emailTxt);
                        user.setUsername(usernameTxt);
                        user.setPassword(passwordTxt);

                        user.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast.makeText(getApplicationContext(), "Successfully Signed Up!", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Sign Up Error", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void login(View view) {
        startActivity(new Intent(CreateAccount.this, Login.class));
    }

}
