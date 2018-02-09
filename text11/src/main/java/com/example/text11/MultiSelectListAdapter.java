package com.example.text11;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TCL on 2018/2/8.
 */

public class MultiSelectListAdapter extends MultiChoiceAdapter<MultiSelectListAdapter.MultiSelectListViewHolder> {
    private List<String> mList;
    public final LayoutInflater mInflater;
    private Boolean[] mSelectList;


    public MultiSelectListAdapter(Context context, List<String> nameList) {
        this.mList = nameList;
        mInflater = LayoutInflater.from(context);

        if (mList != null && mList.size() > 0) {
            mSelectList = new Boolean[mList.size()];
            Arrays.fill(mSelectList,false);
        }
    }

    @Override
    public MultiSelectListAdapter.MultiSelectListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.muli_select_list_item, parent, false);
        MultiSelectListViewHolder holder = new MultiSelectListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MultiSelectListAdapter.MultiSelectListViewHolder holder, final int position) {
        TextView textView = holder.mTextView;
        textView.setText(mList.get(position));
        textView.setSelected(mSelectList[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectList[position] = !mSelectList[position];
                if (mSelectChangeListener != null) {
                    mSelectChangeListener.changed(getSelectPosition(),getSelectNumber());
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void selectAll() {
        if (mSelectList != null) {
            Arrays.fill(mSelectList,true);
            notifyDataSetChanged();
        }
    }

    public void cancelAll() {
        if (mSelectList != null) {
            Arrays.fill(mSelectList,false);
            notifyDataSetChanged();
        }
    }

    public ArrayList<Integer> getSelectPosition() {
        ArrayList<Integer> pos = new ArrayList<>();
        if (mSelectList.length > 0) {
            for (int i = 0; i < mSelectList.length; i++) {
                if (mSelectList[i]) {
                    pos.add(i);
                }
            }
        }
        return pos;
    }

    public int getSelectNumber() {
        return getSelectPosition().size();
    }

    public class MultiSelectListViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTextView;

        public MultiSelectListViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.choiceNameBtn);
        }
    }

    public void addOnSelectChangeListener(OnSelectChangeListener listener) {
        this.mSelectChangeListener = listener;
    }

    private OnSelectChangeListener mSelectChangeListener;

    public interface OnSelectChangeListener {
        void changed(ArrayList<Integer> selectPosition, int selectNumber);
    }

}
