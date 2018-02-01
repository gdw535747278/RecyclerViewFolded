package com.example.tcl.customview.text01;

import java.util.List;

/**
 * Created by TCL on 2018/1/29.
 */

public interface IExpandable<T> {
    void setExpanded(boolean pExpanded);
    boolean isExpanded();

    List<T> getSubItems();
    int getLevel();
}
