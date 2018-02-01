package com.example.tcl.customview.text01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TCL on 2018/1/29.
 */

public abstract class AbstractExpandableItem<T> implements IExpandable<T> {
    protected boolean mExpandable = false;
    protected List<T> mSubItems;


    @Override
    public void setExpanded(boolean pExpanded) {
        mExpandable = pExpanded;
    }

    @Override
    public boolean isExpanded() {
        return mExpandable;
    }

    @Override
    public List getSubItems() {
        return mSubItems;
    }

    public boolean hasSubItem() {
        return mSubItems != null && mSubItems.size() > 0;
    }

    public void setSubItems(List<T> pSubItems) {
        mSubItems = pSubItems;
    }

    public T getSubItem(int position) {
        if (hasSubItem() && position < mSubItems.size()) {
            return mSubItems.get(position);
        } else {
            return null;
        }
    }

    public void addSubItem(T subItem) {
        if (mSubItems == null) {
            mSubItems = new ArrayList<>();
        }
        mSubItems.add(subItem);
    }

    public void addSubItem(int position, T subItem) {
        if (mSubItems != null && position > 0 && position < mSubItems.size()) {
            mSubItems.add(position, subItem);
        } else {
            addSubItem(subItem);
        }
    }

}
