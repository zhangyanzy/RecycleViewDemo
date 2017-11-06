package com.zhangyan.recycleviewdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangYan on 2017/11/3.
 * <p>
 * 瀑布流适配器
 */

public class MainStaggedRecycleViewAdapter extends RecyclerView.Adapter<MainStaggedRecycleViewAdapter.MyViewHolder> {

    //数据集合
    private List<String> mList;
    private List<Integer> mhight;
    private Context mContext;

    public MainStaggedRecycleViewAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        mhight = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mhight.add((int) (200 + Math.random() * 550));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHolder
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //绑定数据
        ViewGroup.LayoutParams params = holder.mTv.getLayoutParams();
        params.height = mhight.get(position);
        holder.mTv.setBackgroundColor(Color.rgb(100, (int) (Math.random() * 255), (int) (Math.random() * 255)));
        holder.mTv.setLayoutParams(params);
        holder.mTv.setText(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTv;

        MyViewHolder(View view) {
            super(view);
            mTv = (TextView) view.findViewById(android.R.id.text1);
        }
    }
}
