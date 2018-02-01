package com.example.tcl.customview.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tcl.customview.R;

/**
 * Created by TCL on 2018/1/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public final TextView mTextView;
    public final Button mButton;

    public MyViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.recycler_textview);
        mButton = itemView.findViewById(R.id.recycler_button);
    }
}
