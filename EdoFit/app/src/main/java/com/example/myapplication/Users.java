package com.example.myapplication;

public class Users{
    String email;
    String password;
    String fname;
    String height;
    String weight;
    String age;
    String goal;

    public Users() {
    }

    public Users(String email, String password, String fname, String height, String weight, String age, String goal) {
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.goal=goal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
