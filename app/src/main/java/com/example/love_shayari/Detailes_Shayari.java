package com.example.love_shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detailes_Shayari extends AppCompatActivity {

    TextView textView,number_bar;
    ImageView edit,leftarrow,rightarrow,reload;
    int gridcolorarr[] = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,R.drawable.c15};
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

        int positon = getIntent().getIntExtra("pos",0);
        String shayari[] = getIntent().getStringArrayExtra("shayari");
        textView.setText(shayari[positon]);

        edit.setImageResource(R.drawable.pencil2);
        j=positon;

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

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<=15){
                    textView.setBackgroundResource(gridcolorarr[i]);
                    cnt++;
                    i++;
                }
                else {
                    i = 0;
                    cnt = 0;
                }
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Detailes_Shayari.this,Forth_Page.class);
                intent.putExtra("pos",positon);
                intent.putExtra("shayari",shayari);
                intent.putExtra("gridcolor",gridcolorarr);
                startActivity(intent);
            }
        });
    }
}