package com.test.demo.test.apiDemo.remoteViews;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.test.demo.test.R;

public class TestNotificationRemoteViewsActivity extends AppCompatActivity implements View.OnClickListener{

    Button normalBtn, customBtn;

    NotificationManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notification_remote_view);
        initView();
        initListener();
    }

    private void initView() {
        normalBtn = (Button) findViewById(R.id.test_notification_remote_view_normal_btn);
        customBtn = (Button) findViewById(R.id.test_notification_remote_view_custom_btn);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    private void initListener() {
        normalBtn.setOnClickListener(this);
        customBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.test_notification_remote_view_normal_btn:
                openNormalNotification();
                break;
            case R.id.test_notification_remote_view_custom_btn:
                openCustomNotification();
                break;
        }
    }

    private void openNormalNotification() {
        NotificationCompat.Builder builder ;


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelID = "1";

            String channelName = "TestRemoteViews";

            NotificationChannel channel = new NotificationChannel(channelID,channelName, NotificationManager.IMPORTANCE_HIGH);

            manager.createNotificationChannel(channel);

            builder = new NotificationCompat.Builder(this,channelID);

        }else{

            builder = new NotificationCompat.Builder(this,null);

        }

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("TestRemoteViews")
                .setContentText("我是一个普通的View");

        manager.notify(1001,builder.build());
    }

    private void openCustomNotification() {

        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.activity_test_notification_custom);

        NotificationCompat.Builder builder ;


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelID = "1";

            String channelName = "TestRemoteViews";

            NotificationChannel channel = new NotificationChannel(channelID,channelName, NotificationManager.IMPORTANCE_HIGH);

            manager.createNotificationChannel(channel);

            builder = new NotificationCompat.Builder(this,channelID);

        }else{

            builder = new NotificationCompat.Builder(this,null);

        }

        Intent intent = new Intent(this,TestNotificationRemoteViewsActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivities(this,0,new Intent[]{intent},PendingIntent.FLAG_UPDATE_CURRENT);

        remoteViews.setOnClickPendingIntent(R.id.test_notification_custom_btn_1,pendingIntent);

        remoteViews.setOnClickPendingIntent(R.id.test_notification_custom_btn_2,pendingIntent);

        remoteViews.setTextViewText(R.id.test_notification_custom_tv,"我是一个自定义的RemoteViews");



        builder.setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("TestRemoteViews")
//                .setContentText("我是一个普通的View");
                .setContent(remoteViews);

        manager.notify(1002,builder.build());


    }
}
