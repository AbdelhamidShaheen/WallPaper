package com.example.wallpaper;


import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.io.IOException;
import java.util.ArrayList;

public class Adabter extends RecyclerView.Adapter<Adabter.MyViewHolder> {

    ArrayList<Integer> arrayList;
    int tag;
    Context context;

    Adabter(Context context, ArrayList<Integer> arrayList, int tag) {
        this.arrayList = arrayList;
        this.tag = tag;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1, imageView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.ImageItem);
            imageView2 = itemView.findViewById(R.id.ImageItem2);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if (tag == 1) {

            holder.imageView2.setImageResource(arrayList.get(position));
            holder.imageView1.setVisibility(View.GONE);
        } else {
            holder.imageView1.setImageResource(arrayList.get(position));
            holder.imageView2.setVisibility(View.GONE);
        }
        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(context, ImageShow.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("a", arrayList.get(position));
                    context.startActivity(intent);
                } catch (Exception e) {
                    print(e.getMessage());
                }

            }
        });
        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageShow.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("a", arrayList.get(position));
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    void print(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }


}

