package com.example.project_coe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userDetails extends AppCompatActivity {
    TextView name, phone, mail;
    Button logOut, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        cancel = (Button)findViewById(R.id.btCancel);
        logOut = (Button)findViewById(R.id.btOut);
        name = (TextView)findViewById(R.id.user_print);
        mail = (TextView) findViewById(R.id.mail_print);
        phone = (TextView) findViewById(R.id.phone_print);





        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AppIntegration.class);
                startActivity(intent);
            }
        });

        String us,em,ph;
        us=getIntent().getExtras().getString("us_name");
        ph=getIntent().getExtras().getString("mobile");
        em=getIntent().getExtras().getString("mail_id");

        name.setText(us);
        phone.setText(ph);
        mail.setText(em);


        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userDetails.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
