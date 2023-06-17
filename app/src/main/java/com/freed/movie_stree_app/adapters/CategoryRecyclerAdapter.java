package com.freed.movie_stree_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freed.movie_stree_app.R;
import com.freed.movie_stree_app.model.AllCategory;
import com.freed.movie_stree_app.model.CategoryItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder> {

    private Context context;
    private List<AllCategory> allCategoryList;

    public CategoryRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.recycler_main_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        AllCategory allCategory = allCategoryList.get(position);

        holder.tvCategory.setText(allCategory.getCategoryTitle());

        setItemCategory(holder.recyclerView, allCategory.getCategoryItemList());
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategory;
        RecyclerView recyclerView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCategory = itemView.findViewById(R.id.tvCategoryAdapter);
            recyclerView = itemView.findViewById(R.id.recyclerViewItem);
        }
    }

    public void setItemCategory(RecyclerView recyclerView, List<CategoryItem> categoryItemList) {

        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(context, categoryItemList);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(itemRecyclerAdapter);
    }
}
