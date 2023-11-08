package com.example.baitap_appdocbao;

public class Tin {
    private String title;
    private  int img;
    private String thoigian;
    private String mota;
    private String link;

    public Tin(String title, int img, String thoigian, String mota, String link) {
        this.title = title;
        this.img = img;
        this.thoigian = thoigian;
        this.mota = mota;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }}
