package com.test.demo.test.apiDemo.service.createBind;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/5.
 */

public class BindServiceActivity extends AppCompatActivity {

    MyBindService myBindService;
    MyServiceConnection connection;
    private boolean isBingSucess;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        Intent intent = new Intent(BindServiceActivity.this,MyBindService.class);
        connection = new MyServiceConnection();
        BindServiceActivity.this.bindService(intent,connection, Context.BIND_AUTO_CREATE);
        final TextView textView = (TextView) findViewById(R.id.bind_service_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBingSucess){
                    textView.setText("" + myBindService.getRandomNext());
                }
            }
        });

    }


    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyBindService.MyBinder myBinder = (MyBindService.MyBinder)service;
            myBindService = myBinder.getMyBindService();
            isBingSucess = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBingSucess = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isBingSucess){
            unbindService(connection);
        }
    }
}
