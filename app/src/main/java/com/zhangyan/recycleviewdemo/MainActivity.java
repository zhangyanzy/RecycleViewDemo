package com.zhangyan.recycleviewdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.zhangyan.recycleviewdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<String> mMainList;
    private MainRecycleViewAdapter adapter;
    private MainStaggedRecycleViewAdapter staggedRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(new Presenter());
        dataBinding();
//        adapter = new MainRecycleViewAdapter(mMainList, this);
        staggedRecycleViewAdapter = new MainStaggedRecycleViewAdapter(mMainList, this);
        /**
         * 在设置适配器之前要设置recycleView的LayoutManager
         * LayoutManager（布局摆放管理器（线性布局、瀑布流））
         * !!!!!   setLayoutManager(new LinearLayoutManager(this));默认是线性布局垂直
         *         setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));线性水平布局
         *         setLayoutManager(new GridLayoutManager(this, 2));   GridView
         */
//        binding.recycleViewMain.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleViewMain.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        binding.recycleViewMain.setAdapter(staggedRecycleViewAdapter);
    }

    private void dataBinding() {
        mMainList = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            mMainList.add("item" + i);
        }
    }


    public class Presenter {
        public void onClick(View view) {

        }

    }
}
