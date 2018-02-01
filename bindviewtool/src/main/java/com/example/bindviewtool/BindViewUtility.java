package com.example.bindviewtool;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by TCL on 2018/1/19.
 */

public class BindViewUtility {
    public static void bind(Activity pActivity) {
        bind(pActivity,pActivity.getWindow().getDecorView());
    }


    public static void bind(Object bindViewSource, View pView) {
        Class<?> vClass = bindViewSource.getClass();
        for (; vClass != Object.class; vClass = vClass.getSuperclass()) {
            Field[] vFields = vClass.getDeclaredFields();
            if (vFields != null && vFields.length > 0) {
                for (Field vField : vFields) {
                    BindView vBindView = vField.getAnnotation(BindView.class);
                    if (vBindView != null) {
                        int vId = vBindView.value();
                        if (vId != 0) {
                            try {
                                vField.setAccessible(true);
                                vField.set(bindViewSource, pView.findViewById(vId));
                            } catch (IllegalAccessException pE) {
//                                pE.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
