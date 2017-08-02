package com.example.asus.organizer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


public class MainActivity extends FragmentActivity {

    private final static String KEY = "key";
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter = new Adapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(adapter);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.titleTab);
        pagerTabStrip.setTabIndicatorColor(Color.BLUE);


    }



}

