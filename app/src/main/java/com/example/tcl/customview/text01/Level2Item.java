package com.example.tcl.customview.text01;

/**
 * Created by TCL on 2018/1/29.
 */

public class Level2Item extends AbstractExpandableItem<Level3Item> implements MultiItemType {

    public String mTitle;
    public String mSubTitle;

    public Level2Item(String pTitle, String pSubTitle) {
        mTitle = pTitle;
        mSubTitle = pSubTitle;
    }

    public Level2Item(String title) {
        this(title, null);
    }

    @Override
    public int getItemType() {
        return Constants.TYPE_LEVEL_2;
    }

    @Override
    public int getLevel() {
        return Constants.TYPE_LEVEL_2;
    }
}
