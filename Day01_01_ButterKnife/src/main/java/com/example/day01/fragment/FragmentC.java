package com.example.day01.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.day01.R;
import com.example.day01.ui.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pjy on 2017/6/15.
 */

public class FragmentC extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c,container,false);
        ButterKnife.bind(this,view);

        return view;
    }

    @OnClick(R.id.tv_fragment_skip)
    public void skip(View view){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
