package com.example.asus.organizer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 02.08.2017.
 */

public class NotificationAdapterRecycleView extends
        RecyclerView.Adapter<NotificationAdapterRecycleView.CardViewHolder>{

    List<Notification> notifications;

    public NotificationAdapterRecycleView(List<Notification> list) {
        this.notifications = list;
    }

    @Override
    public NotificationAdapterRecycleView.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_cards_layout,parent,false);
        return new NotificationAdapterRecycleView.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationAdapterRecycleView.CardViewHolder holder, int position) {
        Notification notification = notifications.get(position);
        holder.notificationDescriptionTextView.setText(notification.getDescription());
        holder. notificationTitleTextView.setText(notification.getTitle());
        holder. notificationImageView.setImageResource( notification.getImage());
        holder.notificationDateTextView.setText(notification.getDate().toString());
    }
    public void removeItem(int position){
        notifications.remove(position);
        notifyItemChanged(position);
    }


    @Override
    public int getItemCount() {
        return notifications.size();
    }



    public static class CardViewHolder extends RecyclerView.ViewHolder{
        protected TextView notificationTitleTextView;
        protected TextView notificationDescriptionTextView;
        protected ImageView  notificationImageView;
        protected TextView notificationDateTextView;

        public CardViewHolder(View itemView) {
            super(itemView);
            notificationTitleTextView = (TextView) itemView.findViewById(R.id.notification_title);
            notificationDescriptionTextView = (TextView) itemView.findViewById(R.id.notification_description);
            notificationDateTextView = (TextView) itemView.findViewById(R.id.notification_date);
            notificationImageView = (ImageView) itemView.findViewById(R.id.notification_photo);
        }


    }
}
