package com.example.blaid.tasker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupActionBar();
        Button saveButton = (Button) findViewById(R.id.startID);
        Button cancelButton = (Button) findViewById(R.id.cancelId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome(v);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome(v);
            }
        });

        //set task image
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.profile_pic_default);
        ImageView myImageView = (ImageView) findViewById(R.id.imageView4);
        myImageView.setImageBitmap(bm);

        //set task image spinner
        Spinner s = (Spinner) findViewById(R.id.spin);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Profile_Types, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Task = parent.getSelectedItem().toString();

                Bitmap nbm = BitmapFactory.decodeResource(getResources(), R.drawable.selecticon);
                ImageView superManImageView = (ImageView) findViewById(R.id.imageView4);
                superManImageView.setImageBitmap(nbm);

                switch (Task) {
                    case "Select Pic":
                        Bitmap selectbm = BitmapFactory.decodeResource(getResources(), R.drawable.selecticon);
                        ImageView selectImageView = (ImageView) findViewById(R.id.imageView4);
                        selectImageView.setImageBitmap(selectbm);
                        break;

                    case "Superman":
                        Bitmap laundrybm = BitmapFactory.decodeResource(getResources(), R.drawable.supermanprofile);
                        ImageView laundryImageView = (ImageView) findViewById(R.id.imageView4);
                        laundryImageView.setImageBitmap(laundrybm);
                        break;

                    case "WonderWoman":
                        Bitmap dishesbm = BitmapFactory.decodeResource(getResources(), R.drawable.supergirlprofile);
                        ImageView dishesImageView = (ImageView) findViewById(R.id.imageView4);
                        dishesImageView.setImageBitmap(dishesbm);
                        break;

                    case "Harlequin":
                        Bitmap carbm = BitmapFactory.decodeResource(getResources(), R.drawable.harlequin_profile);
                        ImageView carImageView = (ImageView) findViewById(R.id.imageView4);
                        carImageView.setImageBitmap(carbm);
                        break;

                    case "StormTrooper":
                        Bitmap foodbm = BitmapFactory.decodeResource(getResources(), R.drawable.stormtrooperprofile);
                        ImageView foodImageView = (ImageView) findViewById(R.id.imageView4);
                        foodImageView.setImageBitmap(foodbm);
                        break;

                    case "Batman":
                        Bitmap gamebm = BitmapFactory.decodeResource(getResources(), R.drawable.batmanprofile);
                        ImageView gameImageView = (ImageView) findViewById(R.id.imageView4);
                        gameImageView.setImageBitmap(gamebm);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
                Toast.makeText(EditProfile.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditProfile.this, Login.class));
                break;

            case R.id.action_settings:
                Toast.makeText(EditProfile.this, "Welcome to General Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditProfile.this, SettingsPage.class));
                break;

            case R.id.action_edit_profile:
                Toast.makeText(EditProfile.this, "You are already viewing Edit Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_create_task:
                Toast.makeText(EditProfile.this, "New Blank Task...",
                Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditProfile.this, CreateTask.class));
                break;

            case R.id.action_home_page:

                Toast.makeText(EditProfile.this, "Welcome Home",
                Toast.LENGTH_SHORT).show();

                startActivity(new Intent(EditProfile.this, HomePage.class));

                break;

              }

        return super.onOptionsItemSelected(item);
    }

    public void goHome(View view) {

        startActivity(new Intent(EditProfile.this, HomePage.class));


    }

}
