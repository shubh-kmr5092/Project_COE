package com.example.project_coe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class PhotoAlbum extends AppCompatActivity {

    ImageView myImageView;
    Button   myNextButton,myPreviousButton;
    ToggleButton myStartToggleButton;

    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_album);


        myNextButton=(Button)findViewById(R.id.NextButton);
        myPreviousButton=(Button)findViewById(R.id.PreviousButton);
        myImageView=(ImageView)findViewById(R.id.ImageView);
        myStartToggleButton=(ToggleButton)findViewById(R.id.startTB);

        myNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==0)
                {
                    myImageView.setImageResource(R.drawable.wipro);
                    flag=1;
                }
                else if(flag==1)
                {
                    myImageView.setImageResource(R.drawable.flower);
                    flag=2;
                }
                else  if(flag==2)
                {
                    myImageView.setImageResource(R.drawable.dhoni);
                    flag=0;

                }


            }
        });
        myPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==0)
                {
                    myImageView.setImageResource(R.drawable.dhoni);
                    flag=2;
                }
                else if(flag==1)
                {
                    myImageView.setImageResource(R.drawable.wipro);
                    flag=0;
                }
                else  if(flag==2)
                {
                    myImageView.setImageResource(R.drawable.flower);
                    flag=1;

                }

            }
        });
        myStartToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



            }

        });

    }
}