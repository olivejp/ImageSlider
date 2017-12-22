package com.orlanth23.imageslider;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
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
        ViewPager mPager = findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(this, xmenarray));
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
    }

}