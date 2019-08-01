package com.test.demo.test.apiDemo.remoteViews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;

public class TestAppWidgetRemoteViewsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_app_widget_remote_view);

        TextView textView = (TextView) findViewById(R.id.test_app_widget_custom_tv);

        textView.setText("点击添加桌面小部件");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("");
                sendBroadcast(intent);
            }
        });

    }
}
