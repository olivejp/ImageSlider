package com.orlanth23.imageslider;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Arrays;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private static final String[] XMEN = {
            "https://firebasestorage.googleapis.com/v0/b/annoncesnc-2d319.appspot.com/o/beast.png?alt=media&token=eba8c953-531a-41a2-bd83-d1426fad8bc4",
            "https://firebasestorage.googleapis.com/v0/b/annoncesnc-2d319.appspot.com/o/charles.png?alt=media&token=66f1ba69-67e9-4c7a-9a49-480b48130c2a",
            "https://firebasestorage.googleapis.com/v0/b/annoncesnc-2d319.appspot.com/o/magneto.png?alt=media&token=c75de329-cb17-41e9-8906-728f18095d94",
            "https://firebasestorage.googleapis.com/v0/b/annoncesnc-2d319.appspot.com/o/mystique.png?alt=media&token=12c5174d-db11-4e9b-8da3-7226a72bef1e",
            "https://firebasestorage.googleapis.com/v0/b/annoncesnc-2d319.appspot.com/o/wolverine.png?alt=media&token=31a17b23-c319-4c53-9fdc-6d95ac75cbd0"};
    private ArrayList<String> xmenarray = new ArrayList<>();
    private StorageReference mStorageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mStorageReference = FirebaseStorage.getInstance().getReference();
    }

    private void init() {
        xmenarray.addAll(Arrays.asList(XMEN));
        ViewPager mPager = findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(this, xmenarray));
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
    }
}