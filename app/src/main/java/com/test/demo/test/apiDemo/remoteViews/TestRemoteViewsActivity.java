package com.test.demo.test.apiDemo.remoteViews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.utils.IntentUtils;

public class TestRemoteViewsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_remote_views);
    }

    public void testNotificationRemoteViews(View view) {
        IntentUtils.startActivity(this,TestNotificationRemoteViewsActivity.class);
    }

    public void testAppWidgetRemoteViews(View view) {
        IntentUtils.startActivity(this,TestAppWidgetRemoteViewsActivity.class);
    }
}
