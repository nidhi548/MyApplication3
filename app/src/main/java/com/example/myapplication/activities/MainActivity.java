package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.myapplication.R;
import com.example.myapplication.adapters.CategoryAdapter;
import com.example.myapplication.adapters.ViewPagerAdapter;
import com.example.myapplication.app.Endpoints;
import com.example.myapplication.models.Category;
import com.example.myapplication.models.CategoryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


        CategoryAdapter categoryAdapter;
    RecyclerView recyclerView;
    ArrayList<Category> mList = new ArrayList<>();
    ImageSlider imageSlider ;
    List<SlideModel> slideModels = new ArrayList<>();
    LinearLayout linearLayout;


    // images array
    int[] images = {R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4,
            R.drawable.d5};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
        imageSlider = findViewById(R.id.slider);
        init();
    }

    private void init() {

        slideModels.add(new SlideModel(R.drawable.d1,"1"));
        slideModels.add(new SlideModel(R.drawable.d2,"2"));
        slideModels.add(new SlideModel(R.drawable.d3,"3"));
        slideModels.add(new SlideModel(R.drawable.d4,"4"));
        slideModels.add(new SlideModel(R.drawable.d5,"5"));
//        slideModels.add(new SlideModel(R.drawable.d6,"6"));
        imageSlider.setImageList(slideModels,true);

        getData();
        recyclerView = findViewById(R.id.recycler_view_grid);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        categoryAdapter = new CategoryAdapter(this);
        recyclerView.setAdapter(categoryAdapter);
        Intent intent = new Intent(this,SubCategoryActivity.class);

        Category category = new Category();
//        String categoryId = categoryAdapter.getCatId();
//        System.out.println(" cat "+category.getCatId());
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryId = category.getCatId();
//                System.out.println(" cat "+category.getCatId());
                intent.putExtra("catId",categoryId);
                startActivity(intent);
            }
        });

    }

    private void getData() {

        StringRequest request = new StringRequest(
                Request.Method.GET,
                Endpoints.getCategory(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        progressBar.setVisibility(View.GONE);
                        Log.d("abc", response);
                        Gson gson = new GsonBuilder().create();
                        CategoryResponse categoryResponse = gson.fromJson(response, CategoryResponse.class);
                        categoryAdapter.setData(categoryResponse.getData());
                        mList.addAll(categoryResponse.getData());
//                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("abc", error.getMessage());
//                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(request);
    }
}