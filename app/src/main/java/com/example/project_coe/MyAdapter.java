package com.example.project_coe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.View.*;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] data;
    Context context;
    int images[];


    public MyAdapter(Context ct, String s1[],int[] img) {

        context = ct;
        data=s1;
        images=img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtTittle.setText(data[position]);
        holder.imgIcon.setImageResource(images[position]);


        holder.parent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data[position].equals("Calculator"))
                {

                    Intent intent = new Intent(context,Calculator.class);
                    context.startActivity(intent);
                }
               else if(data[position].equals("Media List"))
                {
                    Intent intent = new Intent(context,MediaList.class);
                    context.startActivity(intent);
                }
              else if(data[position].equals("Photo Album"))
                {
                    Intent intent = new Intent(context,PhotoAlbum.class);
                    context.startActivity(intent);
                }
                else if(data[position].equals("Background Color"))
                {
                    Intent intent = new Intent(context,background_color.class);
                    context.startActivity(intent);
                }


                else if(data[position].equals("Set Wallpaper"))
                {
                   // Intent intent = new Intent(context,setWallpaper.class);
                   // context.startActivity(intent);
                    Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setType("image/*");
                intent.putExtra("mimeType", "image/jpeg");
                context.startActivity(Intent.createChooser(intent, "Set as:"));
                }


                else if(data[position].equals("Notification App"))

                {
                    //Intent intent = new Intent(context,notificationApp.class);
                  //  context.startActivity(intent);

                    Intent intent = new Intent();
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("app_package", context.getPackageName());
                    intent.putExtra("app_uid", context.getApplicationInfo().uid);
                    intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                    context.startActivity(intent);

                }

                else if(data[position].equals("Broadcast App"))

                {
                    Intent intent = new Intent(context,broadcastApp.class);
                    context.startActivity(intent);

                }

                else if(data[position].equals("Service App"))

                {
                    Intent intent = new Intent(context,ServiceApp.class);
                    context.startActivity(intent);

                }




            }
        });




            }


    @Override
    public int getItemCount() {

        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgIcon;
        TextView txtTittle;
        LinearLayout parent;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon= itemView.findViewById(R.id.imgIcon);
            txtTittle = itemView.findViewById(R.id.txtTittle);
            parent= itemView.findViewById(R.id.parentLayout);


        }
    }
}