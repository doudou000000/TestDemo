package com.test.demo.test.apiDemo.broadcast.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

public class TestBroadcastOrderService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent intent1 = new Intent("com.test.demo.test.apiDemo.broadcast.test.TestBroadcastOrderService");
        intent1.putExtra("order","我是一个有序的广播，谁先截取到我，谁就可以修改我");
        sendOrderedBroadcast(intent1,null);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }
}
