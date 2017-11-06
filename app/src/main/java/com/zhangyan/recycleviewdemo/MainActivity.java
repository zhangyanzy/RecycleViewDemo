package com.zhangyan.recycleviewdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.zhangyan.recycleviewdemo.adapter.MainRecycleViewAdapter;
import com.zhangyan.recycleviewdemo.adapter.MainStaggedRecycleViewAdapter;
import com.zhangyan.recycleviewdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<String> mMainList;
    private MainRecycleViewAdapter adapter;
//    private MainStaggedRecycleViewAdapter staggedRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(new Presenter());
        dataBinding();
        adapter = new MainRecycleViewAdapter(mMainList, this);
//        staggedRecycleViewAdapter = new MainStaggedRecycleViewAdapter(mMainList, this);
        /**
         * 在设置适配器之前要设置recycleView的LayoutManager
         * LayoutManager（布局摆放管理器（线性布局、瀑布流））
         * !!!!!   setLayoutManager(new LinearLayoutManager(this));默认是线性布局垂直
         *         setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));线性水平布局
         *         setLayoutManager(new GridLayoutManager(this, 2));   GridView
         */
        binding.recycleViewMain.setLayoutManager(new LinearLayoutManager(this));
//        binding.recycleViewMain.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        binding.recycleViewMain.setAdapter(adapter);
        binding.recycleViewMain.setItemAnimator(new DefaultItemAnimator());
        /**
         * 点击事件
         */
        adapter.setOnItemClickListener(new MainRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "点击" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dataBinding() {
        mMainList = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            mMainList.add("item" + i);
        }
    }


    public class Presenter {
        boolean isGrid = false;

        public void onClick(View view) {
            switch (view.getId()) {
                /**
                 *  切换效果
                 */
                case R.id.check_btn:
                    if (!isGrid) {
                        binding.recycleViewMain.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                    } else {
                        binding.recycleViewMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                    isGrid = !isGrid;
                    break;
                case R.id.add_btn:
                    adapter.addData(0);
                default:
                    break;
            }
        }


    }


}
