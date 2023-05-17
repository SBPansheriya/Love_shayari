package com.example.love_shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Forth_Page extends AppCompatActivity {

    ImageView reload1,expand1;
    TextView editshayari,background,textcolor,fonts,emoji;
    int cnt=0,i=0;
    ListView emoji_listview;
    GridView gridView,back_text_gridview,fonts_gridView;
    Gradient_Adapter gradient_Adapter;
    Back_Text_Adapter back_text_adapter;
    Fonts_Adapter fonts_adapter;
    Emoji_Adapter emoji_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth_page);
        editshayari = findViewById(R.id.editshayari);
        reload1 = findViewById(R.id.reload1);
        expand1 = findViewById(R.id.expand1);
        background = findViewById(R.id.background);
        textcolor = findViewById(R.id.textcolor);
        fonts  = findViewById(R.id.fonts);
        emoji = findViewById(R.id.emoji);


        int position = getIntent().getIntExtra("pos",0);
        String shayari[] = getIntent().getStringArrayExtra("shayari");
        int gridcolorarr[] = getIntent().getIntArrayExtra("gridcolor");
        editshayari.setText(shayari[position]);

        reload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<15){
                    if(cnt==i){
                        editshayari.setBackgroundResource(gridcolorarr[i]);
                        cnt++;
                        i++;
                    }
                }
                else {
                    i = 0;
                    cnt = 0;
                }
            }
        });

        expand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Forth_Page.this);
                bottomSheetDialog.setContentView(R.layout.grid_color);
                gradient_Adapter = new Gradient_Adapter(Forth_Page.this,shayari[position],config.gridcolorarr);
                gridView = bottomSheetDialog.findViewById(R.id.gridcolors);
                gridView.setAdapter(gradient_Adapter);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        editshayari.setBackgroundResource(config.gridcolorarr[position]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Forth_Page.this);
                bottomSheetDialog.setContentView(R.layout.back_text_gridcolor);
                back_text_adapter = new Back_Text_Adapter(Forth_Page.this,config.colorarr);
                back_text_gridview = bottomSheetDialog.findViewById(R.id.back_text_gridview);
                back_text_gridview.setAdapter(back_text_adapter);
                bottomSheetDialog.show();
                back_text_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        editshayari.setBackgroundResource(config.colorarr[position]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        textcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Forth_Page.this);
                bottomSheetDialog.setContentView(R.layout.back_text_gridcolor);
                back_text_adapter = new Back_Text_Adapter(Forth_Page.this,config.colorarr);
                back_text_gridview = bottomSheetDialog.findViewById(R.id.back_text_gridview);
                back_text_gridview.setAdapter(back_text_adapter);
                bottomSheetDialog.show();
                back_text_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        editshayari.setTextColor(getResources().getColor(config.colorarr[position]));
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        fonts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Forth_Page.this);
                bottomSheetDialog.setContentView(R.layout.fonts_gridview);
                fonts_adapter = new Fonts_Adapter(Forth_Page.this,config.fonts);
                fonts_gridView = bottomSheetDialog.findViewById(R.id.fontsitem);
                fonts_gridView.setAdapter(fonts_adapter);
                bottomSheetDialog.show();

                fonts_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Typeface type = Typeface.createFromAsset(getAssets(), config.fonts[position]);
                        editshayari.setTypeface(type);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Forth_Page.this);
                bottomSheetDialog.setContentView(R.layout.emoji_listview);
                emoji_adapter  = new Emoji_Adapter(Forth_Page.this,config.emojis);
                emoji_listview = bottomSheetDialog.findViewById(R.id.emoji_listview);
                emoji_listview.setAdapter(emoji_adapter);
                bottomSheetDialog.show();

                emoji_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        editshayari.setText(""+config.emojis[position] +"\n" + ""+shayari[position]  +"\n" +config.emojis[position]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });
    }
}