package com.example.day01.fragment;


import android.content.Intent;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.day01.ui.MainActivity;

/**
 * Created by pjy on 2017/6/15.
 */

public class BaseFragment extends Fragment {

    public void skip(View view){

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
