package com.example.ytumezunandroidapp;

public class AnnouncementModel {

    // Her duyuru; görsel, başlık ve tarih içermektedir
    public int image;
    public String header;
    public String date;

    public AnnouncementModel(int image, String header, String date){
        this.image = image;
        this.header = header;
        this.date = date;
    }
}