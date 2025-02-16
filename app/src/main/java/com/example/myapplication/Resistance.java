package com.example.myapplication;

public class Resistance {
    String Day;
    String ExName;
    String SetNum;
    String RepNum;

    public Resistance() {
    }

    public Resistance(String day, String exName, String setNum, String repNum) {
        Day = day;
        ExName = exName;
        SetNum = setNum;
        RepNum = repNum;
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

    public String getSetNum() {
        return SetNum;
    }

    public void setSetNum(String setNum) {
        SetNum = setNum;
    }

    public String getRepNum() {
        return RepNum;
    }

    public void setRepNum(String repNum) {
        RepNum = repNum;
    }
}
