package com.example.text11;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;

import java.util.ArrayList;

/**
 * Created by TCL on 2018/2/5.
 */

public class MyRecyclerView extends RecyclerView {
    private String TAG = "MyRecyclerView";

    public MyRecyclerView(Context context) {
        this(context, null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        Log.i(TAG, "getCompatAccessibilityDelegate: ========");
        return super.getCompatAccessibilityDelegate();
    }

    @Override
    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate accessibilityDelegate) {
        Log.i(TAG, "setAccessibilityDelegateCompat: ========");
        super.setAccessibilityDelegateCompat(accessibilityDelegate);
    }

    @Override
    public void setHasFixedSize(boolean hasFixedSize) {
        Log.i(TAG, "setHasFixedSize: ========");
        super.setHasFixedSize(hasFixedSize);
    }

    @Override
    public boolean hasFixedSize() {
        Log.i(TAG, "hasFixedSize: ========");
        return super.hasFixedSize();
    }

    @Override
    public void setClipToPadding(boolean clipToPadding) {
        Log.i(TAG, "setClipToPadding: ========");
        super.setClipToPadding(clipToPadding);
    }

    @Override
    public boolean getClipToPadding() {
        Log.i(TAG, "getClipToPadding: ========");
        return super.getClipToPadding();
    }

    @Override
    public void setScrollingTouchSlop(int slopConstant) {
        Log.i(TAG, "setScrollingTouchSlop: ========");
        super.setScrollingTouchSlop(slopConstant);
    }

    @Override
    public void swapAdapter(Adapter adapter, boolean removeAndRecycleExistingViews) {
        Log.i(TAG, "swapAdapter: ========");
        super.swapAdapter(adapter, removeAndRecycleExistingViews);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        Log.i(TAG, "setAdapter: ========");
        super.setAdapter(adapter);
    }

    @Override
    public Adapter getAdapter() {
        Log.i(TAG, "getAdapter: ========");
        return super.getAdapter();
    }

    @Override
    public void setRecyclerListener(RecyclerListener listener) {
        Log.i(TAG, "setRecyclerListener: ========");
        super.setRecyclerListener(listener);
    }

    @Override
    public int getBaseline() {
        Log.i(TAG, "getBaseline: ========");
        return super.getBaseline();
    }

    @Override
    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener listener) {
        Log.i(TAG, "addOnChildAttachStateChangeListener: ========");
        super.addOnChildAttachStateChangeListener(listener);
    }

    @Override
    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener listener) {
        Log.i(TAG, "removeOnChildAttachStateChangeListener: ========");
        super.removeOnChildAttachStateChangeListener(listener);
    }

    @Override
    public void clearOnChildAttachStateChangeListeners() {
        Log.i(TAG, "clearOnChildAttachStateChangeListeners: ========");
        super.clearOnChildAttachStateChangeListeners();
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        Log.i(TAG, "setLayoutManager: ========");
        super.setLayoutManager(layout);
    }

    @Override
    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        Log.i(TAG, "setOnFlingListener: ========");
        super.setOnFlingListener(onFlingListener);
    }

    @Nullable
    @Override
    public OnFlingListener getOnFlingListener() {
        Log.i(TAG, "getOnFlingListener: ========");
        return super.getOnFlingListener();
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Log.i(TAG, "onSaveInstanceState: ========");
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Log.i(TAG, "onRestoreInstanceState: ========");
        super.onRestoreInstanceState(state);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        Log.i(TAG, "dispatchSaveInstanceState: ========");
        super.dispatchSaveInstanceState(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        Log.i(TAG, "dispatchRestoreInstanceState: ========");
        super.dispatchRestoreInstanceState(container);
    }

    @Override
    public LayoutManager getLayoutManager() {
        Log.i(TAG, "getLayoutManager: ========");
        return super.getLayoutManager();
    }

    @Override
    public RecycledViewPool getRecycledViewPool() {
        Log.i(TAG, "getRecycledViewPool: ========");
        return super.getRecycledViewPool();
    }

    @Override
    public void setRecycledViewPool(RecycledViewPool pool) {
        Log.i(TAG, "setRecycledViewPool: ========");
        super.setRecycledViewPool(pool);
    }

    @Override
    public void setViewCacheExtension(ViewCacheExtension extension) {
        Log.i(TAG, "setViewCacheExtension: ========");
        super.setViewCacheExtension(extension);
    }

    @Override
    public void setItemViewCacheSize(int size) {
        Log.i(TAG, "setItemViewCacheSize: ========");
        super.setItemViewCacheSize(size);
    }

    @Override
    public int getScrollState() {
        Log.i(TAG, "getScrollState: ========");
        return super.getScrollState();
    }

    @Override
    public void addItemDecoration(ItemDecoration decor, int index) {
        Log.i(TAG, "addItemDecoration: ========");
        super.addItemDecoration(decor, index);
    }

    @Override
    public void addItemDecoration(ItemDecoration decor) {
        Log.i(TAG, "addItemDecoration: ========");
        super.addItemDecoration(decor);
    }

    @Override
    public ItemDecoration getItemDecorationAt(int index) {
        Log.i(TAG, "getItemDecorationAt: ========");
        return super.getItemDecorationAt(index);
    }

    @Override
    public int getItemDecorationCount() {
        Log.i(TAG, "getItemDecorationCount: ========");
        return super.getItemDecorationCount();
    }

    @Override
    public void removeItemDecorationAt(int index) {
        Log.i(TAG, "removeItemDecorationAt: ========");
        super.removeItemDecorationAt(index);
    }

    @Override
    public void removeItemDecoration(ItemDecoration decor) {
        Log.i(TAG, "removeItemDecoration: ========");
        super.removeItemDecoration(decor);
    }

    @Override
    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        Log.i(TAG, "setChildDrawingOrderCallback: ========");
        super.setChildDrawingOrderCallback(childDrawingOrderCallback);
    }

    @Override
    public void setOnScrollListener(OnScrollListener listener) {
        Log.i(TAG, "setOnScrollListener: ========");
        super.setOnScrollListener(listener);
    }

    @Override
    public void addOnScrollListener(OnScrollListener listener) {
        Log.i(TAG, "addOnScrollListener: ========");
        super.addOnScrollListener(listener);
    }

    @Override
    public void removeOnScrollListener(OnScrollListener listener) {
        Log.i(TAG, "removeOnScrollListener: ========");
        super.removeOnScrollListener(listener);
    }

    @Override
    public void clearOnScrollListeners() {
        Log.i(TAG, "clearOnScrollListeners: ========");
        super.clearOnScrollListeners();
    }

    @Override
    public void scrollToPosition(int position) {
        Log.i(TAG, "scrollToPosition: ========");
        super.scrollToPosition(position);
    }

    @Override
    public void smoothScrollToPosition(int position) {
        Log.i(TAG, "smoothScrollToPosition: ========");
        super.smoothScrollToPosition(position);
    }

    @Override
    public void scrollTo(int x, int y) {
        Log.i(TAG, "scrollTo: ========");
        super.scrollTo(x, y);
    }

    @Override
    public void scrollBy(int x, int y) {
        Log.i(TAG, "scrollBy: ========");
        super.scrollBy(x, y);
    }

    @Override
    public int computeHorizontalScrollOffset() {
        Log.i(TAG, "computeHorizontalScrollOffset: ========");
        return super.computeHorizontalScrollOffset();
    }

    @Override
    public int computeHorizontalScrollExtent() {
        Log.i(TAG, "computeHorizontalScrollExtent: ========");
        return super.computeHorizontalScrollExtent();
    }

    @Override
    public int computeHorizontalScrollRange() {
        Log.i(TAG, "computeHorizontalScrollRange: ========");
        return super.computeHorizontalScrollRange();
    }

    @Override
    public int computeVerticalScrollOffset() {
        Log.i(TAG, "computeVerticalScrollOffset: ========");
        return super.computeVerticalScrollOffset();
    }

    @Override
    public int computeVerticalScrollExtent() {
        Log.i(TAG, "computeVerticalScrollExtent: ========");
        return super.computeVerticalScrollExtent();
    }

    @Override
    public int computeVerticalScrollRange() {
        Log.i(TAG, "computeVerticalScrollRange: ========");
        return super.computeVerticalScrollRange();
    }

    @Override
    public void setLayoutFrozen(boolean frozen) {
        Log.i(TAG, "setLayoutFrozen: ========");
        super.setLayoutFrozen(frozen);
    }

    @Override
    public boolean isLayoutFrozen() {
        Log.i(TAG, "isLayoutFrozen: ========");
        return super.isLayoutFrozen();
    }

    @Override
    public void smoothScrollBy(int dx, int dy) {
        Log.i(TAG, "smoothScrollBy: ========");
        super.smoothScrollBy(dx, dy);
    }

    @Override
    public void smoothScrollBy(int dx, int dy, Interpolator interpolator) {
        Log.i(TAG, "smoothScrollBy: ========");
        super.smoothScrollBy(dx, dy, interpolator);
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        Log.i(TAG, "fling: ========");
        return super.fling(velocityX, velocityY);
    }

    @Override
    public void stopScroll() {
        Log.i(TAG, "stopScroll: ========");
        super.stopScroll();
    }

    @Override
    public int getMinFlingVelocity() {
        Log.i(TAG, "getMinFlingVelocity: ========");
        return super.getMinFlingVelocity();
    }

    @Override
    public int getMaxFlingVelocity() {
        Log.i(TAG, "getMaxFlingVelocity: ========");
        return super.getMaxFlingVelocity();
    }

    @Override
    public View focusSearch(View focused, int direction) {
        Log.i(TAG, "focusSearch: ========");
        return super.focusSearch(focused, direction);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        Log.i(TAG, "requestChildFocus: ========");
        super.requestChildFocus(child, focused);
    }

    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        Log.i(TAG, "requestChildRectangleOnScreen: ========");
        return super.requestChildRectangleOnScreen(child, rect, immediate);
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        Log.i(TAG, "addFocusables: ========");
        super.addFocusables(views, direction, focusableMode);
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        Log.i(TAG, "onRequestFocusInDescendants: ========");
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.i(TAG, "onAttachedToWindow: ========");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.i(TAG, "onDetachedFromWindow: ========");
        super.onDetachedFromWindow();
    }

    @Override
    public boolean isAttachedToWindow() {
        Log.i(TAG, "isAttachedToWindow: ========");
        return super.isAttachedToWindow();
    }

    @Override
    public void addOnItemTouchListener(OnItemTouchListener listener) {
        Log.i(TAG, "addOnItemTouchListener: ========");
        super.addOnItemTouchListener(listener);
    }

    @Override
    public void removeOnItemTouchListener(OnItemTouchListener listener) {
        Log.i(TAG, "removeOnItemTouchListener: ========");
        super.removeOnItemTouchListener(listener);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.i(TAG, "onInterceptTouchEvent: ========");
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.i(TAG, "requestDisallowInterceptTouchEvent: ========");
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.i(TAG, "onTouchEvent: ========");
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Log.i(TAG, "onGenericMotionEvent: ========");
        return super.onGenericMotionEvent(event);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        Log.i(TAG, "onMeasure: ========");
        super.onMeasure(widthSpec, heightSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i(TAG, "onSizeChanged: ========");
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public void setItemAnimator(ItemAnimator animator) {
        Log.i(TAG, "setItemAnimator: ========");
        super.setItemAnimator(animator);
    }

    @Override
    public boolean isComputingLayout() {
        Log.i(TAG, "isComputingLayout: ========");
        return super.isComputingLayout();
    }

    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        Log.i(TAG, "sendAccessibilityEventUnchecked: ========");
        super.sendAccessibilityEventUnchecked(event);
    }

    @Override
    public ItemAnimator getItemAnimator() {
        Log.i(TAG, "getItemAnimator: ========");
        return super.getItemAnimator();
    }

    @Override
    protected void removeDetachedView(View child, boolean animate) {
        Log.i(TAG, "removeDetachedView: ========");
        super.removeDetachedView(child, animate);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i(TAG, "onLayout: ========");
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public void requestLayout() {
        Log.i(TAG, "requestLayout: ========");
        super.requestLayout();
    }

    @Override
    public void draw(Canvas c) {
        Log.i(TAG, "draw: ========");
        super.draw(c);
    }

    @Override
    public void onDraw(Canvas c) {
        Log.i(TAG, "onDraw: ========");
        super.onDraw(c);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        Log.i(TAG, "checkLayoutParams: ========");
        return super.checkLayoutParams(p);
    }

    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        Log.i(TAG, "generateDefaultLayoutParams: ========");
        return super.generateDefaultLayoutParams();
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        Log.i(TAG, "generateLayoutParams: ========");
        return super.generateLayoutParams(attrs);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        Log.i(TAG, "generateLayoutParams: ========");
        return super.generateLayoutParams(p);
    }

    @Override
    public boolean isAnimating() {
        Log.i(TAG, "isAnimating: ========");
        return super.isAnimating();
    }

    @Override
    public void invalidateItemDecorations() {
        Log.i(TAG, "invalidateItemDecorations: ========");
        super.invalidateItemDecorations();
    }

    @Override
    public boolean getPreserveFocusAfterLayout() {
        Log.i(TAG, "getPreserveFocusAfterLayout: ========");
        return super.getPreserveFocusAfterLayout();
    }

    @Override
    public void setPreserveFocusAfterLayout(boolean preserveFocusAfterLayout) {
        Log.i(TAG, "setPreserveFocusAfterLayout: ========");
        super.setPreserveFocusAfterLayout(preserveFocusAfterLayout);
    }

    @Override
    public ViewHolder getChildViewHolder(View child) {
        Log.i(TAG, "getChildViewHolder: ========");
        return super.getChildViewHolder(child);
    }

    @Nullable
    @Override
    public View findContainingItemView(View view) {
        Log.i(TAG, "findContainingItemView: ========");
        return super.findContainingItemView(view);
    }

    @Nullable
    @Override
    public ViewHolder findContainingViewHolder(View view) {
        Log.i(TAG, "findContainingViewHolder: ========");
        return super.findContainingViewHolder(view);
    }

    @Override
    public int getChildPosition(View child) {
        Log.i(TAG, "getChildPosition: ========");
        return super.getChildPosition(child);
    }

    @Override
    public int getChildAdapterPosition(View child) {
        Log.i(TAG, "getChildAdapterPosition: ========");
        return super.getChildAdapterPosition(child);
    }

    @Override
    public int getChildLayoutPosition(View child) {
        Log.i(TAG, "getChildLayoutPosition: ========");
        return super.getChildLayoutPosition(child);
    }

    @Override
    public long getChildItemId(View child) {
        Log.i(TAG, "getChildItemId: ========");
        return super.getChildItemId(child);
    }

    @Override
    public ViewHolder findViewHolderForPosition(int position) {
        Log.i(TAG, "findViewHolderForPosition: ========");
        return super.findViewHolderForPosition(position);
    }

    @Override
    public ViewHolder findViewHolderForLayoutPosition(int position) {
        Log.i(TAG, "findViewHolderForLayoutPosition: ========");
        return super.findViewHolderForLayoutPosition(position);
    }

    @Override
    public ViewHolder findViewHolderForAdapterPosition(int position) {
        Log.i(TAG, "findViewHolderForAdapterPosition: ========");
        return super.findViewHolderForAdapterPosition(position);
    }

    @Override
    public ViewHolder findViewHolderForItemId(long id) {
        Log.i(TAG, "findViewHolderForItemId: ========");
        return super.findViewHolderForItemId(id);
    }

    @Override
    public View findChildViewUnder(float x, float y) {
        Log.i(TAG, "findChildViewUnder: ========");
        return super.findChildViewUnder(x, y);
    }

    @Override
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Log.i(TAG, "drawChild: ========");
        return super.drawChild(canvas, child, drawingTime);
    }

    @Override
    public void offsetChildrenVertical(int dy) {
        Log.i(TAG, "offsetChildrenVertical: ========");
        super.offsetChildrenVertical(dy);
    }

    @Override
    public void onChildAttachedToWindow(View child) {
        Log.i(TAG, "onChildAttachedToWindow: ========");
        super.onChildAttachedToWindow(child);
    }

    @Override
    public void onChildDetachedFromWindow(View child) {
        Log.i(TAG, "onChildDetachedFromWindow: ========");
        super.onChildDetachedFromWindow(child);
    }

    @Override
    public void offsetChildrenHorizontal(int dx) {
        Log.i(TAG, "offsetChildrenHorizontal: ========");
        super.offsetChildrenHorizontal(dx);
    }

    @Override
    public void getDecoratedBoundsWithMargins(View view, Rect outBounds) {
        Log.i(TAG, "getDecoratedBoundsWithMargins: ========");
        super.getDecoratedBoundsWithMargins(view, outBounds);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        Log.i(TAG, "onScrolled: ========");
        super.onScrolled(dx, dy);
    }

    @Override
    public void onScrollStateChanged(int state) {
        Log.i(TAG, "onScrollStateChanged: ========");
        super.onScrollStateChanged(state);
    }

    @Override
    public boolean hasPendingAdapterUpdates() {
        Log.i(TAG, "hasPendingAdapterUpdates: ========");
        return super.hasPendingAdapterUpdates();
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        Log.i(TAG, "setNestedScrollingEnabled: ========");
        super.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        Log.i(TAG, "isNestedScrollingEnabled: ========");
        return super.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        Log.i(TAG, "startNestedScroll: ========");
        return super.startNestedScroll(axes);
    }

    @Override
    public boolean startNestedScroll(int axes, int type) {
        Log.i(TAG, "startNestedScroll: ========");
        return super.startNestedScroll(axes, type);
    }

    @Override
    public void stopNestedScroll() {
        Log.i(TAG, "stopNestedScroll: ========");
        super.stopNestedScroll();
    }

    @Override
    public void stopNestedScroll(int type) {
        Log.i(TAG, "stopNestedScroll: ========");
        super.stopNestedScroll(type);
    }

    @Override
    public boolean hasNestedScrollingParent() {
        Log.i(TAG, "hasNestedScrollingParent: ========");
        return super.hasNestedScrollingParent();
    }

    @Override
    public boolean hasNestedScrollingParent(int type) {
        Log.i(TAG, "hasNestedScrollingParent: ========");
        return super.hasNestedScrollingParent(type);
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        Log.i(TAG, "dispatchNestedScroll: ========");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        Log.i(TAG, "dispatchNestedScroll: ========");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        Log.i(TAG, "dispatchNestedPreScroll: ========");
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        Log.i(TAG, "dispatchNestedPreScroll: ========");
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Log.i(TAG, "dispatchNestedFling: ========");
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        Log.i(TAG, "dispatchNestedPreFling: ========");
        return super.dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        Log.i(TAG, "getChildDrawingOrder: ========");
        return super.getChildDrawingOrder(childCount, i);
    }
}
