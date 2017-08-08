package com.example.asus.organizer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import com.activeandroid.util.Log;


public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("log","!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("hello world");
        Adapter adapter = new Adapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(adapter);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.titleTab);
        pagerTabStrip.setTabIndicatorColor(Color.BLUE);


    }



}

