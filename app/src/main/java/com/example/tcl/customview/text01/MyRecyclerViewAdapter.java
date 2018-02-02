package com.example.tcl.customview.text01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcl.customview.R;
import com.example.tcl.customview.ShowActivity;

import java.util.List;

/**
 * Created by TCL on 2018/1/30.
 */

public class MyRecyclerViewAdapter extends BaseRecyclerViewAdapter<MultiItemType, MyRecyclerViewHolder> {

    public LayoutInflater mInflater;
    private Context mContext;

    public MyRecyclerViewAdapter(Context pContext, List<MultiItemType> pList) {
        super(pList);
        mContext = pContext;
        mInflater = LayoutInflater.from(pContext);
    }

    @Override
    protected int getDefItemViewType(MultiItemType pMultiItemType) {
        return pMultiItemType.getItemType();
    }

    @Override
    protected MyRecyclerViewHolder initViewHolder(ViewGroup pParent, int pViewType) {
        View vView = null;
        switch (pViewType) {
            case Constants.TYPE_LEVEL_1:
                vView = mInflater.inflate(R.layout.item_level0, pParent, false);
                return new MyRecyclerViewHolder(vView, Constants.TYPE_LEVEL_1);
            case Constants.TYPE_LEVEL_2:
                vView = mInflater.inflate(R.layout.item_level1, pParent, false);
                return new MyRecyclerViewHolder(vView, Constants.TYPE_LEVEL_2);
            case Constants.TYPE_LEVEL_3:
                vView = mInflater.inflate(R.layout.item_level2, pParent, false);
                return new MyRecyclerViewHolder(vView, Constants.TYPE_LEVEL_3);
        }
        return new MyRecyclerViewHolder(vView, Constants.TYPE_LEVEL_1);
    }

    @Override
    protected void bindTo(final MyRecyclerViewHolder pHolder, int pPosition, MultiItemType item) {
        switch (pHolder.getItemViewType()) {
            case Constants.TYPE_LEVEL_1:
                final Level1Item vLevel1Item = (Level1Item) item;
                pHolder.mTextView.setText(vLevel1Item.title);
                pHolder.mImageView.setImageResource(vLevel1Item.isExpanded()?R.mipmap.arrow_b:R.mipmap.arrow_r);
                pHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int vPosition = pHolder.getAdapterPosition();
                        if (vLevel1Item.isExpanded()) {
                            collapse(vPosition,true);
                        } else {
                            expand(vPosition,true);

                        }
                    }
                });
                break;
            case Constants.TYPE_LEVEL_2:
                final Level2Item vLevel2Item = (Level2Item) item;
                pHolder.mTextView.setText(vLevel2Item.mTitle);
                pHolder.mImageView.setImageResource(vLevel2Item.isExpanded()?R.mipmap.arrow_b:R.mipmap.arrow_r);
                pHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int vPosition = pHolder.getAdapterPosition();
                        if (vLevel2Item.isExpanded()) {
                            collapse(vPosition,false);
                        } else {
                            expand(vPosition,false);
                        }
                    }
                });
                break;
            case Constants.TYPE_LEVEL_3:
                final Level3Item vLevel3Item = (Level3Item) item;
                pHolder.mTextView.setText(vLevel3Item.name);
                pHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int vPosition = pHolder.getAdapterPosition();
                        Intent intent = new Intent(mContext, ShowActivity.class);
                        intent.putExtra(Constants.DETAIL, vLevel3Item.resId);
                        intent.putExtra(Constants.TYPE, vLevel3Item.name);
                        mContext.startActivity(intent);
                    }
                });
                break;

        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
