package com.example.day01.adapter;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.day01.fragment.FragmentA;
import com.example.day01.fragment.FragmentB;
import com.example.day01.fragment.FragmentC;
import com.example.day01.fragment.FragmentD;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pjy on 2017/6/15.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new FragmentA());
        fragmentList.add(new FragmentB());
        fragmentList.add(new FragmentC());
        fragmentList.add(new FragmentD());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
