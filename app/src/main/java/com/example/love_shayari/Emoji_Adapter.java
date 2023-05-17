package com.example.love_shayari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Emoji_Adapter extends BaseAdapter {

    Forth_Page forth_page;
    String[] emojis;
    public Emoji_Adapter(Forth_Page forth_page, String[] emojis) {
        this.forth_page = forth_page;
        this.emojis = emojis;
    }

    @Override
    public int getCount() {
        return emojis.length;
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
        convertView  = LayoutInflater.from(forth_page).inflate(R.layout.emoji_listview_item,parent,false);
        TextView textView = convertView.findViewById(R.id.emoji_textview);
        textView.setText(emojis[position]);
        return convertView;
    }
}
