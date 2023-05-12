package com.example.love_shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter myAdapter;
    int imgarr[] = {R.drawable.husband,R.drawable.god,R.drawable.love,R.drawable.birthday,R.drawable.holiimg,R.drawable.bearbar,R.drawable.politics,R.drawable.bewfa,R.drawable.santabanta};
    String shayariname[] = {"Dosti Shayari","God Shayari","Love Shayari","Brithday Shayari","Holi Shayari","Sharab Shayari","Politics Shayari","Bewfa Shayari","Other Shayari"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

       myAdapter = new MyAdapter(MainActivity.this,imgarr,shayariname);
       listView.setAdapter(myAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(MainActivity.this, Shayari_Page.class);
               intent.putExtra("pos",position);
               intent.putExtra("image",imgarr);
               startActivity(intent);
           }
       });
    }
}