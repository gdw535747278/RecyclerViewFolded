package com.example.tcl.customview.text01;

/**
 * Created by TCL on 2018/1/29.
 */

public class Level3Item implements MultiItemType {

    public Level3Item(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    public String name;
    public int resId;


    @Override
    public int getItemType() {
        return Constants.TYPE_LEVEL_3;
    }
}
