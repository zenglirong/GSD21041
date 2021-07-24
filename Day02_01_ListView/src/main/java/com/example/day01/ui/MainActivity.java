package com.example.day01.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.day01.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ptrlv_main)
    PullToRefreshListView ptrListView;

    ListView listView;
    List<String> data;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_main);
        ButterKnife.bind(this);
        initListView();

    }

    private void initListView() {

        listView = ptrListView.getRefreshableView();
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        //添加下拉松手后的刷新
        ptrListView.setOnRefreshListener(refreshView -> new Handler().postDelayed(() -> {
            data.add(0,"新增内容");
            adapter.notifyDataSetChanged();
            ptrListView.onRefreshComplete();
        }, 1500));

    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {

        data.add("aaa");
        data.add("bbb");
        data.add("ccc");
        data.add("ddd");
        data.add("eee");
        data.add("fff");
        data.add("ggg");
        data.add("hhh");
        data.add("jjj");
        adapter.notifyDataSetChanged();

    }
}