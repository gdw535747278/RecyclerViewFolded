package com.example.tcl.customview.text01;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TCL on 2018/1/30.
 */

public abstract class BaseRecyclerViewAdapter<B, T extends BaseRecyclerViewHolder> extends RecyclerView.Adapter<T> {

    private List<B> mList;

    public BaseRecyclerViewAdapter(List<B> pList) {
        this.mList = pList == null ? new ArrayList<B>() : pList;
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return initViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
//        if (mList != null && mList.size() > 0) {
        bindTo(holder, position, mList.get(position));
//        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null && mList.size() > 0) {
            return getDefItemViewType(mList.get(position));
        }
        return super.getItemViewType(position);
    }

    protected void collapse(int pPosition) {
       IExpandable vIExpandable = getExpandableItem(pPosition);
        if (vIExpandable == null) {
            return;
        }

        recursiveCollapse(pPosition);

    }

    private void recursiveCollapse(int pPosition) {
        B vItem = getItem(pPosition);
        IExpandable vIExpandable = (IExpandable) vItem;

    }

    private IExpandable getExpandableItem(int pPosition) {
       B vItem = getItem(pPosition);
        if (isExpandable(vItem)) {
            return ((IExpandable) vItem);
        } else {
            return null;
        }
    }

    private boolean isExpandable(B pItem) {
        return pItem != null && pItem instanceof IExpandable;
    }

    private B getItem(int pPosition) {
        if (pPosition >= 0 && pPosition < mList.size()) {
            return mList.get(pPosition);
        } else {
            return null;
        }
    }

    protected void expand(int pPosition) {

    }

    protected abstract int getDefItemViewType(B pB);

    protected abstract T initViewHolder(ViewGroup pParent, int pViewType);

    protected abstract void bindTo(T pHolder, int pPosition, B pB);
}
