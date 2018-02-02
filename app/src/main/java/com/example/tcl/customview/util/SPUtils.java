package com.example.tcl.customview.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by TCL on 2018/2/2.
 */

public class SPUtils {

    public static Context mContext;
    public static SharedPreferences mSP;
    public static SharedPreferences.Editor mEdit;

    public static void setContext(Context context) {
        mContext = context;
        mSP = mContext.getSharedPreferences("readPosition", Context.MODE_PRIVATE);
        mEdit = mSP.edit();
    }


    public static void setInt(String type, int position) {
        mEdit.putInt(type, position);
        mEdit.commit();
    }

    public static int getInt(String type) {
        return mSP.getInt(type, 0);
    }

}
