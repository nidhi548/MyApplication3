package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activities.SubCategoryActivity;
import com.example.myapplication.app.Config;
import com.example.myapplication.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Category> mList = new ArrayList<>();

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_product, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = mList.get(position);
        holder.textViewCategoryName.setText(category.getCatName());
        // holder.textViewCategoryId.setText(category.getCatId());
        Log.d("abcd", String.valueOf(category));
        Picasso
                .get()
                .load(Config.IMAGE_URL + category.getImage())
                .into(holder.imageViewCategory);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SubCategoryActivity.class);
                Log.d("abcd", category.getCatId());
                intent.putExtra("catId", category.getCatId());
                mContext.startActivity(intent);
            }
        });

    }


    public int getItemCount() {
        return mList.size();
    }

    public void setData(ArrayList<Category> list) {
        mList = list;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategoryName, textViewCategoryId;
        ImageView imageViewCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewCategoryName = itemView.findViewById(R.id.text_view_category_name);
            textViewCategoryId = itemView.findViewById(R.id.text_view_price_adapter);
            imageViewCategory = itemView.findViewById(R.id.image_view_category);
        }


    }
}
