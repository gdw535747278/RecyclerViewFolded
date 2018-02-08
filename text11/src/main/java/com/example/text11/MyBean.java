package com.example.text11;

/**
 * Created by TCL on 2018/2/7.
 */

public class MyBean {
    private String title;
    private int type;

    public MyBean(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
