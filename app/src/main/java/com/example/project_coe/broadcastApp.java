package com.example.project_coe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class broadcastApp extends AppCompatActivity {
    Button broad;
    MyReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_app);
        broad = findViewById(R.id.button5);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        registerReceiver(myReceiver,filter);
    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }
}


