package com.example.love_shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Forth_Page extends AppCompatActivity {

    ImageView reload1,expand1;
    TextView editshayari;
    int cnt=0,i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth_page);
        editshayari = findViewById(R.id.editshayari);
        reload1 = findViewById(R.id.reload1);

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
    }
}