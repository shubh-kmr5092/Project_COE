package com.example.project_coe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class background_color extends AppCompatActivity {

    Button red,green,yellow,white,mix,blue;
    RelativeLayout rl;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_color);


        blue = findViewById(R.id.bt1);
        red= findViewById(R.id.bt2);
        green = findViewById(R.id.bt3);
        yellow = findViewById(R.id.bt4);
        rl=findViewById(R.id.rl);
        white = findViewById(R.id.bt6);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.setBackgroundColor(Color.BLUE);
            }
        });



        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.setBackgroundColor(Color.RED);

            }
        });


        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.setBackgroundColor(Color.GREEN);

            }
        });


        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.setBackgroundColor(Color.YELLOW);
            }
        });






        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.setBackgroundColor(Color.WHITE);

            }
        });





    }
}