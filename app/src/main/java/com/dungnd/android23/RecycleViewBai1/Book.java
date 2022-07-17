package com.dungnd.android23.RecycleViewBai1;

public class Book {
    private int resourceId;
    private String name;
    private String fan;
    private String baiviet;
    private String nhom;

    public Book(int resourceId, String name, String fan, String baiviet, String nhom) {
        this.resourceId = resourceId;
        this.name = name;
        this.fan = fan;
        this.baiviet = baiviet;
        this.nhom = nhom;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public String getBaiviet() {
        return baiviet;
    }

    public void setBaiviet(String baiviet) {
        this.baiviet = baiviet;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }
}

