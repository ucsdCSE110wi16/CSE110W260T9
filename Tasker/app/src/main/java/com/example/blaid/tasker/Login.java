package com.example.blaid.tasker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Login extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    Button signInButton, signUpButton;
    EditText username, password;

    TextView title, forgotUsername, forgotPassword;

    String usernameTxt, passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //Create Layout
//        RelativeLayout loginLayout = new RelativeLayout(this);
//        loginLayout.setBackgroundColor(Color.LTGRAY);
//
//        //Create Title
//        TextView titleText = new TextView(this);
//        titleText.setText(R.string.LogoText);
//        titleText.setTextColor(Color.BLACK);
//        titleText.setGravity(Gravity.FILL_HORIZONTAL);
//
//        //Buttons
//        Button signInButton = new Button(this);
//        signInButton.setText(R.string.SignInButtonText);
//        signInButton.setTextColor(Color.WHITE);
//        signInButton.setBackgroundColor(Color.BLACK);
//
//        Button signUpButton = new Button(this);
//        signUpButton.setText(R.string.SignUpButtonText);
//        signUpButton.setTextColor(Color.WHITE);
//        signUpButton.setBackgroundColor(Color.BLACK);
//
//        //Username and password
//        EditText usernameBox = new EditText(this);
//        usernameBox.setText(R.string.Username);
//        usernameBox.setTextColor(Color.BLACK);
//
//        EditText passwordBox = new EditText(this);
//        passwordBox.setText(R.string.Password);
//        passwordBox.setTextColor(Color.BLACK);
//
//        Resources r = getResources();
//        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320,
//                r.getDisplayMetrics()
//        );
//
//        titleText.setWidth(px);
//        usernameBox.setWidth(px);
//        passwordBox.setWidth(px);
//        signInButton.setWidth(px);
//        signUpButton.setWidth(px);
//
//        //Forgot textviews
//        TextView forgotUsername = new TextView(this);
//        forgotUsername.setText(R.string.ForgotUsernameText);
//        forgotUsername.setTextColor(Color.WHITE);
//        forgotUsername.isClickable();
//
//        TextView forgotPassword = new TextView(this);
//        forgotPassword.setText(R.string.ForgotPasswordText);
//        forgotPassword.setTextColor(Color.WHITE);
//        forgotPassword.isClickable();
//
//        //Give each widget a unique ID for referencing
//        signInButton.setId(1);
//        signUpButton.setId(2);
//        usernameBox.setId(3);
//        passwordBox.setId(4);
//        forgotUsername.setId(5);
//        forgotPassword.setId(6);
//
//        //Layout Containers
//        RelativeLayout.LayoutParams titleDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        RelativeLayout.LayoutParams passwordDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        RelativeLayout.LayoutParams forgotUsernameDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        RelativeLayout.LayoutParams forgotPasswordDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        RelativeLayout.LayoutParams signInButtonDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        RelativeLayout.LayoutParams signUpButtonDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//
//
//        //Rules for positioning of widgets
//        titleDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        titleDetails.addRule(RelativeLayout.ALIGN_TOP);
//        titleDetails.setMargins(0,50,0,50);
//
//        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        usernameDetails.addRule(RelativeLayout.ABOVE, passwordBox.getId());
//        usernameDetails.setMargins(0, 0, 0, 50);
//
//        passwordDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        passwordDetails.addRule(RelativeLayout.ABOVE, signInButton.getId());
//        passwordDetails.setMargins(0, 0, 0, 0);
//
//        forgotUsernameDetails.addRule(RelativeLayout.ALIGN_LEFT, passwordBox.getId());
//        forgotUsernameDetails.addRule(RelativeLayout.BELOW, passwordBox.getId());
//        forgotUsernameDetails.setMargins(0, 10, 0, 50);
//
//        forgotPasswordDetails.addRule(RelativeLayout.ALIGN_RIGHT, passwordBox.getId());
//        forgotPasswordDetails.addRule(RelativeLayout.BELOW, passwordBox.getId());
//        forgotPasswordDetails.setMargins(0, 10, 0, 50);
//
//        signInButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        signInButtonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
//        signInButtonDetails.setMargins(0, 100, 0, 50);
//
//        signUpButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        signUpButtonDetails.addRule(RelativeLayout.BELOW, signInButton.getId());
//        signUpButtonDetails.setMargins(0,0,0,0);
//
//        //Add all of the widgets to the layout
//        loginLayout.addView(titleText, titleDetails);
//        loginLayout.addView(signInButton, signInButtonDetails);
//        loginLayout.addView(signUpButton, signUpButtonDetails);
//        loginLayout.addView(usernameBox, usernameDetails);
//        loginLayout.addView(passwordBox, passwordDetails);
//        loginLayout.addView(forgotPassword, forgotPasswordDetails);
//        loginLayout.addView(forgotUsername, forgotUsernameDetails);

        //Set this layout as the one to be displayed
//        setContentView(loginLayout);

        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        signInButton = (Button) findViewById(R.id.clicktosignin);
        signUpButton = (Button) findViewById(R.id.clicktosignup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        title = (TextView) findViewById(R.id.apptitle);
        forgotUsername = (TextView) findViewById(R.id.textView2);
        forgotPassword = (TextView) findViewById(R.id.textView3);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin(v);

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup(v);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(Login.this).addApi(AppIndex.API).build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Login/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.blaid.tasker/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.blaid.tasker/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void signin(View view) {
        if (username.getText().toString().equals("admin")){
            if (password.getText().toString().equals("admin")){
                Intent intent = new Intent(Login.this, HomePage.class);
                Toast.makeText(getApplicationContext(), "Loging in...", Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
        }


    }

    public void signup(View view) {
        Intent intent = new Intent(Login.this, CreateAccount.class);
        startActivity(intent);

    }

}
