package com.example.tcl.customview.util;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcl.customview.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by TCL on 2018/1/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<MyBean> mList;
    private static HashMap<Integer, Boolean> isClick = new HashMap<>();



    public MyAdapter(ArrayList<MyBean> pList) {
        this.mList = pList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);

        return new MyViewHolder(vView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        holder.mTextView.setText(mList.get(position).getStr());
        isClick.put(position, false);
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                isClick.put(position, true);
                mList.get(position).setClick(!mList.get(position).isClick());
                notifyDataSetChanged();
            }
        });
        if (mList.get(position).isClick()) {
            holder.mTextView.setBackgroundColor(Color.parseColor("#565656"));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
