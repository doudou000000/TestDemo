package com.test.demo.test.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.test.demo.test.BuildConfig;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
//        ARouter.getInstance().destroy();
    }
}
