package com.zhangyan.recycleviewdemo.adapter;

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
    private OnItemClickListener mOnitemClickListener;

    public MainRecycleViewAdapter(List<String> mList, Context mContext) {
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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //绑定数据
        holder.mTv.setText(mList.get(position));
        /**
         * *****************Recycle的点击事件**********************
         */
        if (mOnitemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnitemClickListener.onItemClick(v, holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(int position) {
        mList.add(position, "addItem" + position);
        //提示刷新
        notifyDataSetChanged();
        notifyItemInserted(position);

    }

    public void removeData(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * ********************处理RecycleView的点击事件************************8
     */
    public interface OnItemClickListener {

        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnitemClickListener = listener;

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTv;

        MyViewHolder(View view) {
            super(view);
            mTv = (TextView) view.findViewById(android.R.id.text1);
        }
    }
}
