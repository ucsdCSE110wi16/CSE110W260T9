package com.example.blaid.tasker;

<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> master
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blaid.tasker.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccount extends AppCompatActivity {
<<<<<<< HEAD
    String emailTxt, usernameTxt, passwordTxt, passwordCfmTxt;
=======
    String usernameTxt, passwordTxt, passwordCfmTxt, emailTxt;
>>>>>>> master
    EditText email, username, password, passwordCfm;
    Button button;

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
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
=======
                usernameTxt = username.getText().toString();
                passwordTxt = password.getText().toString();
                passwordCfmTxt = passwordCfm.getText().toString();
                emailTxt = email.getText().toString();

                if (usernameTxt.equals("") || passwordTxt.equals("") || emailTxt.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill in your email, username, and password!", Toast.LENGTH_LONG).show();
                } else {
                    if (!passwordTxt.equals(passwordCfmTxt)) {
                        Toast.makeText(getApplicationContext(), "Password and password confirmation do not match.", Toast.LENGTH_LONG).show();
                    } else {
                        ParseUser user = new ParseUser();
                        user.setUsername(usernameTxt);
                        user.setPassword(passwordTxt);
                        user.setEmail(emailTxt);
>>>>>>> master

                        user.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast.makeText(getApplicationContext(), "Successfully Signed Up!", Toast.LENGTH_LONG).show();
<<<<<<< HEAD
=======
                                    goToHomePage();
>>>>>>> master
                                } else {
                                    Toast.makeText(getApplicationContext(), "Sign Up Error", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }
            }
        });
<<<<<<< HEAD


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

=======
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goToHomePage() {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }

>>>>>>> master
}
