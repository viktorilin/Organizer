package com.example.asus.organizer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {


    private RecyclerView recyclerView;
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

        recyclerView = (RecyclerView) findViewById(R.id.contact_recycler_view);

        recyclerView.setHasFixedSize(true);//встановлюємо фіксований розмір для ліста
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        List<Contact> data = getDataList();
        ContactAdapterRecycleView contactAdapterRecycleView = new ContactAdapterRecycleView(data);
        recyclerView.setAdapter(contactAdapterRecycleView);
        recyclerView.invalidate();


        recyclerView.setLayoutManager(manager);


    }

    private List<Contact> getDataList() {

        List<Contact> list = new ArrayList<>();
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));
        list.add(new Contact("name", "+1234", R.mipmap.ic_launcher));


        return list;
    }


}

