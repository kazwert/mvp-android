package com.nbs.mvpsample.data.sharedmodel;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ghiyatshanif on 3/2/17.
 */

@Entity
public class Email {


    /**
     * id : 1
     * isImportant : false
     * picture : http://api.androidhive.info/json/google.png
     * from : Google Alerts
     * subject : Google Alert - android
     * message : Now android supports multiple voice recogonization
     * timestamp : 10:30 AM
     * isRead : false
     */

    @Id
    @SerializedName("id")
    private long id;
    @SerializedName("isImportant")
    private boolean isImportant;
    @SerializedName("picture")
    private String picture;
    @SerializedName("from")
    private String from;
    @SerializedName("subject")
    private String subject;
    @SerializedName("message")
    private String message;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("isRead")
    private boolean isRead;

    @Transient
    private int color;


    @Generated(hash = 592279264)
    public Email(long id, boolean isImportant, String picture, String from,
            String subject, String message, String timestamp, boolean isRead) {
        this.id = id;
        this.isImportant = isImportant;
        this.picture = picture;
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.timestamp = timestamp;
        this.isRead = isRead;
    }

    @Generated(hash = 272676561)
    public Email() {
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean getIsImportant() {
        return this.isImportant;
    }

    public boolean getIsRead() {
        return this.isRead;
    }

    public void setId(long id) {
        this.id = id;
    }
}
