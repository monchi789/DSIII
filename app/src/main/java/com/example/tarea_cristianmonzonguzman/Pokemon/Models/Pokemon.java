package com.example.tarea_cristianmonzonguzman.Pokemon.Models;

public class Pokemon {

    // Define the variables
    private String name;
    private String url;
    private int number;

    // Methods get and set
    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // URL
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Number
    public int getNumber() {
        String[] urlParts = url.split("/");
        return Integer.parseInt(urlParts[urlParts.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
