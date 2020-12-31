package com.example.project_coe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

public class RegistrationForm extends AppCompatActivity {

    EditText name, pswd, cpass, phone, mail;
    Button register,canc;
    ScrollView scrollView;
    DatabaseHelper Mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        name = (EditText) findViewById(R.id.user_edit);
        pswd = (EditText) findViewById(R.id.pass_edit);
        cpass = (EditText) findViewById(R.id.cpass_edit);
        phone = (EditText) findViewById(R.id.phone_edit);
        mail = (EditText) findViewById(R.id.mail_edit);
        register = (Button) findViewById(R.id.regUser);
        canc = (Button) findViewById(R.id.can);
        Mydb = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = name.getText().toString();
                String pass = pswd.getText().toString();
                String repass = cpass.getText().toString();
                String phoneNo = phone.getText().toString();
                String email = mail.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("") || phoneNo.equals("") || email.equals(""))
                    Toast.makeText(RegistrationForm.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = Mydb.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = Mydb.insertData(user, pass, phoneNo, email);
                            if (insert == true) {
                                Toast.makeText(RegistrationForm.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), userDetails.class);

                                intent.putExtra("us_name",user);
                                intent.putExtra("mobile",phoneNo);
                                intent.putExtra("emailid",email);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegistrationForm.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegistrationForm.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistrationForm.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent1);
            }
        });
    }
    }
