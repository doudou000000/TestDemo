package com.test.demo.test.apiDemo.service.aidl.demo_2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class TestBookActivity extends AppCompatActivity {


    private boolean isBingSuccess;

    private MyServiceConnection connection;

    private IBookManager iBookManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

        connection = new MyServiceConnection();
        Log.i("AIDL-onCreate",Thread.currentThread().getName());
        final TextView textView = (TextView) findViewById(R.id.bind_service_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBingSuccess){
                    Log.i("AIDL-setOnClickListener",Thread.currentThread().getName());
                    Book book = new Book("红楼梦","曹雪芹");
                    try {
                        iBookManager.addBook(book);
                        textView.setText(iBookManager.getBookList().get(0).getBookName());
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
        Intent intent = new Intent(this,TestBookService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            iBookManager = IBookManager.Stub.asInterface(service);
            isBingSuccess = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBingSuccess = false;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBingSuccess){
            unbindService(connection);
            isBingSuccess = false;
        }
    }
}
