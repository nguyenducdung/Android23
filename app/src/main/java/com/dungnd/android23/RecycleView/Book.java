package com.dungnd.android23.RecycleView;

public class Book {
    private int resourceId;
    private String name;

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public Book(int resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }
}
