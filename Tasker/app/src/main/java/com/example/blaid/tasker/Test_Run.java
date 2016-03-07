package com.example.blaid.tasker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Test_Run extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__run);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Login/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_logout:
                Toast.makeText(Test_Run.this, "Logging out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Test_Run.this, Login.class));

            case R.id.action_edit_profile:
                startActivity(new Intent(Test_Run.this, EditMyProfile.class));

            case R.id.action_menu_settings:
                startActivity(new Intent(Test_Run.this, Settings.class));

        }

        return super.onOptionsItemSelected(item);
    }
}
