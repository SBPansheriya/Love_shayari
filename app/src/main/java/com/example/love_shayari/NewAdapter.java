package com.example.love_shayari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewAdapter extends BaseAdapter {
    Shayari_Page shayari_page;
    int imgarr1;
    String[] shayaricatagroy;


    public NewAdapter(Shayari_Page shayari_page, int imgarr1, String[] shayari) {
        this.imgarr1 = imgarr1;
        this.shayari_page = shayari_page;
        this.shayaricatagroy = shayari;
    }

    @Override
    public int getCount() {
        return shayaricatagroy.length;
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
        convertView = LayoutInflater.from(shayari_page).inflate(R.layout.activity_listview_shayariname,parent,false);
        ImageView imageView = convertView.findViewById(R.id.image1);
        TextView textView = convertView.findViewById(R.id.shayari_name);

        imageView.setImageResource(imgarr1);
        textView.setText(shayaricatagroy[position]);
        return convertView;
    }
}

