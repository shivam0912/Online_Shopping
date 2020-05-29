package com.example.onlineshopping.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;
import com.example.onlineshopping.ui.contact.ContactFragment;
import com.example.onlineshopping.ui.help.HelpFragment;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
   private List<HomeData> productList;

    public HomeAdapter(Context context, List<HomeData> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final ViewHolder view =  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.products,parent,false));;

        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        HomeData homeData = productList.get(position);
        if(homeData != null) {
            holder.productName.setText(homeData.getProductName());
            holder.stock.setText(homeData.getCheckStock());
            holder.productPrice.setText(homeData.getPrice());

        }
    }

    @Override
    public int getItemCount() {
        return productList != null? productList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageButton productImage;
        private TextView productName;
        private TextView stock;
        private TextView productPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           productImage = itemView.findViewById(R.id.product_image);

            productName = itemView.findViewById(R.id.product_name);
            stock = itemView.findViewById(R.id.product_stock);
            productPrice = itemView.findViewById(R.id.product_price);

        }
    }
}
