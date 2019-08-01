package com.test.demo.test.apiDemo.service.messager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/5.
 */

public class BindServiceMessageActivity extends AppCompatActivity {

    MyServiceConnection connection;
    private boolean isBingSucess;

    Messenger mService = null;
    Messenger mClient = null;
    TextView textView;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    textView.setText((int)msg.obj + "");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        connection = new MyServiceConnection();
        mClient = new Messenger(mHandler);

        textView = (TextView) findViewById(R.id.bind_service_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBingSucess){
                    Message msg = Message.obtain();
                    msg.what = 0;
                    msg.replyTo = mClient;
                    try {
                        mService.send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(BindServiceMessageActivity.this,MyBindMessageService.class);
        intent.putExtra("name","123");
        BindServiceMessageActivity.this.bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBingSucess){
            unbindService(connection);
        }
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            mService = new Messenger(service);
            isBingSucess = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
            isBingSucess = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
