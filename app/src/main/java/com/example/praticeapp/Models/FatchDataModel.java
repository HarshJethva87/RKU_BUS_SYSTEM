package com.example.praticeapp.Models;

public class FatchDataModel {

    private final String Date,BusTime,Pickup,Drop;


    public FatchDataModel(String date, String busTime, String pickup, String drop) {
        Date = date;
        BusTime = busTime;
        Pickup = pickup;
        Drop = drop;
    }

    public String getDate() {
        return Date;
    }

    public String getBusTime() {
        return BusTime;
    }

    public String getPickup() {
        return Pickup;
    }

    public String getDrop() {
        return Drop;
    }
}
