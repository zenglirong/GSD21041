package com.example.day01.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.day01.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    //头部
    @BindView(R.id.ll_header_left_container)
    LinearLayout cityContainer;
    @BindView(R.id.tv_header_main_city)
    TextView tvCity;//显示城市名称
    @BindView(R.id.iv_header_main_add)
    ImageView ivAdd;
    @BindView(R.id.menu_layout)
    View menuLayout;


    //中段
    @BindView(R.id.ptrlv_main)
    PullToRefreshListView ptrListView;

    ListView listView;
    List<String> datas;
    ArrayAdapter<String> adapter;

    //脚部
    @BindView(R.id.rg_main_footer)
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_main);
        ButterKnife.bind(this);
        initListView();

    }

    @OnClick(R.id.ll_header_left_container)
    public void jumpToCity(View view){
        Intent intent = new Intent(this,CityActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.iv_header_main_add)
    public void toggleMenu(View view){
        if(menuLayout.getVisibility()==View.VISIBLE){
            menuLayout.setVisibility(View.INVISIBLE);
        }else{
            menuLayout.setVisibility(View.VISIBLE);
        }

    }




    private void initListView() {

        listView = ptrListView.getRefreshableView();
        datas = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        //为ListView添加若干个头部
        LayoutInflater inflater = LayoutInflater.from(this);

        View listHeaderIcons = inflater.inflate(R.layout.header_list_icons, listView, false);
        View listHeaderSquares =inflater.inflate(R.layout.header_list_square,listView,false);
        View listHeaderAds = inflater.inflate(R.layout.header_list_ads, listView, false);
        View listHeaderCategories = inflater.inflate(R.layout.header_list_categories,listView,false);
        View listHeaderRecommend = inflater.inflate(R.layout.header_list_recommend,listView,false);

        listView.addHeaderView(listHeaderIcons);
        listView.addHeaderView(listHeaderSquares);
        listView.addHeaderView(listHeaderAds);
        listView.addHeaderView(listHeaderCategories);
        listView.addHeaderView(listHeaderRecommend);

        listView.setAdapter(adapter);

        initListHeaderIcons(listHeaderIcons);

        //添加下拉松手后的刷新
        ptrListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.add(0,"新增内容");
                        adapter.notifyDataSetChanged();
                        ptrListView.onRefreshComplete();
                    }
                }, 1500);

            }
        });

    }

    private void initListHeaderIcons(View listHeaderIcons) {
        final ViewPager viewPager = (ViewPager) listHeaderIcons.findViewById(R.id.vp_header_list_icons);

        PagerAdapter adapter = new PagerAdapter() {

            int[] resIDs = new int[]{
                    R.layout.icons_list_1,
                    R.layout.icons_list_2,
                    R.layout.icons_list_3
            };

            @Override
            public int getCount() {
                return 30000;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                int layoutId = resIDs[position%3];
                View view = LayoutInflater.from(MainActivity.this).inflate(layoutId,viewPager,false);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(15000);

    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {

        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");
        datas.add("ddd");
        datas.add("eee");
        datas.add("fff");
        datas.add("ggg");
        datas.add("hhh");
        datas.add("jjj");
        adapter.notifyDataSetChanged();

    }
}