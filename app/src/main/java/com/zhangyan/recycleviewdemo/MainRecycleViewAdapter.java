package com.zhangyan.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhangYan on 2017/11/3.
 */

public class MainRecycleViewAdapter extends RecyclerView.Adapter<MainRecycleViewAdapter.MyViewHolder> {

    //数据集合
    private List<String> mList;
    private Context mContext;

    public MainRecycleViewAdapter(List<String> mList,Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHolder
        MyViewHolder holder = new MyViewHolder(View.inflate(mContext, android.R.layout.simple_list_item_1, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //绑定数据
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
