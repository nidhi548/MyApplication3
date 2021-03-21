package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.app.Config;
import com.example.myapplication.models.Product;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Product> mList = new ArrayList<>();

    public ProductAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_product_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = mList.get(position);
        holder.textViewProductName.setText(product.getPname());
        holder.textViewProductPrice.setText("Rs."+ String.valueOf(product.getPrice())+"/-");
        holder.textViewQuantity.setText("Quanity: "+String.valueOf(product.getQuantity()));
// Create a DividerItemDecoration whose orientation is vertical
        DividerItemDecoration vItemDecoration = new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL);
        // Set the drawable on it
//        vItemDecoration.setDrawable(mDivider);
        Picasso
                .get()
                .load(Config.IMAGE_URL+ product.getImage())
                .into(holder.imageViewProduct);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(ArrayList<Product> list){
        mList = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewProductName, textViewProductPrice, textViewQuantity;
        ImageView imageViewProduct;

        public ViewHolder(View itemView){
            super(itemView);
            textViewProductName = itemView.findViewById(R.id.text_view_product_name_adapter);
            textViewProductPrice = itemView.findViewById(R.id.text_view_price_fragment);
            textViewQuantity = itemView.findViewById(R.id.text_view_price_adapter);
            imageViewProduct = itemView.findViewById(R.id.image_view_adapter);
        }

    }
}
