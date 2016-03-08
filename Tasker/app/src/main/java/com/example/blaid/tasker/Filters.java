package com.example.blaid.tasker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.CheckBox;




public class Filters extends AppCompatActivity{
    private CheckBox nearYou, deals, zero, ftohundred, hundtotwo, momoney, free;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        addNearYouListener();
        addDealsListener();
        addftOnListener();
        addHundToTwoListener();
        addMoMoneyListener();
        addFreeListener();
        addZeroListener();

        addApplyButtonListener();
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
        /*if (id == R.id.action_logout) {
            return true;
        }*/
        switch (id){
            case R.id.action_logout:
                Toast.makeText(Filters.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Filters.this, Login.class));
        }

        return super.onOptionsItemSelected(item);
    }


    public void addNearYouListener()
    {
        nearYou = (CheckBox) findViewById(R.id.near_you);
        nearYou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addDealsListener()
    {
        deals = (CheckBox) findViewById(R.id.deals_$);
        deals.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addZeroListener()
    {
        zero = (CheckBox) findViewById(R.id.fifty);
        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addftOnListener()
    {
        ftohundred = (CheckBox) findViewById(R.id.hund);
        ftohundred.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addHundToTwoListener()
    {
        hundtotwo = (CheckBox) findViewById(R.id.twofifty);
        hundtotwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addMoMoneyListener()
    {
        momoney = (CheckBox) findViewById(R.id.mo_money);
        momoney.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    public void addFreeListener()
    {
        free = (CheckBox) findViewById(R.id.fofree);
        free.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addApplyButtonListener(){
        nearYou = (CheckBox) findViewById(R.id.near_you);
        deals = (CheckBox) findViewById(R.id.deals_$);
        zero = (CheckBox) findViewById(R.id.fifty);
        ftohundred = (CheckBox) findViewById(R.id.hund);
        hundtotwo =(CheckBox) findViewById(R.id.twofifty);
        momoney =(CheckBox) findViewById(R.id.mo_money);
        free =  (CheckBox) findViewById(R.id.fofree)  ;

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Applying Filter Changes",
                        Toast.LENGTH_LONG).show();
            }
        });
     /*   button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Applying Filter Changes",
                        Toast.LENGTH_LONG).show();
            }
        });*/
    }


}
