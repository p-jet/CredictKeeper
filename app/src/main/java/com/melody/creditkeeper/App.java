package com.melody.creditkeeper;

import com.melody.base.BaseApplication;
import com.melody.creditkeeper.utils.SkinUtils;

public class App extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        //初始化皮肤库
        SkinUtils.getInstance().init(this);

    }

}
