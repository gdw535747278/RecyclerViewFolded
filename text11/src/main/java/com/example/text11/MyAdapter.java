package com.example.text11;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by TCL on 2018/2/5.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<MyBean> mList = new ArrayList<>();
    private String TAG = "MyAdapter";
    public ArrayList<String> mName;
    private final Context mContext;

    public MyAdapter(Context context, ArrayList<MyBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ========");

        /*TextView textView = new TextView(parent.getContext());
//        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
//        layoutParams.height = 50;
//        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        textView.setGravity(Gravity.CENTER);
//        textView.setLayoutParams(layoutParams);
        textView.setHeight(50);
        textView.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setText("123123123123123123");*/
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritemtext, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view,mContext);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ========");
        MyBean myBean = mList.get(position);

        switch (myBean.getType()) {
            case 001:
                holder.mTextView.setText(myBean.getTitle());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "点击了"+holder.mTextView.getText(), Toast.LENGTH_SHORT).show();
                        initData();


                    }
                });
                break;
        }

    }

    private void initData() {
        mName = new ArrayList<>();
        mName.add("高三5班");
        mName.add("高三1班");
        mName.add("高二5班");
        mName.add("初中1790班");
        mName.add("240101班");
        mName.add("清华大学速成班");
        mName.add("帅哥速成班");
        mName.add("程序员速成0341班");
        mName.add("扯蛋0班");
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount: ========");
        return mList.size();
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
