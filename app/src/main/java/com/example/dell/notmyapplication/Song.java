package com.example.dell.notmyapplication;


import java.util.ArrayList;

public class Song {

    private String Name, Year;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public Song() {
    }

    public Song(String name, String year) {
        Name = name;
        Year = year;
    }



}
