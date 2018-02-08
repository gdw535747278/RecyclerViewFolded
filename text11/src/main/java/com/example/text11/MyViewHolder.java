package com.example.text11;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by TCL on 2018/2/5.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

//    @BindView(R.id.tv_abc)
    public TextView mTextView;

    public MyViewHolder(View itemView, Context context) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.tv_abc);
    }
}
