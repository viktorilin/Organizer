package com.example.asus.organizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 08.08.2017.
 */

public interface INotificationDAO {

    List<Notification> getAll();

    Notification getNotification(int id);

    void createNotification(Notification notification);

    void updateNotification(Notification notification);

    void deleteNotification(int id);

    void showAll();
}
