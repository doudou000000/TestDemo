package com.test.demo.test.apiDemo.remoteViews;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class TestAppWidgetRemoteViews extends AppWidgetProvider{

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Intent intent = new Intent(context,TestAppWidgetRemoteViewsService.class);
        context.startService(intent);
    }



}
