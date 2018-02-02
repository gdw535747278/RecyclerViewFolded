package com.example.tcl.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tcl.customview.util.AppUtils;
import com.example.tcl.customview.util.SPUtils;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtils.setContext(this);
        SPUtils.setContext(this);
    }
}
