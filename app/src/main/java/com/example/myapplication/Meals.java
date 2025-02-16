package com.example.myapplication;

public class Meals {
    String Meal;
    String caloriesValue;
    String proteinValue;
    String description;
    String BitMap;

    public Meals() {
    }

    public Meals(String meal, String caloriesValue, String proteinValue, String description, String bitMap) {
        this.Meal = meal;
        this.caloriesValue = caloriesValue;
        this.proteinValue = proteinValue;
        this.description = description;
        this.BitMap = bitMap;
    }

    public String getMeal() {
        return Meal;
    }

    public void setMeal(String meal) {
        this.Meal = meal;
    }

    public String getCaloriesValue() {
        return caloriesValue;
    }

    public void setCaloriesValue(String caloriesValue) {
        this.caloriesValue = caloriesValue;
    }

    public String getProteinValue() {
        return proteinValue;
    }

    public void setProteinValue(String protienValue) {
        this.proteinValue = protienValue;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getBitMap() {
        return BitMap;
    }

    public void setBitMap(String bitMap) {
        this.BitMap = bitMap;
    }
}
