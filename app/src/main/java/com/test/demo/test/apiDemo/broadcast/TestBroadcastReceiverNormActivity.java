package com.test.demo.test.apiDemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.broadcast.test.TestBroadcastNormalService;

public class TestBroadcastReceiverNormActivity extends BaseActivity{

    TextView textView;

    MyBroadcastReceiverNormal myBroadcastReceiverNormal;

    @Override
    public int setLayout() {
        return R.layout.activity_test_broadcast_receiver_normal;
    }

    @Override
    public void initView() {

        textView = (TextView) findViewById(R.id.test_broadcast_receiver_normal_tv);

        myBroadcastReceiverNormal = new MyBroadcastReceiverNormal();
        IntentFilter intentFilter = new IntentFilter("com.test.demo.test.apiDemo.broadcast.test.TestBroadcastNormalService");
        registerReceiver(myBroadcastReceiverNormal,intentFilter);

    }

    public void sendBroadcastReceiverNormal(View view){
        Intent intent = new Intent(this, TestBroadcastNormalService.class);
        startService(intent);
    }

    @Override
    public void initListener() {

    }

    class MyBroadcastReceiverNormal extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {

            String normal = intent.getStringExtra("normal");
            textView.setText(normal);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiverNormal);
    }
}
