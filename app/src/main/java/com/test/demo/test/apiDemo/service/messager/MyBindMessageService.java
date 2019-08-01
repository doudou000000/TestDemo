package com.test.demo.test.apiDemo.service.messager;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by DEV002 on 2018/6/5.
 */

public class MyBindMessageService extends Service {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Messenger client = msg.replyTo;
                    Message clientMsg = Message.obtain();
                    clientMsg.what = 1;
                    clientMsg.obj = getRandomNext();
                    try {
                        client.send(clientMsg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;

            }
        }
    };

    Messenger messenger = new Messenger(handler);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String str = intent.getStringExtra("name");
        return messenger.getBinder();
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

}
