package com.example.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("productName")
    private String pname;
    private double price;
    private String image;
    private int quantity;

    public Product(String pname, double price, String image,int quantity) {
        this.pname = pname;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}