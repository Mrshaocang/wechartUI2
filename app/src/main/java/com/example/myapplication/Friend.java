package com.example.myapplication;

public class Friend {

    private int id;
    private int imageId;
    private String name;

    public Friend(int id, int imageId, String name) {
        this.id = id;
        this.imageId = imageId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
