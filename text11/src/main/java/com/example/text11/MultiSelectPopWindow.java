package com.example.text11;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TCL on 2018/2/7.
 */

public class MultiSelectPopWindow implements View.OnClickListener {

    private TextView selectedNumberTV;
    private TextView cancelBtn;
    private TextView confirmBtn;
    private TextView titleTV;
    private CheckBox selectAllBtn;
    private Builder mBuilder;
    public MultiSelectListAdapter mAdapter;
    public final PopupWindow mPopupWindow;

    public MultiSelectPopWindow(Builder builder) {
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

        initListener();
    }

    private void initListener() {
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpah(1.0f);
            }
        });
        selectAllBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        confirmBtn.setOnClickListener(this);

        mAdapter.addOnSelectChangeListener(new MultiSelectListAdapter.OnSelectChangeListener() {
            @Override
            public void changed(ArrayList<Integer> selectPosition, int selectNumber) {
                if (selectNumber == 0) {
                    cancelAll();

                } else if (selectNumber == mAdapter.getItemCount()) {
                    selectAll();
                }
                changeSelentNum(selectNumber);
            }
        });
    }

    private void changeSelentNum(int selectNumber) {
        if (selectNumber > 0) {
            selectedNumberTV.setVisibility(View.VISIBLE);
        }else{
            selectedNumberTV.setVisibility(View.GONE);
        }
        selectedNumberTV.setText("" + selectNumber);
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
        mAdapter = new MultiSelectListAdapter(mBuilder.mActivity,mBuilder.mNameList);
        recyclerView.setAdapter(mAdapter);
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

    public void show(View view) {
        if (mPopupWindow != null) {
            backgroundAlpah(0.8f);
            mPopupWindow.showAtLocation(view, Gravity.BOTTOM,0, 0);
        }
    }

    private void backgroundAlpah(float v) {
        try {
            WindowManager.LayoutParams params = mBuilder.mActivity.getWindow().getAttributes();
            params.alpha = v;
            mBuilder.mActivity.getWindow().setAttributes(params);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selectAllBtn:
                if (selectAllBtn.isChecked()) {
                    selectAll();

                } else {
                    cancelAll();
                }
                break;
            case R.id.cancelBtn:
                mPopupWindow.dismiss();
                break;
            case R.id.confirmBtn:
                Toast.makeText(mBuilder.mActivity, "选择了"+mAdapter.getSelectNumber()+"条", Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;
        }
    }

    private void cancelAll() {
        mAdapter.cancelAll();
        changeSelentNum(0);
        selectAllBtn.setChecked(false);
        selectAllBtn.setText("点击全选");
    }

    private void selectAll() {
        mAdapter.selectAll();
        changeSelentNum(mAdapter.getItemCount());
        selectAllBtn.setChecked(true);
        selectAllBtn.setText("取消全选");
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
