package com.sun.kh_custom_moviestreaming;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> mSlides;
    private ViewPager mSlider;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlider = findViewById(R.id.slider);
        TabLayout indicator = findViewById(R.id.indicator);
        // Prepare a list of slides...
        mSlides = new ArrayList<>();
        mSlides.add(new Slide(R.drawable.slide1, "X Men \n More text title"));
        mSlides.add(new Slide(R.drawable.slide2, "Harry Potter \n More text title"));
        mSlides.add(new Slide(R.drawable.slide3, "End game \n More text title"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, mSlides);
        mSlider.setAdapter(adapter);
        // Set up timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(mSlider, true);
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Moana", R.drawable.moana));
        movies.add(new Movie("BlackP", R.drawable.blackp));
        movies.add(new Movie("Themartian", R.drawable.themartian));
        movies.add(new Movie("Nutracker", R.drawable.mov2));
        movies.add(new Movie("BlackP", R.drawable.blackp));
        movies.add(new Movie("Themartian", R.drawable.themartian));
        movies.add(new Movie("Nutracker", R.drawable.mov2));
        movies.add(new Movie("Moana", R.drawable.moana));
        mRecyclerView = findViewById(R.id.recyclerMovies);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        MovieAdapter movieAdapter = new MovieAdapter(movies);
        mRecyclerView.setAdapter(movieAdapter);
        movieAdapter.setListener(this);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView imageView) {
        DetailActivity.newInstance(this, movie, imageView);
    }

    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mSlider.getCurrentItem() < mSlides.size() - 1) {
                        mSlider.setCurrentItem(mSlider.getCurrentItem() + 1);
                    } else {
                        mSlider.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
