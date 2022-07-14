package com.dungnd.android23.buoi4;

public class Buoi4Bai3 {
    private int hinhthumuc;
    private String tenthumuc;
    private int hinhsua;
    private int hinhxoa;

    public Buoi4Bai3() {
    }

    public Buoi4Bai3(int hinhthumuc, String tenthumuc, int hinhsua, int hinhxoa) {
        this.hinhthumuc = hinhthumuc;
        this.tenthumuc = tenthumuc;
        this.hinhsua = hinhsua;
        this.hinhxoa = hinhxoa;
    }

    public int getHinhthumuc() {
        return hinhthumuc;
    }

    public void setHinhthumuc(int hinhthumuc) {
        this.hinhthumuc = hinhthumuc;
    }

    public String getTenthumuc() {
        return tenthumuc;
    }

    public void setTenthumuc(String tenthumuc) {
        this.tenthumuc = tenthumuc;
    }

    public int getHinhsua() {
        return hinhsua;
    }

    public void setHinhsua(int hinhsua) {
        this.hinhsua = hinhsua;
    }

    public int getHinhxoa() {
        return hinhxoa;
    }

    public void setHinhxoa(int hinhxoa) {
        this.hinhxoa = hinhxoa;
    }
}
