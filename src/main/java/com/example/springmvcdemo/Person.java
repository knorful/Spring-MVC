package com.example.springmvcdemo;

import java.sql.Date;

public class Person {

    private String name;
    private String street1;
    private String street2;
    private String birthday;

    public Person(String name, String street1, String street2, String birthday) {
        this.name = name;
        this.street1 = street1;
        this.street2 = street2;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
