package com.freed.movie_stree_app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.freed.movie_stree_app.MovieDetailsActivity;
import com.freed.movie_stree_app.R;
import com.freed.movie_stree_app.model.AllCategory;
import com.freed.movie_stree_app.model.CategoryItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;

    public ItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ItemViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.category_main_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        CategoryItem categoryItem = categoryItemList.get(position);

        Glide.with(context).load(categoryItem.getImageUrl()).into(holder.ivCategory);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("nameMovie", categoryItem.getMovieName());
                intent.putExtra("imageMovie", categoryItem.getImageUrl());
                intent.putExtra("fileUrl", categoryItem.getFileUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCategory;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCategory = itemView.findViewById(R.id.ivCategoryItem);
        }
    }
}
