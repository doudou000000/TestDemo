package com.test.demo.test;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;

import com.test.demo.test.plugin.PluginManager;
import com.test.pluginlibrary.PluginInterface;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyActivity extends Activity {

    /**
     * 要跳转的activity的name
     */
    private String className = "";
    private PluginInterface appInterface = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        File file = new File(Environment.getExternalStorageDirectory().getPath(), "testdex-debug.apk");
//
//        PluginManager.getInstance().loadPath(file.getAbsoluteFile().getPath());

        /**
         * step1：得到插件app的activity的className
         */
        className = PluginManager.getInstance().getEntryName();//getIntent().getStringExtra("className");
        /**
         * step2：通过反射拿到class，
         * 但不能用以下方式
         * classLoader.loadClass(className)
         * Class.forName(className)
         * 因为插件app没有被安装！
         * 这里我们调用我们重写过多classLoader
         */
        try {
            Class activityClass = getClassLoader().loadClass(className);
            Constructor constructor = activityClass.getConstructor();
            Object instance = constructor.newInstance();

            appInterface = (PluginInterface) instance;
            appInterface.attach(this);
            Bundle bundle = new Bundle();
            appInterface.onCreate(bundle);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        appInterface.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
        appInterface.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appInterface.onDestroy();
    }

    @Override
    public ClassLoader getClassLoader() {
        //不用系统的ClassLoader，用dexClassLoader加载
        return PluginManager.getInstance().getDexClassLoader();
    }

    @Override
    public Resources getResources() {
        //不用系统的resources，自己实现一个resources
        return PluginManager.getInstance().getResources();
    }


}
