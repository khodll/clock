package com.example.clockapp;

import java.time.LocalTime;

public class City {
    private LocalTime time;
    private String cityName;
    private String time12;
    private String time24;

    public City(LocalTime time, String cityName) {
        this.time = time;
        this.cityName = cityName;
        this.time24 = convertTimeString(time);
        this.time12 = convertTo12(time24);
    }


    public String convertTo12 (String time24){
        String[] timeSplit = time24.split(":");
        int hour=Integer.parseInt(timeSplit[0]);
        int minute=Integer.parseInt(timeSplit[1]);
        String minString="";
        if (minute<10){
            minString="0"+minute;
        }
        else{
            minString=timeSplit[1];
        }

        if (hour>12){
            return (hour-12)+":"+minString+"PM";
        }
        else if(hour==12){
            return hour+":"+minString+"PM";
        }
        else if(hour==0){
            return "12:"+minString+"AM";
        }
        else{
            return hour+":"+minString+"AM";
        }

    }

    public String convertTimeString(LocalTime time) {
        int hour=time.getHour();
        int minute=time.getMinute();
        String minString="";
        String hourString="";
        if (minute<10){
            minString="0"+minute;
        }
        else{
            minString=Integer.toString(minute);
        }
        if (hour==0){
            hourString="00";
        }
        else{
            hourString=Integer.toString(hour);
        }
        return hourString+":"+minString;

    }

    public String getTime12() {
        return time12;
    }

    public void setTime12(String time12) {
        this.time12 = time12;
    }

    public String getTime24() {
        return time24;
    }

    public void setTime24(String time24) {
        this.time24 = time24;
    }


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
        this.time24=convertTimeString(time);
        this.time12=convertTo12(this.time24);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
