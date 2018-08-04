package com.melody.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.melody.base.BasePermissionActivity.PERMISSION_TAKE_PHOTO;
import static com.melody.base.BasePermissionActivity.PERMISSION_TAKE_AUDIO;
import static com.melody.base.BasePermissionActivity.PERMISSION_TAKE_VIDEO;
import static com.melody.base.BasePermissionActivity.PERMISSION_STORAGE;

public abstract class BaseFragment extends Fragment {

    //log总开关、生命周期log开关、其他log开关
    private final boolean switch_log_total = true, switch_log_life_cycle = true, switch_log_others = true;

    private PermissionCallback permissionCallback = null;

    public Unbinder butterKnifeUnBinder = null;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        showLifeCycleLog("onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLifeCycleLog("onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        showLifeCycleLog("onCreateView()");
        onCreateViewStart();
        View fragmentView = inflater.inflate(getLayoutResourceId(), container, false);
        butterKnifeUnBinder = ButterKnife.bind(this, fragmentView);
        onCreateViewFinished(fragmentView);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showLifeCycleLog("onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        showLifeCycleLog("onStart()");
    }

    @Override
    public void onResume() {
        showLifeCycleLog("onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        showLifeCycleLog("onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        showLifeCycleLog("onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        showLifeCycleLog("onDestroyView()");
        if (butterKnifeUnBinder != null)
            butterKnifeUnBinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showLifeCycleLog("onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        showLifeCycleLog("onDetach()");
    }

    public void setPermissionCallback(PermissionCallback permissionCallback) {
        this.permissionCallback = permissionCallback;
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        showOthersLog("onLowMemory()");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        showOthersLog("onAttachFragment()");
        showOthersLog(childFragment.getClass().getName());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        showOthersLog("onHiddenChanged()");
        showOthersLog(hidden);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        showOthersLog("onConfigurationChanged()");
        showOthersLog(JSON.toJSON(newConfig));
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        showOthersLog("onDestroyOptionsMenu()");
    }

    /**
     * 成功获取权限后调用此方法后续操作
     *
     * @param permissionType 权限类型，必须是BasePermissionActivity中定义的类型
     */
    public void successAccessPermissions(String permissionType) {
        if (permissionType == null) {
            showLog("权限类型为空");
            return;
        }
        switch (permissionType) {
            case PERMISSION_TAKE_PHOTO:
                showLog("成功获取拍照权限");
                break;
            case PERMISSION_TAKE_VIDEO:
                showLog("成功获取录像权限");
                break;
            case PERMISSION_TAKE_AUDIO:
                showLog("成功获取录音权限");
                break;
            case PERMISSION_STORAGE:
                showLog("成功获取存储权限");
                break;
        }
    }

    public void requestPermission(String permissionType) {
        if (permissionType == null) {
            showLog("权限类型为空");
            return;
        }
        if (permissionCallback == null) {
            showLog("尚未设置权限回调");
            return;
        }
        permissionCallback.requestPermission(permissionType);

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

    // 设置布局
    public abstract int getLayoutResourceId();

    // 执行onCreateView()之前
    public void onCreateViewStart() {

    }

    // 执行onCreateView()之后（return之前）
    public void onCreateViewFinished(View fragmentView) {

    }

    //权限接口
    public interface PermissionCallback {
        /**
         * 权限回调
         *
         * @param permissionType 权限类型，必须是BasePermissionActivity中定义的类型
         */
        void requestPermission(String permissionType);
    }

}
