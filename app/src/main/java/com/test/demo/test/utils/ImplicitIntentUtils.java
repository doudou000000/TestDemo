package com.test.demo.test.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * 隐示意图
 * Created by DEV002 on 2018/5/17.
 */

public class ImplicitIntentUtils {

    private Context context;

    public ImplicitIntentUtils(Context context) {
        this.context = context;
    }

    /**
     * 判断手机中是否含有APP可以启动这个隐示意图
     * @param intent 隐示意图
     * @return true表示有，false表示没有
     */
    public boolean verifyApp(Intent intent){
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }

    /**
     * 发送一个简单的隐示意图
     * @param action
     * @param uri
     */
    public void sendImplicitIntent(String action, Uri uri){
        Intent intent = new Intent(action,uri);
        if(verifyApp(intent)){
            context.startActivity(intent);
        }else {
            //do something
        }
    }

}
