package com.example.myapplication.app;

public class Endpoints {

    private static final String URL_CATEGORY = "category";
    private static final String URL_PRODUCT = "products";
    private static final String URL_REGISTER = "auth/register";
    private static final String URL_SUBCATEGORY = "subcategory/";

    public static String getCategory() {
        return Config.BASE_URL + URL_CATEGORY;
    }

    public static String getAllProducts() {
        return Config.BASE_URL + URL_PRODUCT;
    }

    public static String register() {
        return Config.BASE_URL + URL_REGISTER;
    }

    public static String getAllSubcategory(){  return Config.BASE_URL + URL_SUBCATEGORY;  }

}
