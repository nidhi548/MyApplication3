package com.example.myapplication.models;

public class Category {

    private String catName;
    private String catImage;
    private String catId;

    public Category()
    {

    }

    public Category(String catName, String image, String catId) {
        this.catName = catName;
        this.catImage = image;
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getImage() {
        return catImage;
    }

    public void setImage(String image) {
        this.catImage = image;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
}
