package com.example.eltiempo;

//Igual que forecast

public class Parent {
    String title;
    String location_type;
    long woeid;
    String latt_long;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public long getWoeid() {
        return woeid;
    }

    public void setWoeid(long woeid) {
        this.woeid = woeid;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }
}
