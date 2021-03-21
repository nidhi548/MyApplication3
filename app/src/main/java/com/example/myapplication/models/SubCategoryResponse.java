package com.example.myapplication.models;

import java.util.ArrayList;

public class SubCategoryResponse {
    private boolean error;
    private int count;
    private ArrayList<SubCategory> data;

    public SubCategoryResponse(boolean error, int count, ArrayList<SubCategory> data) {
        this.error = error;
        this.count = count;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<SubCategory> getData() {
        return data;
    }

    public void setData(ArrayList<SubCategory> data) {
        this.data = data;
    }
}
