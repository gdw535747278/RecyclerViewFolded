package com.example.text11;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



/**
 * Created by TCL on 2018/2/5.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private String TAG = "MyAdapter";
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ========");

        TextView textView = new TextView(parent.getContext());
        textView.setText("123123123123123123");
        MyViewHolder myViewHolder = new MyViewHolder(textView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ========");

    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount: ========");
        return 20;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position, List<Object> payloads) {
        Log.i(TAG, "onBindViewHolder: ========");
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemViewType(int position) {
        Log.i(TAG, "getItemViewType: ========");
        return super.getItemViewType(position);
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        Log.i(TAG, "setHasStableIds: ========");
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public long getItemId(int position) {
        Log.i(TAG, "getItemId: ========");
        return super.getItemId(position);
    }

    @Override
    public void onViewRecycled(MyViewHolder holder) {
        Log.i(TAG, "onViewRecycled: ========");
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(MyViewHolder holder) {
        Log.i(TAG, "onFailedToRecycleView: ========");
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(MyViewHolder holder) {
        Log.i(TAG, "onViewAttachedToWindow: ========");
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        Log.i(TAG, "onViewDetachedFromWindow: ========");
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        Log.i(TAG, "registerAdapterDataObserver: ========");
        super.registerAdapterDataObserver(observer);
    }

    @Override
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        Log.i(TAG, "unregisterAdapterDataObserver: ========");
        super.unregisterAdapterDataObserver(observer);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Log.i(TAG, "onAttachedToRecyclerView: ========");
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Log.i(TAG, "onDetachedFromRecyclerView: ========");
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
