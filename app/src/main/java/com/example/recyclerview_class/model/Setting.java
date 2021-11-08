package com.example.recyclerview_class.model;

import android.widget.ImageView;

public class Setting {
    private int imvRes;
    private  String title;
    private String detail;
    private boolean isChecked;

    public Setting(int imvRes, String title, String detail) {
        this.imvRes = imvRes;
        this.title = title;
        this.detail = detail;
        this.isChecked = false;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getImvRes() {
        return imvRes;
    }

    public void setImvRes(int imvRes) {
        this.imvRes = imvRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "imvRes=" + imvRes +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
