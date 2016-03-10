package com.example.blaid.tasker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccount extends AppCompatActivity {
    String emailTxt, usernameTxt, passwordTxt, passwordCfmTxt;
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
                        System.out.println("made it");
                        ParseUser user = new ParseUser();
                        user.setEmail(emailTxt);
                        user.setUsername(usernameTxt);
                        user.setPassword(passwordTxt);
                        final ProgressDialog dialog = new ProgressDialog(CreateAccount.this);
                        dialog.setMessage("Signing up...");
                        dialog.show();

                        user.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                dialog.dismiss();
                                if (e == null) {
                                    Toast.makeText(getApplicationContext(), "Successfully Signed Up!", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(CreateAccount.this, HomePage.class));
                                } else {
                                    System.out.println("Exception is :" + e);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Login/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_logout) {
            return true;
        }*/
        switch (id){
            case R.id.action_logout:
                Toast.makeText(CreateAccount.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateAccount.this, Login.class));
                break;

            case R.id.action_settings:
                startActivity(new Intent(CreateAccount.this, SettingsPage.class));
                break;

            case R.id.action_edit_profile:
                startActivity(new Intent(CreateAccount.this, EditProfile.class));
                break;

            case R.id.action_create_task:
                Toast.makeText(CreateAccount.this, "You are already viewing Create Task", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_home_page:
                startActivity(new Intent(CreateAccount.this, HomePage.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
