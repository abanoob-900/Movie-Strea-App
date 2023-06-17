package com.freed.movie_stree_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.freed.movie_stree_app.adapters.BannerPagerAdapter;
import com.freed.movie_stree_app.adapters.CategoryRecyclerAdapter;
import com.freed.movie_stree_app.model.AllCategory;
import com.freed.movie_stree_app.model.BannerMovies;
import com.freed.movie_stree_app.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpBannerMovies;
    private RecyclerView rv;
    private AppBarLayout appBarLayout;
    private NestedScrollView nestedScrollView;
    private BannerPagerAdapter bannerPagerAdapter;
    private CategoryRecyclerAdapter categoryRecyclerAdapter;
    private TabLayout tabIndicator, tabCategory;
    private List<AllCategory> allCategoryList;
    private List<CategoryItem> categoryItems1, categoryItems2, categoryItems3, categoryItems4;
    private List<BannerMovies> homeBannerMoviesList, tvShowsBannerMoviesList,
            moviesBannerMoviesList, kidsBannerMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabCategory = findViewById(R.id.tabCategory);
        appBarLayout = findViewById(R.id.appbar);
        nestedScrollView = findViewById(R.id.nestedScrollView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        homeBannerMoviesList = new ArrayList<>();

        homeBannerMoviesList.add(new BannerMovies(1, "The Suicide Squad",
                "https://cdn.mos.cms.futurecdn.net/axszmq4rkiJwRTNrZj9uw7.jpg", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"));
        homeBannerMoviesList.add(new BannerMovies(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/2644962659fabd13aca9a3821525b0d9d3a2c7f8861470e67461541594e14b86._SX1080_.jpg", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"));
        homeBannerMoviesList.add(new BannerMovies(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/d5e9bc92df2ae13ad8e5c9a9a290a9139ff59b1a6db061d63731fb9dc0ae187b._SX1080_.jpg", ""));
        homeBannerMoviesList.add(new BannerMovies(4, "Addams Family 2",
                "https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_465,q_auto,w_310/v1632398890/amc-cdn/production/2/movies/66500/66489/Poster/Primary_BoxCover_800_1200.jpg", ""));
        homeBannerMoviesList.add(new BannerMovies(5, "X-Men Dark Phoenix",
                "https://lumiere-a.akamaihd.net/v1/images/20cs_xmen_dark_phoenix_poster-keyart_2de4ace2.jpeg", ""));

        setBannerMoviesPager(homeBannerMoviesList);

        tvShowsBannerMoviesList = new ArrayList<>();

        tvShowsBannerMoviesList.add(new BannerMovies(1, "The Suicide Squad",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/d42dd756738a5fe64ad1affe067d682c7f484f6b49dbd26955b5161c2578f08b._SX1080_.jpg", ""));
        tvShowsBannerMoviesList.add(new BannerMovies(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/3740ffe895535f8dd7d7bc3ffcd6690cfcae1e97da279fba35f09ae0151a359c._SX1080_.jpg", ""));
        tvShowsBannerMoviesList.add(new BannerMovies(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/4ecf783df765076f3ee80d8f4c24b5140789e5178fa891c75d9c2e854f4462b5._SX1080_.jpg", ""));
        tvShowsBannerMoviesList.add(new BannerMovies(4, "Addams Family 2",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/3d744671922d16f805645b7d9a855f3988869e734c3729303a438bc6be5cc768._SX1080_.jpg", ""));
        tvShowsBannerMoviesList.add(new BannerMovies(5, "X-Men Dark Phoenix",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/e10f82e92c8f9a625e8ef4f852d65e3debc3e92559bc8621c3911d4684a61056._SX1080_.jpg", ""));
        tvShowsBannerMoviesList.add(new BannerMovies(6, "X-Men Dark Phoenix",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/b20cfda9bb539e5bad857951592ebbc9aa8531bb080a57bf6fc71dbb845ffa8d._SX1080_.jpg", ""));

        moviesBannerMoviesList = new ArrayList<>();

        moviesBannerMoviesList.add(new BannerMovies(1, "The Suicide Squad",
                "https://images-na.ssl-images-amazon.com/images/I/91ALbp3BdkL._SX300_.jpg", ""));
        moviesBannerMoviesList.add(new BannerMovies(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/I/71bfdkKaHsL._SX268_.jpg", ""));
        moviesBannerMoviesList.add(new BannerMovies(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/4af16bd041ac8ab3656eaf2ca35a570960684580ee9bc5736f1f35ada39f723e._SX1080_.jpg", ""));

        kidsBannerMoviesList = new ArrayList<>();

        kidsBannerMoviesList.add(new BannerMovies(1, "The Suicide Squad",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/11e1bf35343363653feee8a08b2caaed8a962fbb3009866bb17fbb19a972f2ad._SX1080_.jpg", ""));
        kidsBannerMoviesList.add(new BannerMovies(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/2268f9d1ace9169972f860402f793cc0b04fb673363557aeeed3ce5cff62b793._SX1080_.jpg", ""));
        kidsBannerMoviesList.add(new BannerMovies(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/d5e9bc92df2ae13ad8e5c9a9a290a9139ff59b1a6db061d63731fb9dc0ae187b._SX1080_.jpg", ""));
        kidsBannerMoviesList.add(new BannerMovies(4, "Addams Family 2",
                "https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_465,q_auto,w_310/v1632398890/amc-cdn/production/2/movies/66500/66489/Poster/Primary_BoxCover_800_1200.jpg", ""));

        //set tabs
        tabCategory.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 1:

                        setScrollDefaultState();
                        setBannerMoviesPager(tvShowsBannerMoviesList);
                        return;

                    case 2:

                        setScrollDefaultState();
                        setBannerMoviesPager(moviesBannerMoviesList);
                        return;

                    case 3:

                        setScrollDefaultState();
                        setBannerMoviesPager(kidsBannerMoviesList);
                        return;

                    default:
                        setScrollDefaultState();
                        setBannerMoviesPager(homeBannerMoviesList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        categoryItems1 = new ArrayList<>();

        categoryItems1.add(new CategoryItem(1, "The Suicide Squad",
                "https://cdn.mos.cms.futurecdn.net/axszmq4rkiJwRTNrZj9uw7.jpg", ""));
        categoryItems1.add(new CategoryItem(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/2644962659fabd13aca9a3821525b0d9d3a2c7f8861470e67461541594e14b86._SX1080_.jpg", ""));
        categoryItems1.add(new CategoryItem(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/d5e9bc92df2ae13ad8e5c9a9a290a9139ff59b1a6db061d63731fb9dc0ae187b._SX1080_.jpg", ""));
        categoryItems1.add(new CategoryItem(4, "Addams Family 2",
                "https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_465,q_auto,w_310/v1632398890/amc-cdn/production/2/movies/66500/66489/Poster/Primary_BoxCover_800_1200.jpg", ""));
        categoryItems1.add(new CategoryItem(5, "X-Men Dark Phoenix",
                "https://lumiere-a.akamaihd.net/v1/images/20cs_xmen_dark_phoenix_poster-keyart_2de4ace2.jpeg", ""));

        categoryItems2 = new ArrayList<>();

        categoryItems2.add(new CategoryItem(1, "The Suicide Squad",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/11e1bf35343363653feee8a08b2caaed8a962fbb3009866bb17fbb19a972f2ad._SX1080_.jpg", ""));
        categoryItems2.add(new CategoryItem(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/2268f9d1ace9169972f860402f793cc0b04fb673363557aeeed3ce5cff62b793._SX1080_.jpg", ""));
        categoryItems2.add(new CategoryItem(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/d5e9bc92df2ae13ad8e5c9a9a290a9139ff59b1a6db061d63731fb9dc0ae187b._SX1080_.jpg", ""));
        categoryItems2.add(new CategoryItem(4, "Addams Family 2",
                "https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_465,q_auto,w_310/v1632398890/amc-cdn/production/2/movies/66500/66489/Poster/Primary_BoxCover_800_1200.jpg", ""));

        categoryItems3 = new ArrayList<>();

        categoryItems3.add(new CategoryItem(1, "The Suicide Squad",
                "https://images-na.ssl-images-amazon.com/images/I/91ALbp3BdkL._SX300_.jpg", ""));
        categoryItems3.add(new CategoryItem(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/I/71bfdkKaHsL._SX268_.jpg", ""));
        categoryItems3.add(new CategoryItem(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/4af16bd041ac8ab3656eaf2ca35a570960684580ee9bc5736f1f35ada39f723e._SX1080_.jpg", ""));

        categoryItems4 = new ArrayList<>();

        categoryItems4.add(new CategoryItem(1, "The Suicide Squad",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/d42dd756738a5fe64ad1affe067d682c7f484f6b49dbd26955b5161c2578f08b._SX1080_.jpg", ""));
        categoryItems4.add(new CategoryItem(2, "Jumanji",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/3740ffe895535f8dd7d7bc3ffcd6690cfcae1e97da279fba35f09ae0151a359c._SX1080_.jpg", ""));
        categoryItems4.add(new CategoryItem(3, "Aladdin",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/4ecf783df765076f3ee80d8f4c24b5140789e5178fa891c75d9c2e854f4462b5._SX1080_.jpg", ""));
        categoryItems4.add(new CategoryItem(4, "Addams Family 2",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/3d744671922d16f805645b7d9a855f3988869e734c3729303a438bc6be5cc768._SX1080_.jpg", ""));
        categoryItems4.add(new CategoryItem(5, "X-Men Dark Phoenix",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/e10f82e92c8f9a625e8ef4f852d65e3debc3e92559bc8621c3911d4684a61056._SX1080_.jpg", ""));
        categoryItems4.add(new CategoryItem(6, "Women Plane",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/b20cfda9bb539e5bad857951592ebbc9aa8531bb080a57bf6fc71dbb845ffa8d._SX1080_.jpg", ""));


        allCategoryList = new ArrayList<>();

        allCategoryList.add(new AllCategory(1, "Bollywood", categoryItems1));
        allCategoryList.add(new AllCategory(2, "Hollywood", categoryItems2));
        allCategoryList.add(new AllCategory(3, "Kids", categoryItems3));
        allCategoryList.add(new AllCategory(4, "Tv Shows Movies", categoryItems4));

        setRecyclerCategory(allCategoryList);

    }

    private void setScrollDefaultState() {

        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0, 0);
        appBarLayout.setExpanded(true);
    }

    public void setBannerMoviesPager(List<BannerMovies> bannerMovies) {

        vpBannerMovies = findViewById(R.id.vpBanner);
        bannerPagerAdapter = new BannerPagerAdapter(bannerMovies, this);
        vpBannerMovies.setAdapter(bannerPagerAdapter);

        tabIndicator = findViewById(R.id.tabIndicator);
        tabIndicator.setupWithViewPager(vpBannerMovies);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        tabIndicator.setupWithViewPager(vpBannerMovies, true);
    }

    class AutoSlider extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(() -> {

                if (vpBannerMovies.getCurrentItem() < homeBannerMoviesList.size() - 1) {

                    vpBannerMovies.setCurrentItem(vpBannerMovies.getCurrentItem() + 1);
                } else {

                    vpBannerMovies.setCurrentItem(0);
                }
            });
        }
    }

    public void setRecyclerCategory(List<AllCategory> allCategoryList) {

        rv = findViewById(R.id.recyclerViewMain);
        categoryRecyclerAdapter = new CategoryRecyclerAdapter(this, allCategoryList);
        rv.setAdapter(categoryRecyclerAdapter);
    }
}