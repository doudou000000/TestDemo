package com.test.demo.test.apiDemo.service.createBind;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by DEV002 on 2018/6/5.
 */

public class MyBindService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        IBinder binder = new MyBinder();
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public int getRandomNext(){

        Random random = new Random();
        return random.nextInt(100);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class MyBinder extends Binder{

        MyBindService getMyBindService(){

            return MyBindService.this;

        }

    }

}
