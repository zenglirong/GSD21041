package com.example.day01.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.day01.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pjy on 2017/6/15.
 */

public class FragmentB extends BaseFragment {

    @BindView(R.id.tv_fragment_skip)
    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        ButterKnife.bind(this,view);
        skip(tv);
        return view;
    }
}
