package com.example.text11;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by TCL on 2018/2/5.
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    public static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    public static int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    public static int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    private int mOrientation;
    public Drawable mDivider;
    public int mDividerHeight;
    public Drawable mDrawable;
    public Paint mPaint;

    public MyItemDecoration(Context context,int orientation) {
//        this(context, orientation, 0);
        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        mDrawable = typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientation(orientation);
    }

    /**
     *
     * @param context 上下文
     * @param orientation 列表方向
     * @param drawableId 分割线资源id
     */
    public MyItemDecoration(Context context,int orientation,int drawableId) {
        this(context,orientation);
        mDivider = ContextCompat.getDrawable(context, drawableId);
        mDividerHeight = mDivider.getIntrinsicHeight();
    }

    public MyItemDecoration(Context context,int orientation,int dividerHeight,int dividerColor) {
        this(context, orientation);
        mDividerHeight = dividerHeight;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(context.getResources().getColor(dividerColor));
        mPaint.setStyle(Paint.Style.FILL);
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("布局方向错误");
        }

        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = parent.getChildAt(i);
            RecyclerView recyclerView = new RecyclerView(parent.getContext());
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            int left = view.getRight() + params.rightMargin;
            int right = left + mDividerHeight;

            if (mDivider != null) {
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }

            if (mPaint != null) {
                c.drawRect(left,top,right,bottom,mPaint);
            }
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {

            View view = parent.getChildAt(i);
            RecyclerView recyclerView = new MyRecyclerView(parent.getContext());
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            int top = view.getBottom() + params.bottomMargin;
            int bottom = top + mDividerHeight;

            if (mDivider != null) {
                mDivider.setBounds(left,top,right,bottom);
                mDivider.draw(c);
            }

            if (mPaint != null) {
                c.drawRect(left,top,right,bottom,mPaint);
            }
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDividerHeight);
        } else {
            outRect.set(0,0,mDividerHeight,0);
        }
        super.getItemOffsets(outRect, view, parent, state);

    }
}
