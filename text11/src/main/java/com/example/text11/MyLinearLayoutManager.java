package com.example.text11;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by TCL on 2018/2/5.
 */

public class MyLinearLayoutManager extends LinearLayoutManager {
    private String TAG = "MyLinearLayoutManager";

    public MyLinearLayoutManager(Context context) {
        this(context,0,false);
    }

    public MyLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        Log.i(TAG, "generateDefaultLayoutParams: ========");
        return super.generateDefaultLayoutParams();
    }

    @Override
    public boolean getRecycleChildrenOnDetach() {
        Log.i(TAG, "getRecycleChildrenOnDetach: ========");
        return super.getRecycleChildrenOnDetach();
    }

    @Override
    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        Log.i(TAG, "setRecycleChildrenOnDetach: ========");
        super.setRecycleChildrenOnDetach(recycleChildrenOnDetach);
    }

    @Override
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        Log.i(TAG, "onDetachedFromWindow: ========");
        super.onDetachedFromWindow(view, recycler);
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        Log.i(TAG, "onInitializeAccessibilityEvent: ========");
        super.onInitializeAccessibilityEvent(event);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Log.i(TAG, "onSaveInstanceState: ========");
        return super.onSaveInstanceState();
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        Log.i(TAG, "onRestoreInstanceState: ========");
        super.onRestoreInstanceState(state);
    }

    @Override
    public boolean canScrollHorizontally() {
        Log.i(TAG, "canScrollHorizontally: ========");
        return super.canScrollHorizontally();
    }

    @Override
    public boolean canScrollVertically() {
        Log.i(TAG, "canScrollVertically: ========");
        return super.canScrollVertically();
    }

    @Override
    public void setStackFromEnd(boolean stackFromEnd) {
        Log.i(TAG, "setStackFromEnd: ========");
        super.setStackFromEnd(stackFromEnd);
    }

    @Override
    public boolean getStackFromEnd() {
        Log.i(TAG, "getStackFromEnd: ========");
        return super.getStackFromEnd();
    }

    @Override
    public int getOrientation() {
        Log.i(TAG, "getOrientation: ========");
        return super.getOrientation();
    }

    @Override
    public void setOrientation(int orientation) {
        Log.i(TAG, "setOrientation: ========");
        super.setOrientation(orientation);
    }

    @Override
    public boolean getReverseLayout() {
        Log.i(TAG, "getReverseLayout: ========");
        return super.getReverseLayout();
    }

    @Override
    public void setReverseLayout(boolean reverseLayout) {
        Log.i(TAG, "setReverseLayout: ========");
        super.setReverseLayout(reverseLayout);
    }

    @Override
    public View findViewByPosition(int position) {
        Log.i(TAG, "findViewByPosition: ========");
        return super.findViewByPosition(position);
    }

    @Override
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        Log.i(TAG, "getExtraLayoutSpace: ========");
        return super.getExtraLayoutSpace(state);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Log.i(TAG, "smoothScrollToPosition: ========");
        super.smoothScrollToPosition(recyclerView, state, position);
    }

    @Override
    public PointF computeScrollVectorForPosition(int targetPosition) {
        Log.i(TAG, "computeScrollVectorForPosition: ========");
        return super.computeScrollVectorForPosition(targetPosition);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.i(TAG, "onLayoutChildren: ========");
        super.onLayoutChildren(recycler, state);
    }

    @Override
    public void onLayoutCompleted(RecyclerView.State state) {
        Log.i(TAG, "onLayoutCompleted: ========");
        super.onLayoutCompleted(state);
    }

    @Override
    protected boolean isLayoutRTL() {
        Log.i(TAG, "isLayoutRTL: ========");

        return super.isLayoutRTL();
    }

    @Override
    public void scrollToPosition(int position) {
        Log.i(TAG, "scrollToPosition: ========");
        super.scrollToPosition(position);
    }

    @Override
    public void scrollToPositionWithOffset(int position, int offset) {
        Log.i(TAG, "scrollToPositionWithOffset: ========");
        super.scrollToPositionWithOffset(position, offset);
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.i(TAG, "scrollHorizontallyBy: ========");
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.i(TAG, "scrollVerticallyBy: ========");
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    @Override
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        Log.i(TAG, "computeHorizontalScrollOffset: ========");
        return super.computeHorizontalScrollOffset(state);
    }

    @Override
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        Log.i(TAG, "computeVerticalScrollOffset: ========");
        return super.computeVerticalScrollOffset(state);
    }

    @Override
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        Log.i(TAG, "computeHorizontalScrollExtent: ========");
        return super.computeHorizontalScrollExtent(state);
    }

    @Override
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        Log.i(TAG, "computeVerticalScrollExtent: ========");
        return super.computeVerticalScrollExtent(state);
    }

    @Override
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        Log.i(TAG, "computeHorizontalScrollRange: ========");
        return super.computeHorizontalScrollRange(state);
    }

    @Override
    public int computeVerticalScrollRange(RecyclerView.State state) {
        Log.i(TAG, "computeVerticalScrollRange: ========");
        return super.computeVerticalScrollRange(state);
    }

    @Override
    public void setSmoothScrollbarEnabled(boolean enabled) {
        Log.i(TAG, "setSmoothScrollbarEnabled: ========");
        super.setSmoothScrollbarEnabled(enabled);
    }

    @Override
    public boolean isSmoothScrollbarEnabled() {
        Log.i(TAG, "isSmoothScrollbarEnabled: ========");
        return super.isSmoothScrollbarEnabled();
    }

    @Override
    public void collectInitialPrefetchPositions(int adapterItemCount, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        Log.i(TAG, "collectInitialPrefetchPositions: ========");
        super.collectInitialPrefetchPositions(adapterItemCount, layoutPrefetchRegistry);
    }

    @Override
    public void setInitialPrefetchItemCount(int itemCount) {
        Log.i(TAG, "setInitialPrefetchItemCount: ========");
        super.setInitialPrefetchItemCount(itemCount);
    }

    @Override
    public int getInitialPrefetchItemCount() {
        Log.i(TAG, "getInitialPrefetchItemCount: ========");
        return super.getInitialPrefetchItemCount();
    }

    @Override
    public void collectAdjacentPrefetchPositions(int dx, int dy, RecyclerView.State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        Log.i(TAG, "collectAdjacentPrefetchPositions: ========");
        super.collectAdjacentPrefetchPositions(dx, dy, state, layoutPrefetchRegistry);
    }

    @Override
    public void assertNotInLayoutOrScroll(String message) {
        Log.i(TAG, "assertNotInLayoutOrScroll: ========");
        super.assertNotInLayoutOrScroll(message);
    }

    @Override
    public int findFirstVisibleItemPosition() {
        Log.i(TAG, "findFirstVisibleItemPosition: ========");
        return super.findFirstVisibleItemPosition();
    }

    @Override
    public int findFirstCompletelyVisibleItemPosition() {
        Log.i(TAG, "findFirstCompletelyVisibleItemPosition: ========");
        return super.findFirstCompletelyVisibleItemPosition();
    }

    @Override
    public int findLastVisibleItemPosition() {
        Log.i(TAG, "findLastVisibleItemPosition: ========");
        return super.findLastVisibleItemPosition();
    }

    @Override
    public int findLastCompletelyVisibleItemPosition() {
        Log.i(TAG, "findLastCompletelyVisibleItemPosition: ========");
        return super.findLastCompletelyVisibleItemPosition();
    }

    @Override
    public View onFocusSearchFailed(View focused, int focusDirection, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.i(TAG, "onFocusSearchFailed: ========");
        return super.onFocusSearchFailed(focused, focusDirection, recycler, state);
    }

    @Override
    public boolean supportsPredictiveItemAnimations() {
        Log.i(TAG, "supportsPredictiveItemAnimations: ========");
        return super.supportsPredictiveItemAnimations();
    }

    @Override
    public void prepareForDrop(View view, View target, int x, int y) {
        Log.i(TAG, "prepareForDrop: ========");
        super.prepareForDrop(view, target, x, y);
    }
}
