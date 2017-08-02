package com.example.asus.organizer;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Asus on 01.08.2017.
 */

public class Contact {

    private String name;

    private String numberOfPhone;

    private Integer image;

    //img
    //melody

    public Contact() {
    }


    public Contact(String name, String numberOfPhone, Integer image) {
        this.name = name;
        this.numberOfPhone = numberOfPhone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
