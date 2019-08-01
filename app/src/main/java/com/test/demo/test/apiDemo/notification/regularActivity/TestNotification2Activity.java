package com.test.demo.test.apiDemo.notification.regularActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.notification.specialActivity.SpecialActivity;

/**
 * Created by DEV002 on 2018/6/12.
 */

public class TestNotification2Activity extends AppCompatActivity {

    NotificationManager mNotificationManager;
    MyBroadcastReceiver myBroadcastReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_2);
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        IntentFilter filter = new IntentFilter("action");
        myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver,filter);
    }

    public void sendNotificationRegularActivity(View view) {

        Intent intent = new Intent(this,RegularActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(RegularActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,null);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("通知")
                .setContentText("我是一个可以点击的通知")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        Notification notification = builder.build();
        mNotificationManager.notify(0,builder.build());
    }

    public void sendNotificationSpecialActivity(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,null);
        Intent notifyIntent =
                new Intent(this, SpecialActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("通知")
                .setContentText("我是一个可以点击的通知")
                .setAutoCancel(true)
//                .setFullScreenIntent(notifyPendingIntent,true); 弹出一个浮动窗口通知
                .setContentIntent(notifyPendingIntent);
        mNotificationManager.notify(1, builder.build());

    }

    public void sendNotificationFixedProgress(View view) {

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this,null);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("图片下载")
                .setContentText("进度条");
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i < 100; i+=5){
                    /**两种情况：
                     * 1、如果确定下载文件的总长度使用 builder.setProgress(100,i,false);
                     * 2、如果不确定下载文件的长度使用builder.setProgress(0,i,true);
                     */
                    builder.setProgress(100,i,false);
                    mNotificationManager.notify(3,builder.build());
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                builder.setContentText("下载完成")
                        .setProgress(0,0,false);
                mNotificationManager.notify(3,builder.build());
            }
        }).start();

    }

    public void sendNotificationLockScreen(View view) {

        Notification notification = new Notification.Builder(this)
                // Show controls on lock screen even when user hides sensitive content.
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Wonderful music")
                .setContentText("My Awesome Band")
                .setAutoCancel(true)
                .build();
        mNotificationManager.notify(5,notification);
    }

    public void sendNotificationExpanded(View view) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,null)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Event tracker")
                .setContentText("Events received");
        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        String[] events = new String[6];
        inboxStyle.setBigContentTitle("Event tracker details:");

        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine("我是一个可以展开的通知");
        }
        mBuilder.setStyle(inboxStyle);

        mNotificationManager.notify(4,mBuilder.build());

    }

    public void sendNotificationCustomLayout(View view) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,null)
                .setSmallIcon(R.mipmap.ic_launcher);
        RemoteViews remoteViews = new RemoteViews(null,R.layout.activity_custom_notification);
        RemoteViews remoteViews_larger = new RemoteViews(null,R.layout.activity_custom_notification_larger);
        remoteViews.setTextViewText(R.id.custom_notification_lrc_tv,"正在播放");
        remoteViews_larger.setTextViewText(R.id.custom_notification_lrc_tv,"正在播放");


        PendingIntent preIntent = PendingIntent.getBroadcast(this,0,new Intent("action").putExtra("btn","pre"),PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent nextIntent = PendingIntent.getBroadcast(this,1,new Intent("action").putExtra("btn","next"),PendingIntent.FLAG_UPDATE_CURRENT);


        remoteViews.setOnClickPendingIntent(R.id.custom_notification_next_btn,nextIntent);
        remoteViews.setOnClickPendingIntent(R.id.custom_notification_pre_btn,preIntent);


        remoteViews_larger.setOnClickPendingIntent(R.id.custom_notification_next_btn,nextIntent);
        remoteViews_larger.setOnClickPendingIntent(R.id.custom_notification_pre_btn,preIntent);


        if(android.os.Build.VERSION.SDK_INT >= 16){
            mBuilder.setCustomBigContentView(remoteViews_larger);
        }

        mBuilder.setCustomContentView(remoteViews);

        mNotificationManager.notify(6,mBuilder.build());
    }

    class MyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String btnName = intent.getStringExtra("btn");
            if(btnName.equals("pre")){
                Toast.makeText(TestNotification2Activity.this,"上一首",Toast.LENGTH_SHORT).show();
            }else if(btnName.equals("next")){
                Toast.makeText(TestNotification2Activity.this,"下一首",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }
}
