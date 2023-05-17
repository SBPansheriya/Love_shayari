package com.example.love_shayari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Back_Text_Adapter extends BaseAdapter {

    Activity activity;
    int[] colorarr;

    public Back_Text_Adapter(Activity activity, int[] colorarr) {
        this.activity = activity;
        this.colorarr = colorarr;
    }

    @Override
    public int getCount() {
        return colorarr.length;
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
        convertView = LayoutInflater.from(activity).inflate(R.layout.back_text_gridcolor_item,parent,false);
        TextView textView = convertView.findViewById(R.id.back_text_textview);

        textView.setBackgroundResource(colorarr[position]);

        return convertView;
    }
}
