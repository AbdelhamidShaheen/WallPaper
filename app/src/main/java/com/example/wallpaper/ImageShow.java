package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class ImageShow extends AppCompatActivity {
    ImageView imageView;
    ImageButton imageButton;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        try {
            Intent intent = getIntent();
            image = intent.getIntExtra("a", R.drawable.food1);
            imageView = (ImageView) findViewById(R.id.ImageShow);
            imageView.setImageResource(image);
        } catch (Exception e) {
            print(e.getMessage());
        }
        imageButton = (ImageButton) findViewById(R.id.ShowButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
                //  try {
                //       manager.setResource(image);
                //  } catch (IOException e) {
                //     print(e.getMessage());
                //  }finally {
                //  print("Image is loaded");
                //  }
                print(image + "");
            }
        });


    }

    private void print(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

    }
}
