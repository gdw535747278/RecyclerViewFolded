package com.example.text11;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TCL on 2018/2/7.
 */

public class MultiSelectPopWindow {

    private TextView selectedNumberTV;
    private TextView cancelBtn;
    private TextView confirmBtn;
    private TextView titleTV;
    private CheckBox selectAllBtn;
    private Builder mBuilder;
    public final PopupWindow mPopupWindow;

    private MultiSelectPopWindow(Builder builder) {
        this.mBuilder = builder;

        View view = LayoutInflater.from(mBuilder.mActivity).inflate(R.layout.multi_select_list_popwindow, null, false);
        mPopupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setAnimationStyle(R.style.popwindow_anim_style);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(mBuilder.isOutSideTouchable);
        initView(mPopupWindow.getContentView());

    }

    private void initView(View contentView) {
        titleTV = contentView.findViewById(R.id.title);
        cancelBtn = contentView.findViewById(R.id.cancelBtn);
        confirmBtn = contentView.findViewById(R.id.confirmBtn);
        selectedNumberTV = contentView.findViewById(R.id.selectedNumber);
        selectAllBtn = contentView.findViewById(R.id.selectAllBtn);

        setTextView(titleTV, mBuilder.titleText, mBuilder.mTitleTextColor);
        setTextView(cancelBtn, mBuilder.cancleText, mBuilder.mCancelTextColor);
        setTextView(confirmBtn, mBuilder.confirmText, mBuilder.mConfirmTextColor);

        RecyclerView recyclerView = mPopupWindow.getContentView().findViewById(R.id.mRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mBuilder.mActivity, LinearLayoutManager.VERTICAL, false));

    }

    private void setTextView(TextView view, String text, int color) {
        if (view != null) {
            if (text != null) {
                view.setText(text);
            }
            if (color != 0) {
                view.setTextColor(color);
            }
        }
    }

    private void setTextView(TextView view, String text) {
        setTextView(view, text, 0);
    }

    public interface OnConfirmClickListener {
        void onClick();
    }


    public static class Builder {
        private Activity mActivity;
        private List<String> mNameList;
        private OnConfirmClickListener mOnConfirmClickListener;
        private String cancleText;
        private String confirmText;
        private String titleText;
        public boolean isOutSideTouchable;
        public int mTitleTextColor;
        private int mConfirmTextColor;
        private int mCancelTextColor;

        public Builder(Activity activity) {
            this.mActivity = activity;
        }

        public Builder setNameArray(List<String> list) {
            this.mNameList = list;
            return this;
        }

        public Builder setConfirmListener(OnConfirmClickListener listener) {
            this.mOnConfirmClickListener = listener;
            return this;
        }

        public Builder setCancle(String string) {
            this.cancleText = string;
            return this;
        }

        public Builder setConfirm(String string) {
            this.confirmText = string;
            return this;
        }

        public Builder setTitle(String string) {
            this.titleText = string;
            return this;
        }

        public Builder setConfirmTextColor(int color) {
            this.mConfirmTextColor = color;
            return this;
        }

        public Builder setTitleColor(int color) {
            this.mTitleTextColor = color;
            return this;
        }

        public Builder setCancelTextColor(int color) {
            this.mCancelTextColor = color;
            return this;
        }

        public MultiSelectPopWindow build() {
            return new MultiSelectPopWindow(this);
        }

    }
}
