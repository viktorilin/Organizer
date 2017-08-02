package com.example.asus.organizer;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_contact,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.contact_recycler_view);

        recyclerView.setHasFixedSize(true);//встановлюємо фіксований розмір для ліста
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        List<Contact> data = getDataList();
        ContactAdapterRecycleView contactAdapterRecycleView = new ContactAdapterRecycleView(data);
        recyclerView.setAdapter(contactAdapterRecycleView);
        recyclerView.invalidate();


        recyclerView.setLayoutManager(manager);
        return view;

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
