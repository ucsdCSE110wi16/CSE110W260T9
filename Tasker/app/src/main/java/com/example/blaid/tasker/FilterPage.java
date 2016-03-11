package com.example.blaid.tasker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;

public class FilterPage extends AppCompatActivity {

    private CheckBox nearyou, fofree, fifty, hundred, twofifty, momoney;
    private Button applyChanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_page);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


        addNearYouListener();
        addFoFreeListener();
        addFiftyListener();
        addHundredListener();
        addTwoFiftyListener();
        addMoMOneyListener();


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void addNearYouListener(){
        nearyou = (CheckBox) findViewById(R.id.nearchu);
        nearyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addFoFreeListener(){
        fofree = (CheckBox) findViewById(R.id.freebee);
        fofree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addFiftyListener(){
        fifty = (CheckBox) findViewById(R.id.fiveo);
        fifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addHundredListener(){
        hundred = (CheckBox) findViewById(R.id.hundy);
        hundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addTwoFiftyListener(){
        twofifty = (CheckBox) findViewById(R.id.tFifty);
        twofifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addMoMOneyListener(){
        momoney = (CheckBox) findViewById(R.id.moMoney);
        momoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
