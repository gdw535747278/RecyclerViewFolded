package com.example.tcl.customview.text01;

import android.support.annotation.NonNull;
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

    protected void collapse(int pPosition, boolean animat) {
       IExpandable vIExpandable = getExpandableItem(pPosition);
        if (vIExpandable == null) {
            return;
        }

        int subItemCount = recursiveCollapse(pPosition);
        vIExpandable.setExpanded(false);
        if (animat) {
            notifyItemChanged(pPosition);
            notifyItemRangeRemoved(pPosition + 1, subItemCount);
        } else {
            notifyDataSetChanged();
        }
    }

    private int recursiveCollapse(int pPosition) {
        B vItem = getItem(pPosition);
        if (!isExpandable(vItem)) {
            return 0;
        }
        IExpandable vIExpandable = (IExpandable) vItem;
        int subItemCount = 0;
        if (vIExpandable.isExpanded()) {
            List<B> vSubItems = vIExpandable.getSubItems();
            if (vSubItems == null) {
                return 0;
            }
            for (int vI = vSubItems.size()-1; vI >=0 ; vI--) {
                B subItem = vSubItems.get(vI);
                int pos = getItemPosition(subItem);
                if (pos < 0) {
                    continue;
                }

                if (subItem instanceof IExpandable) {
                    subItemCount+= recursiveCollapse(pos);
                }

                mList.remove(pos);
                subItemCount++;
            }
        }
        return subItemCount;
    }

    private int getItemPosition(B pSubItem) {
        return pSubItem != null && mList != null && !mList.isEmpty() ? mList.indexOf(pSubItem) : -1;
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

    protected void expand(int pPosition, boolean animat) {
//        B vItem = getItem(pPosition);
        IExpandable vIExpandable = getExpandableItem(pPosition);
        if (vIExpandable == null) {
            return;
        }

        if (!hasSubItems(vIExpandable)){
            vIExpandable.setExpanded(true);
            notifyItemChanged(pPosition);
            return;
        }
        int subItemCount = 0;

        if (!vIExpandable.isExpanded()) {
            List subItem = vIExpandable.getSubItems();
            mList.addAll(pPosition + 1, subItem);
            subItemCount += recursiveExpand(pPosition + 1, subItem);
            vIExpandable.setExpanded(true);
        }

        int parentPos = pPosition;

        if (animat) {
            notifyItemChanged(parentPos);
            notifyItemRangeInserted(parentPos + 1, subItemCount);
        } else {
            notifyDataSetChanged();
        }

    }

    private int recursiveExpand(int i, @NonNull List subItem) {
        int count = subItem.size();
        int pos = i + subItem.size() - 1;
        for (int j = subItem.size() - 1; j >= 0; j--, pos--) {
            if (subItem.get(j) instanceof IExpandable) {
                IExpandable iExpandable = (IExpandable) subItem.get(j);
                if (iExpandable.isExpanded() && hasSubItems(iExpandable)) {
                    List items = iExpandable.getSubItems();
                    mList.addAll(pos + 1, items);
                    int subItemCount = recursiveExpand(pos + 1, items);
                    count += subItemCount;
                }
            }
        }
        return count;
    }

    private boolean hasSubItems(IExpandable vIExpandable) {
        if (vIExpandable == null) {
            return false;
        }

        List subItems = vIExpandable.getSubItems();
        return subItems != null && subItems.size() > 0;
    }

    protected abstract int getDefItemViewType(B pB);

    protected abstract T initViewHolder(ViewGroup pParent, int pViewType);

    protected abstract void bindTo(T pHolder, int pPosition, B pB);
}
