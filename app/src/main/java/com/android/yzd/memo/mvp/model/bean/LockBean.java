package com.android.yzd.memo.mvp.model.bean;

public class LockBean {

    private String warn;
    private int color;

    public LockBean(String name ) {
        this.warn = name;
    }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

}
