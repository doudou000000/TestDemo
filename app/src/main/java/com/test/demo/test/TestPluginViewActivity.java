package com.test.demo.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.test.demo.test.plugin.PluginManager;
import com.test.pluginlibrary.PluginInterface;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class TestPluginViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin);
        TextView textView  = (TextView) findViewById(R.id.click_plugin_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });
//        findViewById(R.id.load).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                load();
//            }
//        });
        PluginManager.getInstance().setContext(this);
    }

    //事件绑定load
    private void load() {
        /**
         * 事先放置到SD卡根目录的plugin.apk
         * 现实场景中是有服务端下发
         */
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "testdex-debug.apk");

        PluginManager.getInstance().loadPath(file.getAbsoluteFile().getPath());
    }

    //事件绑定click
    private void click() {
        load();
        /**
         * 点击跳往插件app的activity，一律跳转到PRoxyActivity
         */
        Intent intent = new Intent(this, ProxyActivity.class);
//        intent.putExtra("className", PluginManager.getInstance().getEntryName());
        startActivity(intent);

    }

//    Object instance;
//
//    Class<?> aClass;
//
//    PluginInterface pluginInterface;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        String className = PluginManager.getInstance().getEntryName(this,Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "testdex-debug.apk") ;
//
//        try {
////            aClass = PluginManager.getInstance().getDexClassLoader().loadClass(className);
////
////            instance = aClass.newInstance();
////
////            Method setContext = aClass.getMethod("setContext",Activity.class);
////
////            setContext.invoke(instance,this);
////
////            Method setOnCreate = aClass.getMethod("onCreate",Bundle.class);
////            Bundle bundle = new Bundle();
////            setOnCreate.invoke(instance,bundle);
//
//            aClass = PluginManager.getInstance().getDexClassLoader().loadClass(className);//创建插件Activity的实例
////            //调用插件Activity的构造函数，将当前activity的上下文传递到插件activity中去
////            Constructor<?> localConstructor = aClass.getConstructor();
//            instance = aClass.newInstance();
//            Log.e("MainActivity", "instance = " + instance);
//
//            pluginInterface = (PluginInterface) instance;
////            Method setContext = aClass.getMethod("setContext",Activity.class);
////
////            setContext.invoke(instance,this);
////
////
////            Method onCreate = aClass.getDeclaredMethod("onCreate", Bundle.class);
////            onCreate.setAccessible(true);
////            Bundle bundle = new Bundle();
////            onCreate.invoke(instance, bundle);//调用插件activity的onCreate方法
//            pluginInterface.setContext(this);
//            Bundle bundle = new Bundle();
//            pluginInterface.onCreate(bundle);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
////        try {
////            Method onCreate = aClass.getMethod("onStart");
////            onCreate.setAccessible(true);
////            onCreate.invoke(instance);//调用插件activity的onCreate方法
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        pluginInterface.onStart();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
////        try {
////            Method onCreate = aClass.getDeclaredMethod("onResume");
////            onCreate.setAccessible(true);
////            onCreate.invoke(instance);//调用插件activity的onCreate方法
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        pluginInterface.onResume();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
////        try {
////            Method onCreate = aClass.getDeclaredMethod("onDestroy");
////            onCreate.setAccessible(true);
////            onCreate.invoke(instance);//调用插件activity的onCreate方法
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        pluginInterface.onDestroy();
//    }
//
//
//    @Override
//    public Resources getResources() {
//        System.out.println("========getResources==================");
//        return PluginManager.getInstance().getResources();
//    }
//
//    @Override
//    public ClassLoader getClassLoader() {
//        System.out.println("========getClassLoader==================");
//        return PluginManager.getInstance().getDexClassLoader();
//    }

}
