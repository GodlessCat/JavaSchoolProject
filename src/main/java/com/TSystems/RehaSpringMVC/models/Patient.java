package com.TSystems.RehaSpringMVC.models;

public class Patient {
    private int id;
    private String name;
    private String diagnosis;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
