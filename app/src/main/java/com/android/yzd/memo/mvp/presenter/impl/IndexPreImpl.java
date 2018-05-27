package com.android.yzd.memo.mvp.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.view.View;

import com.android.yzd.memo.R;
import com.android.yzd.memo.databinding.ActivityIndexBinding;
import com.android.yzd.memo.mvp.presenter.ActivityPresenter;
import com.android.yzd.memo.mvp.ui.activity.EditActivity;
import com.android.yzd.memo.mvp.ui.view.IndexAView;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.functions.Action1;

public class IndexPreImpl implements ActivityPresenter, NavigationView.OnNavigationItemSelectedListener {

    private final Context mContext;
    private final ActivityIndexBinding mDataBinding;
    private final IndexAView mIndexView;
    private int currentSelectedItem = 0;
    private static long DOUBLE_CLICK_TIME = 0L;

    public IndexPreImpl(Context context, IndexAView view, ActivityIndexBinding dataBinding) {
        this.mContext = context;
        mIndexView = view;
        mDataBinding = dataBinding;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        mIndexView.initDrawerToggle();
        mIndexView.initXViewPager();
        FloatingActionButton fab = mDataBinding.fab;
        RxView.clicks(fab).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe((aVoid) ->mIndexView.readyGoForResult(EditActivity.class));
        mDataBinding.navigationView.setCheckedItem(R.id.nav_login_type);
        mDataBinding.navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void getIntent(Intent intent) {

    }

    @Override public void onResume() {

    }

    @Override public void onStart() {

    }

    @Override public void onPause() {

    }

    @Override public void onStop() {

    }

    @Override public void onDestroy() {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_login_type:
                currentSelectedItem = 0;
                mDataBinding.drawerLayout.closeDrawer(GravityCompat.START);
                mDataBinding.content.setCurrentItem(currentSelectedItem, false);
                break;
            case R.id.nav_mail_type:
                currentSelectedItem = 1;
                mDataBinding.drawerLayout.closeDrawer(GravityCompat.START);
                mDataBinding.content.setCurrentItem(currentSelectedItem, false);
                break;
            case R.id.nav_note_type:
                currentSelectedItem = 2;
                mDataBinding.drawerLayout.closeDrawer(GravityCompat.START);
                mDataBinding.content.setCurrentItem(currentSelectedItem, false);
                break;
            case R.id.nav_setting:
                mIndexView.go2Setting();
                break;
            default:break;
        }
        return true;
    }

    public boolean onBackPress() {
        if (mDataBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDataBinding.drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        }

        if (System.currentTimeMillis() - DOUBLE_CLICK_TIME > 2000) {
            DOUBLE_CLICK_TIME = System.currentTimeMillis();
            mIndexView.showSnackBar("再按一次退出~~");
            return false;
        } else {
            return true;
        }
    }
}
