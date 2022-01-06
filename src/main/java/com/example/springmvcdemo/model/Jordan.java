package com.example.springmvcdemo.model;

import java.util.Date;

public class Jordan {

    private String firstName;
    private String lastName;
    private String nickName;
    private String position;
    private String height;
    private int weight;
    private Date dob;

    public Jordan(String firstName, String lastName, String nickName, String position, String height, int weight, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
