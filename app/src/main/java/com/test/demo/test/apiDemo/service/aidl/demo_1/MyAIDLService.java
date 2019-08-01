package com.test.demo.test.apiDemo.service.aidl.demo_1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.test.demo.test.apiDemo.service.aidl.demo_1.IRomeService;

import java.util.Random;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class MyAIDLService extends Service{


    private IRomeService.Stub bind = new IRomeService.Stub() {
        @Override
        public int getId() throws RemoteException {
            return getRandomNext();
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.i("AIDL",aString);
        }
    };

    public int getRandomNext(){

        Random random = new Random();
        return random.nextInt(100);

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return bind;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
