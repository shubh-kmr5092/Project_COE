package com.example.project_coe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE"))
            Toast.makeText(context, "SOME_ACTION is received", Toast.LENGTH_LONG).show();


    }

}