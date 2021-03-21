package com.example.myapplication.models;

public class SubCategory {
    private String subName;
    private int subId;

    public SubCategory(String subName, int subId) {
        this.subName = subName;
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }
}
