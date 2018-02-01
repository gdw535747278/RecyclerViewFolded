package com.example.tcl.customview.text01;

/**
 * Created by TCL on 2018/1/29.
 */

public class Level1Item extends AbstractExpandableItem implements MultiItemType {

    public String title;
    public String subTitle;

    public Level1Item(String pTitle, String pSubTitle) {
        title = pTitle;
        subTitle = pSubTitle;
    }

    @Override
    public int getItemType() {
        return Constants.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return Constants.TYPE_LEVEL_1;
    }
}
