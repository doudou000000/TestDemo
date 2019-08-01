package com.test.demo.test.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;


/**
 * Created by DEV002 on 2018/5/21.
 */

public class OpenGLUtils {

    /**
     * 检查设备是否支持OpenGL 2.0
     * @return
     */
    public static boolean checkSupported(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        return configurationInfo.reqGlEsVersion >= 0x2000;
    }

}
