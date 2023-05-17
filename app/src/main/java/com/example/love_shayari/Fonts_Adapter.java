package com.example.love_shayari;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Fonts_Adapter extends BaseAdapter {

    Forth_Page forth_page;
    String[] fonts;

    public Fonts_Adapter(Forth_Page forth_page, String[] fonts) {
        this.forth_page = forth_page;
        this.fonts = fonts;
    }

    @Override
    public int getCount() {
        return fonts.length;
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
        convertView = LayoutInflater.from(forth_page).inflate(R.layout.fonts_gridview_item,parent,false);
        TextView textView = convertView.findViewById(R.id.fontstextview);
        Typeface type = Typeface.createFromAsset(forth_page.getAssets(), fonts[position]);
        textView.setText("Shayari");
        textView.setTypeface(type);
        return convertView;
    }

}
