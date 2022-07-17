package com.dungnd.android23.buoi4bai3;

public class Folder {
    private String tv_name;

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public Folder(int ic_folder, String tv_name) {
        this.tv_name = tv_name;
    }
}
