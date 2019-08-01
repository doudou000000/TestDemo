package com.test.demo.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by DEV002 on 2018/5/29.
 */

public class NotificationResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        TextView textView = (TextView) findViewById(R.id.notification_tv);
        textView.setText(getIntent().getStringExtra("NotificationResultActivity"));
    }
}
