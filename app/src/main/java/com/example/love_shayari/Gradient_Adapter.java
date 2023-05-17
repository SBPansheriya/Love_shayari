package com.example.love_shayari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class Gradient_Adapter extends BaseAdapter {

    Activity activity;
    int[] gridcolorarr;
    String shayaricatagroy;

    public Gradient_Adapter(Activity activity, String shayari, int[] gridcolorarr) {
        this.activity = activity;
        this.gridcolorarr = gridcolorarr;
        this.shayaricatagroy = shayari;
    }


    @Override
    public int getCount() {
        return gridcolorarr.length;
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
        convertView = LayoutInflater.from(activity).inflate(R.layout.grid_item,parent,false);
        TextView textView = convertView.findViewById(R.id.gridgradients);
        TextView textView1 = convertView.findViewById(R.id.gridgradients);
        textView.setBackgroundResource(gridcolorarr[position]);
        textView1.setText(shayaricatagroy);
        return convertView;
    }
}