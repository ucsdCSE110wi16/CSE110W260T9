package com.example.blaid.tasker;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AcceptedTasks extends AppCompatActivity {
    private ArrayAdapter<Task> adapter;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepted_tasks);

        ArrayList<Task> taskHistory = TaskManager.getAcceptedTaskHistory();

        final ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        adapter = new MyAdapter(this, taskHistory);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Task listItem = (Task) listView.getItemAtPosition(position);
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.accepted_task_dialog);
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

                text = (TextView) dialog.findViewById(R.id.dialogUserText);
                text.setText(listItem.getUsername());

                if (listItem.getCompleted()) {
                    text = (TextView) dialog.findViewById(R.id.dialogStatus);
                    text.setTextColor(Color.GREEN);
                    text.setText("Completed!");
                }

                /* Set image view */
                ImageView img = (ImageView) dialog.findViewById(R.id.imageView3);
                switch (listItem.getImageSource()) {
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

                Button completeButton = (Button) dialog.findViewById(R.id.completeButton);
                completeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listItem.setCompleted(true);
                        dialog.dismiss();
                    }
                });

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
