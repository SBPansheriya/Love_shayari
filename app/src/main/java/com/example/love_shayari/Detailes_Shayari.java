package com.example.love_shayari;

import static android.content.Context.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.text.AnnotatedString;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Detailes_Shayari extends AppCompatActivity {

    TextView textView,number_bar;
    ImageView copy,share,edit,leftarrow,rightarrow,reload,expand;
    GridView gridView;
    Gradient_Adapter gradientAdapter;

    int cnt = 0,i = 0,j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes_shayari);
        textView  = findViewById(R.id.shayari_name1);
        edit = findViewById(R.id.edit);
        leftarrow = findViewById(R.id.leftarrow);
        rightarrow = findViewById(R.id.rightarrow);
        reload = findViewById(R.id.reload_activities_button);
        number_bar = findViewById(R.id.number_bar);
        expand = findViewById(R.id.expand_activities_button);
        copy = findViewById(R.id.copy);
        share = findViewById(R.id.share);

        int positon = getIntent().getIntExtra("pos",0);
        String shayari[] = getIntent().getStringArrayExtra("shayari");
        textView.setText(shayari[positon]);
        j=positon;

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        number_bar.setText(""+(j+1) + "/" + ""+shayari.length);
        leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j>0){
                    j--;
                    textView.setText(shayari[j]);
                    number_bar.setText(""+(j+1) + "/" + ""+shayari.length);
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Detailes_Shayari.this,Forth_Page.class);
                intent.putExtra("pos",positon);
                intent.putExtra("shayari",shayari);
                intent.putExtra("gridcolor",config.gridcolorarr);
                startActivity(intent);
            }
        });

        rightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j< shayari.length-1){
                    j++;
                    textView.setText(shayari[j]);
                    number_bar.setText(""+(j+1) + "/" + ""+shayari.length);
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Create an ACTION_SEND Intent*/
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                /*This will be the actual content you wish you share.*/
                String shareBody = textView.getText().toString();
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.sub));
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                /*Fire!*/
                startActivity(Intent.createChooser(intent, getString(R.string.sub)));
            }
        });
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<=15){
                    textView.setBackgroundResource(config.gridcolorarr[i]);
                    cnt++;
                    i++;
                }
                else {
                    i = 0;
                    cnt = 0;
                }
            }
        });

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Detailes_Shayari.this);
                bottomSheetDialog.setContentView(R.layout.grid_color);
                gradientAdapter = new Gradient_Adapter(Detailes_Shayari.this,shayari[positon],config.gridcolorarr);
                gridView = bottomSheetDialog.findViewById(R.id.gridcolors);
                gridView.setAdapter(gradientAdapter);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setBackgroundResource(config.gridcolorarr[position]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });





    }

//    private void copyText() {
//        ClipboardManager cm = (ClipboardManager) getApplicationContext().getSystemService(CLIPBOARD_SERVICE);
//        cm.setText((AnnotatedString) textView.getText());
//        Toast.makeText(Detailes_Shayari.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
//
//    }
}