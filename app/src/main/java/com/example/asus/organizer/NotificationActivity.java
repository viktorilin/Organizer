package com.example.asus.organizer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.activeandroid.util.Log;

import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EActivity(R.layout.activity_contact)
public class NotificationActivity extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private EditText notificationAddTitleEditText;
    private EditText notificationAddDescriptionEditText;
    private DatePicker notificationAddDatePicker;
    private TimePicker notificationAddTimePicker;
    private Button notificationAddSaveBtn;
    private Button notificationAddGoToPickDateButton;
    private Button notificationAddSetDateButton;
    private TextView notificationAddShowPickedDateTextView;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {


        final NotificationDAO notificationDAO = new NotificationDAO();

        final View view = inflater.inflate(R.layout.activity_notification, null);


        floatingActionButton = (FloatingActionButton)
                view.findViewById(R.id.addNotificationFloatingActionButton);
        recyclerView = (RecyclerView)
                view.findViewById(R.id.notification_recycler_view);
        recyclerView.setHasFixedSize(true);//встановлюємо фіксований розмір для ліста
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);


        final List<Notification> data = notificationDAO.getAll();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewAdd) {

                final Notification notification = new Notification();
                final Date date = new Date();

                viewAdd = getLayoutInflater(null).inflate(R.layout.add_notification_dialog, null);
                final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();

                builder.setView(viewAdd);
                builder.show();

                notificationAddTitleEditText = (EditText)
                        viewAdd.findViewById(R.id.notification_add_title_editTxt);
                notificationAddDescriptionEditText = (EditText)
                        viewAdd.findViewById(R.id.notification_add_description_edtText);
                notificationAddTimePicker = (TimePicker)
                        viewAdd.findViewById(R.id.notification_add_timePicker);
                notificationAddSaveBtn = (Button)
                        viewAdd.findViewById(R.id.notification_add_save_button);
                notificationAddGoToPickDateButton = (Button)
                        viewAdd.findViewById(R.id.notification_add_go_to_date_picker);
                notificationAddShowPickedDateTextView = (TextView)
                        viewAdd.findViewById(R.id.notification_add_show_picked_date_textView);

                notificationAddSaveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        notification.setDescription
                                (notificationAddDescriptionEditText.getText().toString());
                        notification.setTitle
                                (notificationAddTitleEditText.getText().toString());
                        date.setHours
                                (notificationAddTimePicker.getCurrentHour());
                        date.setMinutes
                                (notificationAddTimePicker.getCurrentMinute());
                        date.setSeconds(0);
                        notification.setImage(R.mipmap.ic_launcher);
                        notification.setDate(date);
                        notificationDAO.createNotification(notification);
                        Toast.makeText(getActivity(), "save", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                });

                notificationAddGoToPickDateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View viewAddDatePicker) {
                        viewAddDatePicker = getLayoutInflater(null).inflate(R.layout.add_notification_dialog_date, null);
                        final AlertDialog builderAddDate = new AlertDialog.Builder(getActivity()).create();
                        builderAddDate.setView(viewAddDatePicker);
                        builderAddDate.show();
                        notificationAddDatePicker = (DatePicker)
                                viewAddDatePicker.findViewById(R.id.notification_add_date_picker);
                        notificationAddSetDateButton = (Button)
                                viewAddDatePicker.findViewById(R.id.notification_set_date_button);
                        notificationAddSetDateButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                date.setDate(notificationAddDatePicker.getDayOfMonth());
                                date.setMonth(notificationAddDatePicker.getMonth());
                                date.setYear(notificationAddDatePicker.getYear());
                                notification.setDate(date);
                                notificationAddShowPickedDateTextView.setText(date.toString());
                                builderAddDate.dismiss();
                            }
                        });
                    }
                });
            }
        });
        NotificationAdapterRecycleView notificationAdapterRecycleView = new NotificationAdapterRecycleView(data);
        recyclerView.setAdapter(notificationAdapterRecycleView);
        recyclerView.invalidate();
        recyclerView.setLayoutManager(manager);

        return view;
    }

}
