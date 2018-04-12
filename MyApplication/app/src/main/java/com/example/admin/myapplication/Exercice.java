package com.example.admin.myapplication;

/**
 * Created by admin on 12/04/2018.
 */

public class Exercice {

    private String description;
    private String name;
    private String creation_date;

    public Exercice(String description, String name, String creation_date) {
        this.description = description;
        this.name = name;
        this.creation_date = creation_date;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getCreation_date() {
        return creation_date;
    }
}
