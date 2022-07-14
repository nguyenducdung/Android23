package com.dungnd.android23.buoi4;

public class Buoi4Bai1 {
    private int hinh;
    private String tennhom;
    private String fan;
    private String baiviet;
    private String trangthai;


    public Buoi4Bai1() {
    }

    public Buoi4Bai1(int hinh, String tennhom, String fan, String baiviet, String trangthai) {
        this.hinh = hinh;
        this.tennhom = tennhom;
        this.fan = fan;
        this.baiviet = baiviet;
        this.trangthai = trangthai;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTennhom() {
        return tennhom;
    }

    public void setTennhom(String tennhom) {
        this.tennhom = tennhom;
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

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
