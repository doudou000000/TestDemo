package com.test.demo.test.apiDemo.service.foregroundService;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class TestForegroundService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private int age = 1;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent2 = new Intent(this,ForegroundServiceActivity.class);
        intent2.putExtra("age",getAge());
        PendingIntent pendingIntent = PendingIntent.getActivities(this,0,new Intent[]{intent2},0);

        final Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("标题")
                .setContentText("开启一个前台服务" + age)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentIntent(pendingIntent);

        final Notification notification = builder.build();
        startForeground(100, notification);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (age < 12) {
                    age ++;
                    builder.setContentText("开启一个前台服务" + age);
//                    Notification notification = builder.build();
                    notificationManager.notify(100,notification);
                    setAge(age);
                    System.out.println("age==Service===============" + age);
                    try{
                        Thread.sleep(3000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
