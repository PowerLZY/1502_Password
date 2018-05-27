package com.android.yzd.memo.mvp.ui.activity;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.yzd.memo.R;
import com.android.yzd.memo.databinding.ActivityAboutBinding;
import com.android.yzd.memo.mvp.model.evenbus.EventCenter;
import com.android.yzd.memo.mvp.presenter.impl.AboutAImpl;
import com.android.yzd.memo.mvp.ui.activity.base.BaseActivity;
import com.android.yzd.memo.mvp.ui.activity.base.BaseSwipeBackActivity;
import com.android.yzd.memo.mvp.ui.view.AboutAView;

import butterknife.Bind;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity implements AboutAView {

    @Bind(R.id.common_toolbar) Toolbar mToolBar;
    private AboutAImpl mAboutImpl;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAboutBinding mDataBinding = (ActivityAboutBinding) super.mDataBinding;
        mAboutImpl = new AboutAImpl(this, this, mDataBinding);
        mAboutImpl.onCreate(savedInstanceState);
        mAboutImpl.getIntent(getIntent());
    }

    @Override protected void onEventComing(EventCenter eventCenter) {

    }

    @Override protected int getContentView() {
        return R.layout.activity_about;
    }

    @Override protected void initToolbar() {
        initToolBar(mToolBar);
        mToolBar.setTitle("关于");
    }

    @Override protected boolean isApplyTranslucency() {
        return true;
    }

    @Override protected boolean isApplyButterKnife() {
        return true;
    }

    @Override protected boolean isApplyEventBus() {
        return false;
    }

    @Override protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }

    @OnClick(R.id.codeButton) public void onClick(View view) {
        mAboutImpl.codeClick(view);
    }
    @Override protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    public void go2Activity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
