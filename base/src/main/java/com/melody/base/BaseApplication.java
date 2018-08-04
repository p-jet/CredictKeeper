package com.melody.base;

import android.support.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;

public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        // init Logger
        Utils.init(this);


    }
}
