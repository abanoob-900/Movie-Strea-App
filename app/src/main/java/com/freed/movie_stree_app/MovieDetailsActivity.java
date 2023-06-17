package com.freed.movie_stree_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView iv;
    TextView tvName;
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        iv = findViewById(R.id.ivMovieDetails);
        tvName = findViewById(R.id.tvNameDetails);
        btnPlay = findViewById(R.id.btnPlay);

        Intent intent = getIntent();

        Glide.with(this).load(intent.getStringExtra("imageMovie")).into(iv);
        tvName.setText(intent.getStringExtra("nameMovie"));

        String fileUrl = intent.getStringExtra("fileUrl");

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(), VideoPlayerActivity.class);
                intent1.putExtra("url", fileUrl);
                startActivity(intent1);
            }
        });
    }
}