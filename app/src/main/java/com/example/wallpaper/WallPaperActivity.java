package com.example.wallpaper;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class WallPaperActivity extends AppCompatActivity {
    Adabter adabter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_paper);

        initaitCompanet();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.custom);

        } catch (Exception e) {
            print(e.getMessage());
        }

    }

    private void initaitCompanet() {
        recyclerView = findViewById(R.id.recycle_show);
        adabter = new Adabter(getApplicationContext(), ListImage.getFlower(), 0);
        layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adabter);
        //layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);


    }


    void print(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    public void onclick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.flower:
                adabter = new Adabter(getApplicationContext(), ListImage.getFlower(), 0);
                layoutManager = new GridLayoutManager(this, 4);
                break;
            case R.id.food:
                adabter = new Adabter(getApplicationContext(), ListImage.getFood(), 1);
                layoutManager = new GridLayoutManager(this, 2);

                break;
            case R.id.historic:
                adabter = new Adabter(getApplicationContext(), ListImage.getHistoric(), 0);
                layoutManager = new GridLayoutManager(this, 4);
                break;
            case R.id.nature:
                adabter = new Adabter(getApplicationContext(), ListImage.getNature(), 0);
                layoutManager = new GridLayoutManager(this, 4);
                break;

        }
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adabter);
    }


}
