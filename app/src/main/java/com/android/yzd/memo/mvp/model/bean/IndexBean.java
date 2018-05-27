package com.android.yzd.memo.mvp.model.bean;


public class IndexBean {

    private String toolBarTitle;

    public IndexBean(String title) {
        this.toolBarTitle = title;
    }

    public void setToolBarTitle(String title) {
        this.toolBarTitle = title;
    }

    public String getToolBarTitle() {
        return this.toolBarTitle;
    }
}
