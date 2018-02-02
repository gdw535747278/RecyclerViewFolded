package com.example.tcl.customview.util;

import android.content.Context;

/**
 * Created by TCL on 2018/2/2.
 */

public class AppUtils {

    private static Context mContext;

    public static void setContext(Context context) {
        mContext = context;
    }

    public static String getString(int resId) {
        String string = mContext.getResources().getString(resId);
        return string;
    }

    public static void setPreReadPosition(String type, int position) {
        SPUtils.setInt(type, position);
    }

    public static int getPreReadPodition(String type) {
        return SPUtils.getInt(type);
    }
}
