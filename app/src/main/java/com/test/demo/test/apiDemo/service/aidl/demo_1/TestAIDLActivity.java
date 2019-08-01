package com.test.demo.test.apiDemo.service.aidl.demo_1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.service.aidl.demo_1.IRomeService;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class TestAIDLActivity extends AppCompatActivity {

    IRomeService myBindService;
    MyServiceConnection connection;
    private boolean isBingSucess;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

        connection = new MyServiceConnection();

        final TextView textView = (TextView) findViewById(R.id.bind_service_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBingSucess){
                    try {
                        myBindService.basicTypes(1,1L,true,1.0f,1.0,"你好");
                        textView.setText("" + myBindService.getId());
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
        Intent intent = new Intent(TestAIDLActivity.this,MyAIDLService.class);
        TestAIDLActivity.this.bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            myBindService = IRomeService.Stub.asInterface(service);
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
