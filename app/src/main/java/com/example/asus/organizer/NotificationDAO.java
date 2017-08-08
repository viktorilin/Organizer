package com.example.asus.organizer;

import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 08.08.2017.
 */
public class NotificationDAO implements INotificationDAO{

    public List<Notification> notifications = new ArrayList<Notification>();

    public NotificationDAO() {
    }


    @Override
    public List<Notification> getAll() {
        List<Notification> list =  new Select().from(Notification.class)
                .orderBy("Id ASC")
                .execute();
        return list;
    }

    @Override
    public Notification getNotification(int id) {
        try {
            Notification notification = new Select().from(Notification.class).where("Id = ?", id).executeSingle();
            return notification;
        }catch (Exception e)
        {
            System.out.println("No notification with id");
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void createNotification(Notification notification) {
        notification.save();
    }

    @Override
    public void updateNotification(Notification notification) {
        String updateSet = " Description = " + notification.getDescription()+
                ", Title = "+ notification.getTitle() + ", Date = " +
                notification.getDate().toString() + ", Melody = "+notification.getMelody()+
                ", Image" + notification.getImage().toString();
        new Update(Notification.class)
                .set(updateSet)
                .where("Id = ?", notification.getId())
                .execute();
    }

    @Override
    public void deleteNotification(int id) {
        new Delete().from(Notification.class).where("Id = ?", id).execute();
    }

    @Override
    public void showAll() {

    }
}
