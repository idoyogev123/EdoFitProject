package com.example.myapplication;

public class Cardio {
    String Day;
    String ExName;
    String ExLength;

    public Cardio(String day, String exName, String exLength) {
        Day = day;
        ExName = exName;
        ExLength = exLength;
    }

    public Cardio() {
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getExName() {
        return ExName;
    }

    public void setExName(String exName) {
        ExName = exName;
    }

    public String getExLength() {
        return ExLength;
    }

    public void setExLength(String exLength) {
        ExLength = exLength;
    }
}
