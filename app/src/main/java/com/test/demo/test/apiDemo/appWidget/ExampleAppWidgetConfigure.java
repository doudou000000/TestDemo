package com.test.demo.test.apiDemo.appWidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/7.
 */

public class ExampleAppWidgetConfigure extends AppCompatActivity {

    private int mAppWidgetId;
    private int count = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.appwidget_provider_layout);
        views.setTextViewText(R.id.appwidget_text,"应用小部件测试" + count);
        appWidgetManager.updateAppWidget(mAppWidgetId, views);
    }
}
