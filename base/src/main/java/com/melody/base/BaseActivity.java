package com.melody.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<V extends BaseModel, T extends BaseView, P extends BasePresenter<V, T>>
        extends BasePermissionActivity {

    public Unbinder butterKnifeUnBinder = null;

    protected Context mContext;
    protected BaseActivity mActivity;

    protected P mPresenter;

    //log总开关、生命周期log开关、其他log开关
    private final boolean switch_log_total = true, switch_log_life_cycle = true, switch_log_others = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        onCreateStart();
        super.onCreate(savedInstanceState);
        showLifeCycleLog("onCreate()");
        preSetContentView();
        setContentView(getLayoutResourceId());
        afterSetContentView();
        butterKnifeUnBinder = ButterKnife.bind(this);
        mContext = this;
        mActivity = this;
        mPresenter = createPresenter();
        onCreateFinished();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLifeCycleLog("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLifeCycleLog("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLifeCycleLog("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLifeCycleLog("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLifeCycleLog("onDestroy()");
        mPresenter.detach();
        if (butterKnifeUnBinder != null)
            butterKnifeUnBinder.unbind();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showOthersLog("onNewIntent()");
        showOthersLog(JSON.toJSON(intent));
    }

    //旋转屏幕，销毁重建时的处理
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        showOthersLog("屏幕旋转    onSaveInstanceState()");
        showOthersLog(JSON.toJSON(outState));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showOthersLog("屏幕旋转    onRestoreInstanceState()");
        showOthersLog(JSON.toJSON(savedInstanceState));
    }

    //旋转屏幕，不销毁时处理
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        showOthersLog("屏幕旋转    onConfigurationChanged()");
        showOthersLog(JSON.toJSON(newConfig));
    }

    private void showLifeCycleLog(Object... contents) {
        if (switch_log_life_cycle) showLog(contents);
    }

    private void showOthersLog(Object... contents) {
        if (switch_log_others) showLog(contents);
    }

    private void showLog(Object... contents) {
        if (switch_log_total) LogUtils.e(contents);
    }

    /**
     * onCreate执行之前会执行此方法
     * 可重写做onCreate执行之前的相关操作
     */
    public void onCreateStart() {
    }

    /**
     * onCreate执行完毕会执行此方法
     * 可重写做onCreate执行完毕后的相关操作
     */
    public void onCreateFinished() {
    }

    // 重写可在setContentView之前做操作
    public void preSetContentView() {
    }

    // 重写可在setContentView之后做操作
    public void afterSetContentView() {
    }

    // 初始化Presenter
    public abstract P createPresenter();

    // 设置布局
    public abstract int getLayoutResourceId();

}
