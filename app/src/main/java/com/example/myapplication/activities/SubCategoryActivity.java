package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.example.myapplication.adapters.ProductAdapter;
import com.example.myapplication.app.Endpoints;
import com.example.myapplication.models.Product;
import com.example.myapplication.models.SubCategory;
import com.example.myapplication.models.SubCategoryResponse;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ProductAdapter productAdapter;
    ArrayList<Product> mList = new ArrayList<>();
    TabLayout tabLayout;
    List<SubCategory> subCategoryArrayList = new ArrayList<SubCategory>();
//    SubCategory subCategory;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        Intent intent = getIntent();
        message = intent.getStringExtra("catId");
        tabLayout = findViewById(R.id.tab_layout_subcategory);
        Log.d("abcd111", message);
//        System.out.println("abcd"+message);
        init();
    }

    private void init() {
        Log.d("in getday","1");
        getData();
        Log.d("arraylist 123", String.valueOf(subCategoryArrayList.size()));
        for (int i = 0; i < subCategoryArrayList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(subCategoryArrayList.get(i).getSubName()));
            Log.d("subCategoryA", subCategoryArrayList.get(i).getSubName());
        }
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        productAdapter = new ProductAdapter(this);
//        recyclerView.setAdapter(productAdapter);
    }

    private void getData() {

        StringRequest request = new StringRequest(
                Request.Method.GET,
                Endpoints.getAllSubcategory() + message,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("abc response", response);
                        progressBar.setVisibility(View.GONE);
                        Gson gson = new GsonBuilder().create();
                        SubCategoryResponse subCategoryResponse = gson.fromJson(response, SubCategoryResponse.class);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
//                            JSONObject resp = jsonObject.getJSONObject();
//                            Log.d("jsonarray123", String.valueOf(resp));
                            JSONArray jr = jsonObject.getJSONArray("data");
                            Log.d("jsonarray123", String.valueOf(jr.length()));
//                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jr.length(); i++) {
                                JSONObject jsonObject1 = jr.getJSONObject(i);
                                String subName = jsonObject1.getString("subName");
                                int subId = jsonObject1.getInt("subId");
                                SubCategory subCategory = new SubCategory(subName, subId);
                                subCategoryArrayList.add(subCategory);

                            }
//                            su.setData(mList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                        productAdapter.setData(subCategoryResponse.getData());
                        subCategoryArrayList.addAll(subCategoryResponse.getData());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("abc", String.valueOf(error));
                        progressBar.setVisibility(View.GONE);
//                        Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(request);
//        Log.d("sub123", subCategoryArrayList.get(1).getSubName());
    }

//    private void getData() {
//        StringRequest request = new StringRequest(
//                Request.Method.GET,
//                Endpoints.getAllSubcategory()+message,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d("abc response", response);
//                        progressBar.setVisibility(View.GONE);
//                        Gson gson = new GsonBuilder().create();
//                        ProductResponse productResponse = gson.fromJson(response, ProductResponse.class);
//                        productAdapter.setData(productResponse.getData());
//                        mList.addAll(productResponse.getData());
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("abc", String.valueOf(error));
//                        progressBar.setVisibility(View.GONE);
//                        Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//        Volley.newRequestQueue(this).add(request);
//    }
}