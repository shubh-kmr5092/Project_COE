package com.example.project_coe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class AppIntegration extends AppCompatActivity {
    RecyclerView recyclerView;
    Button out;


    String[] s1;
    int[] images={R.drawable.calc,R.drawable.media_player,R.drawable.gallery,R.drawable.bgcolor,R.drawable.wallpaper,R.drawable.ntfctn,R.drawable.brdcst,R.drawable.services};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_integration);

        recyclerView = findViewById(R.id.hoa);



        s1=getResources().getStringArray(R.array.Hands_on_App);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        out= findViewById(R.id.log);








        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent5);
            }
        });


        MyAdapter myAdapter= new MyAdapter(this, s1,images);

        recyclerView.setAdapter(myAdapter);


    }
}