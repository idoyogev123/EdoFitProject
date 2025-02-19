package com.example.myapplication;

public class Diet extends Users
{
    String day;
    String morning;
    String between;
    String lunch;
    String between2;
    String evening;
    String tip;

    public Diet() {
    }

    public Diet(String day, String morning, String between, String lunch, String between2, String evening, String tip) {
        this.day = day;
        this.morning = morning;
        this.between = between;
        this.lunch = lunch;
        this.between2 = between2;
        this.evening = evening;
        this.tip = tip;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getBetween() {
        return between;
    }

    public void setBetween(String between) {
        this.between = between;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getBetween2() {
        return between2;
    }

    public void setBetween2(String between2) {
        this.between2 = between2;
    }

    public String getEvening() {
        return evening;
    }

    public void setEvening(String evening) {
        this.evening = evening;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
