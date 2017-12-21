package com.orlanth23.imageslider;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private ViewPager mPager;
    private int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.beast, R.drawable.charles, R.drawable.magneto, R.drawable.mystique, R.drawable.wolverine};
    private ArrayList<Integer> xmenarray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        xmenarray.addAll(Arrays.asList(XMEN));

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this, xmenarray));
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        mPager.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.performClick();
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
                return super.onTouch(v, event);
            }

            @Override
            public void onSwipeRight() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }

            @Override
            public void onSwipeLeft() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage--, true);
            }
        });
    }

}