package com.example.asus.organizer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationActivity extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_notification ,null);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.addNotificationFloatingActionButton);
        recyclerView = (RecyclerView) view.findViewById(R.id.notification_recycler_view);
        recyclerView.setHasFixedSize(true);//встановлюємо фіксований розмір для ліста
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        List<Notification> data = getDataList();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("New Notification");

                alertDialog.setView(R.layout.add_notification_dialog);
                alertDialog.setPositiveButton("Save",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                Toast.makeText(getActivity(),"Password Matched", Toast.LENGTH_SHORT).show();
                            }
                        });
                alertDialog.show();
            }

        });
        NotificationAdapterRecycleView notificationAdapterRecycleView = new NotificationAdapterRecycleView(data);
        recyclerView.setAdapter(notificationAdapterRecycleView);
        recyclerView.invalidate();
        recyclerView.setLayoutManager(manager);


        return view;
    }
    private List<Notification> getDataList() {

        List<Notification> list = new ArrayList<>();
        Date date = new Date(2012,11,12);
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));
        list.add(new Notification(1,"description","title",date,"melody",R.mipmap.ic_launcher));

        return list;
    }
}
