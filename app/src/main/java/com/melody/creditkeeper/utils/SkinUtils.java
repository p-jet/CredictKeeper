package com.melody.creditkeeper.utils;

import android.app.Application;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;

import skin.support.SkinCompatManager;
import skin.support.content.res.ColorState;
import skin.support.content.res.SkinCompatUserThemeManager;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * 皮肤工具
 */
public class SkinUtils {

    //是否初始化
    private boolean isInit = false;

    public static SkinUtils getInstance() {
        return SkinUtilsInner.instance;
    }

    private static class SkinUtilsInner {
        private static SkinUtils instance = new SkinUtils();
    }

    //初始化方法
    public void init(Application application) {
        if (isInit) return;
        SkinCompatManager.withoutActivity(application)                         // 基础控件换肤初始化
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
//                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
//                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
                .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();
    }

    public void loadSkin(final String skinName, int strategy) {
        if (StringUtils.isEmpty(skinName)) return;
        if (!skinName.endsWith(".skin")) return;
        // 指定皮肤插件
        SkinCompatManager.getInstance().loadSkin(skinName, new SkinCompatManager.SkinLoaderListener() {
            @Override
            public void onStart() {
                LogUtils.i("skin " + skinName + " start load.");
            }

            @Override
            public void onSuccess() {
                LogUtils.i("skin " + skinName + " load sucdess.");
            }

            @Override
            public void onFailed(String errMsg) {
                LogUtils.e("skin " + skinName + " load failed.");
            }
        }, strategy);
    }

    /**
     * 注: 如果使用这种方式来增加换肤资源，记得在build.gradle 中配置一下这个资源目录
     * sourceSets {main {res.srcDirs = ['src/main/res', 'src/main/res-night']}}
     *
     * @param skinName 皮肤包名称
     * @param strategy SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN // 后缀加载
     *                 SkinCompatManager.SKIN_LOADER_STRATEGY_PREFIX_BUILD_IN // 前缀加载
     */
    public void loadSkinInner(String skinName, int strategy) {
        SkinCompatManager.getInstance().loadSkin(skinName, strategy);
    }

    public void loadDefaultSkin() {
        // 恢复应用默认皮肤
        SkinCompatManager.getInstance().restoreDefaultTheme();
    }

    /**
     * 动态设置color
     */
    public void setColor(@ColorRes int colorRes, String colorDefault) {
        SkinCompatUserThemeManager.get().addColorState(colorRes, colorDefault);
        SkinCompatUserThemeManager.get().apply();
    }

    public void setColor(@ColorRes int colorRes, ColorState colorState) {
        SkinCompatUserThemeManager.get().addColorState(colorRes, colorState);
        SkinCompatUserThemeManager.get().apply();

    }

    public void clearColor() {
        // 清除所有已有颜色值。
        SkinCompatUserThemeManager.get().clearColors();
        SkinCompatUserThemeManager.get().apply();
    }

    /**
     * 动态设置图片
     */
    public void setDrawable(@DrawableRes int drawableRes, String drawablePath) {
        SkinCompatUserThemeManager.get().addDrawablePath(drawableRes, drawablePath);
        SkinCompatUserThemeManager.get().apply();
    }

    public void setDrawable(@DrawableRes int drawableRes, String drawablePath, int angle) {
        // 要换肤的资源id，图片路径，图片旋转角度(默认为0)
        SkinCompatUserThemeManager.get().addDrawablePath(drawableRes, drawablePath, angle);
        SkinCompatUserThemeManager.get().apply();
    }

    public void clearDrawable() {
        // 清除所有已有图片路径。
        SkinCompatUserThemeManager.get().clearDrawables();
        SkinCompatUserThemeManager.get().apply();
    }


}
