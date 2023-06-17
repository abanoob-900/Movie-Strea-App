package com.freed.movie_stree_app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.freed.movie_stree_app.MovieDetailsActivity;
import com.freed.movie_stree_app.R;
import com.freed.movie_stree_app.model.BannerMovies;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class BannerPagerAdapter extends PagerAdapter {

    private List<BannerMovies> bannerMovies;
    private Context context;

    public BannerPagerAdapter(List<BannerMovies> bannerMovies, Context context) {
        this.bannerMovies = bannerMovies;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bannerMovies.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.banner_movies_item, container, false);

        BannerMovies banner = bannerMovies.get(position);

        ImageView iv = view.findViewById(R.id.ivBannerMovies);

        Glide.with(context).load(banner.getImageUrl()).into(iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("nameMovie", banner.getMovieName());
                intent.putExtra("imageMovie", banner.getImageUrl());
                intent.putExtra("fileUrl", banner.getFileUrl());
                context.startActivity(intent);
            }
        });

        container.addView(view);

        return view;
    }
}
