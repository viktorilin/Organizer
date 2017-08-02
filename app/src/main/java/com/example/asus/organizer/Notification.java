package com.example.asus.organizer;

    import java.util.Date;

/**
 * Created by Asus on 02.08.2017.
 */

public class Notification {

    private Integer id;

    private String description;

    private String title;

    private Date date;

    private String melody;

    private Integer image;

    public Notification(Integer id, String description, String title, Date date, String melody, Integer image) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.date = date;
        this.melody = melody;
        this.image = image;
    }

    public Notification() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMelody() {
        return melody;
    }

    public void setMelody(String melody) {
        this.melody = melody;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
