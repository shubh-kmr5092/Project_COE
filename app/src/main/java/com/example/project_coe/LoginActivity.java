package com.example.project_coe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName,passWord;
    TextView companyName;
    Button login,reset,new1;
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        companyName = (TextView)findViewById(R.id.comName);
        userName = (EditText)findViewById(R.id.user_name);
        passWord= (EditText)findViewById(R.id.pass_word);
        login = (Button)findViewById(R.id.log);
        reset = (Button)findViewById(R.id.clear);
        new1 = (Button)findViewById(R.id.newUser);
        DB = new  DatabaseHelper(this);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = userName.getText().toString();
                String pass = passWord.getText().toString();
                String mailID = userName.getText().toString();


                if(user.equals("")||pass.equals("")) {

                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,mailID,pass);
                    if(checkuserpass==true){

                        Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT).show();


                        Intent intent  = new Intent(getApplicationContext(), AppIntegration.class);
                        startActivity(intent);
                    }
                    else{

                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        new1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getApplicationContext(),RegistrationForm.class);
                startActivity(intent1);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName.setText("");

                passWord.getText().clear();
            }
        });


    }
}
