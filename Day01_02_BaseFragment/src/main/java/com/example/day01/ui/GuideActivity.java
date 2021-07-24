package com.example.day01.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.day01.R;
import com.example.day01.adapter.MyPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.vp_main)
    ViewPager viewPager;
    MyPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initViewPager();
    }

    private void initViewPager() {
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}