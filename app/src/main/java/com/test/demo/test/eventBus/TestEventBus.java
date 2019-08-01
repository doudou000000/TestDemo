package com.test.demo.test.eventBus;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestEventBus {

    private static volatile TestEventBus testEventBus;

    private Map<Object,List<SubscribeMethod>> cacheMap;

    private Map<Class<?>,Object> stickMap;

    private Handler mHandler;

    private TestEventBus(){
        cacheMap = new HashMap<>();
        mHandler = new Handler();
        stickMap = new HashMap<>();
    }

    public static TestEventBus getDefault() {
        if(testEventBus == null){
            synchronized (TestEventBus.class){

                if(testEventBus == null){
                    testEventBus = new TestEventBus();
                }
            }
        }
        return testEventBus;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void register(Object obj) {
        List<SubscribeMethod> subscribeMethodList = cacheMap.get(obj);

        if(subscribeMethodList == null) {

            subscribeMethodList = findSubscribeMethod(obj);

            cacheMap.put(obj,subscribeMethodList);
        }

        for(SubscribeMethod subscribeMethod : subscribeMethodList){

            if(subscribeMethod.isStick()){

                post(stickMap.get(subscribeMethod.getType()));

            }

        }

    }

    private List<SubscribeMethod> findSubscribeMethod(Object obj) {

        List<SubscribeMethod> subscribeMethodList = new ArrayList<>();
        Class<?> clzz = obj.getClass();

        Method[] methods = clzz.getDeclaredMethods();

        for(Method method : methods){
            TestSubscribe testSubscribe = method.getAnnotation(TestSubscribe.class);
            if(testSubscribe == null){
                continue;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if(parameterTypes.length != 1){
                try {
                    throw new Exception("@Subscribe method must have exactly 1 parameter but has " + parameterTypes.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                TestThreadMode testThreadMode = testSubscribe.threadMode();
                SubscribeMethod subscribeMethod = new SubscribeMethod(method,testThreadMode,parameterTypes[0],testSubscribe.stick());
                subscribeMethodList.add(subscribeMethod);
            }

        }

        return subscribeMethodList;
    }
    public void postStick( Object eventType) {

        stickMap.put(eventType.getClass(),eventType);

    }


    public void post(final Object eventType) {

        Set<Object> keySet = cacheMap.keySet();

       // keySet.iterator();

        for(final Object obj : keySet){

            List<SubscribeMethod> subscribeMethodList = cacheMap.get(obj);

            for(final SubscribeMethod subscribeMethod : subscribeMethodList){

                if(subscribeMethod.getType().isAssignableFrom(eventType.getClass())){
                    switch (subscribeMethod.getThreadMode()){

                        case MAIN:
                            //主--主
                            if(Looper.myLooper() == Looper.getMainLooper()){
                                invoke(subscribeMethod,obj,eventType);
                            }else{
                                //子--主
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        invoke(subscribeMethod,obj,eventType);
                                    }
                                });
                            }
                            break;

                        case BACKGROUND:
                            //主---子 ExecutorService
                            //子---子
                            break;

                    }
                }
            }
        }
    }

    private void invoke(SubscribeMethod subscribeMethod, Object obj, Object eventType) {

        Method method = subscribeMethod.getMethod();
        try {
            method.invoke(obj,eventType);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
