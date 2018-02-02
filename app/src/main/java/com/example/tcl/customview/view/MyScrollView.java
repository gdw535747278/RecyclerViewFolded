package com.example.tcl.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by TCL on 2018/2/2.
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private MyScrollViewListener mMyScrollViewListener;
    public void addOnScrollerListener(MyScrollViewListener listener) {
        mMyScrollViewListener = listener;
    }
    public interface MyScrollViewListener{
        void addScrollerListener(int l, int t, int oldl, int oldt);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (mMyScrollViewListener != null) {
            mMyScrollViewListener.addScrollerListener(l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
