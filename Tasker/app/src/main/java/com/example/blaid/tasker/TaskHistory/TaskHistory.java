package com.example.blaid.tasker.TaskHistory;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.blaid.tasker.Login;
import com.example.blaid.tasker.R;
import com.example.blaid.tasker.Task;
import com.example.blaid.tasker.TaskManager;
import com.parse.ParseUser;

import java.util.ArrayList;

public class TaskHistory extends AppCompatActivity {
    private ArrayAdapter<Task> adapter;
    final Context context = this;
    public String username;

    TextView urTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = Login.user.getUsername();
        ArrayList<Task> taskHistory = new ArrayList<>();

        for (Task t: TaskManager.taskList) {
            if (t.getUsername().equals(username)) {
                taskHistory.add(t);
            }
        }

        urTasks = (TextView) findViewById(R.id.taskHistoryText);
        urTasks.setText(ParseUser.getCurrentUser().getUsername().toString() + "'s Tasks");

        final ListView listView1 = (ListView) findViewById(R.id.listView1);
        adapter = new ArrayAdapter<Task>(this,
                R.layout.listview_layout,
                taskHistory);

        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task listItem = (Task) listView1.getItemAtPosition(position);
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.task_history_dialog);
                dialog.setTitle(listItem.getTitle());

                TextView text = (TextView) dialog.findViewById(R.id.dialogPrice);
                String price = String.format("%.2f", listItem.getPrice());
                text.setText("$" + price);

                text = (TextView) dialog.findViewById(R.id.dialogDate);
                text.setText(listItem.getMonth() + "/" + listItem.getDay() +
                        "/" + listItem.getYear());

                text = (TextView) dialog.findViewById(R.id.dialogDescription);
                text.setText(listItem.getDescription());

                text = (TextView) dialog.findViewById(R.id.dialogLocation);
                text.setText(listItem.getLocation());

                /* Set image view */
                ImageView img = (ImageView) dialog.findViewById(R.id.imageView3);
                switch (listItem.getImg_src()) {
                    case LAUNDRY:
                        img.setImageResource(R.drawable.laundryicon);
                        break;
                    case DISHES:
                        img.setImageResource(R.drawable.dishesicon);
                        break;
                    case DEFAULT:
                        img.setImageResource(R.drawable.profile_pic_default);
                        break;
                    case FOOD:
                        img.setImageResource(R.drawable.foodicon);
                        break;
                    case CAR:
                        img.setImageResource(R.drawable.caricon);
                        break;
                    case GAMES:
                        img.setImageResource(R.drawable.gameicon);
                        break;
                }

                Button dialogButton = (Button) dialog.findViewById(R.id.okButton);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}
