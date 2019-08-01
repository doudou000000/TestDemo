package com.test.demo.test.apiDemo.service.foregroundService;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.service.createBind.BindServiceActivity;
import com.test.demo.test.apiDemo.service.createBind.MyBindService;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class ForegroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        TextView textView = (TextView) findViewById(R.id.bind_service_tv);
        textView.setText("开启一个前台服务");
        int age = getIntent().getIntExtra("age",0);
        System.out.println("age=================" + age);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,TestForegroundService.class);
        startService(intent);
    }
}
