package com.dungnd.android23;

public class ItemUser {
    private int anh;
    private String title;
    private String fan;
    private String baivietmoinhat;
    private String nhom;

    public ItemUser(int anh, String title, String fan, String baivietmoinhat, String nhom) {
        this.anh = anh;
        this.title = title;
        this.fan = fan;
        this.baivietmoinhat = baivietmoinhat;
        this.nhom = nhom;
    }

    public int getAnh() {
        return anh;
    }

    public String getTitle() {
        return title;
    }

    public String getFan() {
        return fan;
    }

    public String getBaivietmoinhat() {
        return baivietmoinhat;
    }

    public String getNhom() {
        return nhom;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public void setBaivietmoinhat(String baivietmoinhat) {
        this.baivietmoinhat = baivietmoinhat;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }
}
