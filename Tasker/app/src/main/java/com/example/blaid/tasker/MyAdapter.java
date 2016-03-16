package com.example.blaid.tasker;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by j.mcc3093 on 3/10/16.
 *
 * This class provides a custom adapter to customize our list view.
 */
public class MyAdapter extends ArrayAdapter<Task> {

    private final Context context;
    public ArrayList<Task> taskList;

    public MyAdapter(Context context, ArrayList<Task> taskList) {

        super(context, R.layout.alt_listview_layout, taskList);

        this.context = context;
        this.taskList = taskList;
    }

    public void remove(Task task) {
        taskList.remove(task);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.alt_listview_layout, parent, false);

        // 3. Get the two text view from the rowView
        TextView title = (TextView) rowView.findViewById(R.id.listTitle);
        TextView subtitle = (TextView) rowView.findViewById(R.id.textView8);
        ImageView img = (ImageView) rowView.findViewById(R.id.imageView5);

        switch (taskList.get(position).getImageSource()) {
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

        // 4. Set the text for textView
        title.setText(taskList.get(position).getTitle());


        String price = "$" + String.format("%.2f", taskList.get(position).getPrice());
        String date = taskList.get(position).getDateToString();

        String subtext = price + " - " + date;
        subtitle.setText(subtext);

        // 5. return rowView
        return rowView;
    }
}
