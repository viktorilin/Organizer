package com.example.asus.organizer;

    import com.activeandroid.Model;
    import com.activeandroid.annotation.Column;
    import com.activeandroid.annotation.Table;

    import java.util.Date;

/**
 * Created by Asus on 02.08.2017.
 */
@Table(name = "Notification")
public class Notification extends Model {


    @Column(name = "Description")
    private String description;

    @Column(name = "Title")
    private String title;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Melody")
    private String melody;

    @Column(name = "Image")
    private Integer image;



    public Notification() {
    }

    public Notification(String description, String title, Date date, String melody, Integer image) {
        this.description = description;
        this.title = title;
        this.date = date;
        this.melody = melody;
        this.image = image;
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
