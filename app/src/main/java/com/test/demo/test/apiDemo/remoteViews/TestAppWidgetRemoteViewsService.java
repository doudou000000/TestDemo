package com.test.demo.test.apiDemo.remoteViews;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import com.test.demo.test.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestAppWidgetRemoteViewsService extends Service {

    Timer timer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        };

        timer.schedule(timerTask,0,1000);


    }

    private void updateTime() {

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.activity_test_app_widget_remote_view);

        remoteViews.setTextViewText(R.id.test_app_widget_custom_tv,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        AppWidgetManager manager = AppWidgetManager.getInstance(getApplicationContext());

        ComponentName componentName = new ComponentName(this,TestAppWidgetRemoteViews.class);

        manager.updateAppWidget(componentName,remoteViews);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
