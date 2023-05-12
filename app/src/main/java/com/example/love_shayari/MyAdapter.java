package com.example.love_shayari;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
        MainActivity mainActivity;
        int[] imgarr;
        String[] shayariname;


    public MyAdapter(MainActivity mainActivity, int[] imgarr, String[] shayariname) {
        this.imgarr = imgarr;
        this.mainActivity = mainActivity;
        this.shayariname = shayariname;
    }

    public MyAdapter(Shayari_Page shayari_page, int[] imgarr, String[] shayari) {
    }

    @Override
    public int getCount() {
        return shayariname.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mainActivity).inflate(R.layout.activity_main_list,parent,false);
        ImageView imageView = convertView.findViewById(R.id.main_image);
        TextView textView = convertView.findViewById(R.id.shayari_name_text);

        imageView.setImageResource(imgarr[position]);
        textView.setText(shayariname[position]);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
//                builder.setTitle("Alert");
//                builder.setMessage("are you sure open image");
//                builder.setPositiveButton("open", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                builder.show();
//            }
//        });
        return convertView;
    }
}
