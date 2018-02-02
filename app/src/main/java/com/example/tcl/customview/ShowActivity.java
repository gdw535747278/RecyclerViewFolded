package com.example.tcl.customview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.bindviewtool.BindView;
import com.example.bindviewtool.BindViewUtility;
import com.example.tcl.customview.text01.Constants;
import com.example.tcl.customview.util.AppUtils;
import com.example.tcl.customview.view.MyScrollView;

public class ShowActivity extends AppCompatActivity {

    public String mString;
    public ActionBar mActionBar;
    private String TAG = "ShowActivity";
    public String mType;

    @BindView(R.id.sv_show)
    MyScrollView mScrollView;

    @BindView(R.id.tv_show)
    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        BindViewUtility.bind(this);
        initActionBar();
        initData();
        initView();
    }

    @Override
    protected void onResume() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mScrollView.scrollTo(0, AppUtils.getPreReadPodition(Constants.TYPE));
            }
        }, 100);

        super.onResume();
    }

    private void initActionBar() {
        mActionBar = getSupportActionBar();
        mActionBar.hide();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        mTextView.setText(mString);

        mScrollView.addOnScrollerListener(new MyScrollView.MyScrollViewListener() {
            @Override
            public void addScrollerListener(int l, int t, int oldl, int oldt) {
                AppUtils.setPreReadPosition(Constants.TYPE, t);
            }
        });

        mScrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);

    }

    private void initData() {
        Intent intent = getIntent();
        int resId = intent.getIntExtra(Constants.DETAIL, 0);
        mType = intent.getStringExtra(Constants.TYPE);
        if (resId != 0) {
            mString = AppUtils.getString(resId);
        }
    }
}
