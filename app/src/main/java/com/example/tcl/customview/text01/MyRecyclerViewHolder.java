package com.example.tcl.customview.text01;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcl.customview.R;

/**
 * Created by TCL on 2018/1/30.
 */

public class MyRecyclerViewHolder extends BaseRecyclerViewHolder {

    public TextView mTextView;
    public ImageView mImageView;
    private int itemType;

    public MyRecyclerViewHolder(View itemView, int pTypeLevel1) {
        super(itemView);
        this.itemType = pTypeLevel1;
        switch (pTypeLevel1) {
            case Constants.TYPE_LEVEL_1:
                mTextView = itemView.findViewById(R.id.tv_1);
                mImageView = itemView.findViewById(R.id.iv_1);
                break;
            case Constants.TYPE_LEVEL_2:
                mTextView = itemView.findViewById(R.id.tv_2);
                mImageView = itemView.findViewById(R.id.iv_2);
                break;
            case Constants.TYPE_LEVEL_3:
                mTextView = itemView.findViewById(R.id.tv_3);
                mImageView = itemView.findViewById(R.id.iv_3);
                break;


        }
    }



}
