package com.test.demo.test.apiDemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestBroadcastReceiverLocalActivity extends BaseActivity {

    TextView textView;

    MyBroadcastReceiverLocal myBroadcastReceiverLocal;

    @Override
    public int setLayout() {
        return R.layout.activity_test_broadcast_receiver_local;
    }

    @Override
    public void initView() {
        textView = (TextView) findViewById(R.id.test_broadcast_receiver_local_tv);

        myBroadcastReceiverLocal = new MyBroadcastReceiverLocal();
        IntentFilter intentFilter = new IntentFilter("com.test.demo.test.apiDemo.broadcast.TestBroadcastReceiverLocalActivity");
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcastReceiverLocal,intentFilter);
    }

    public void sendBroadcastReceiverLocal(View view){
        Intent intent = new Intent("com.test.demo.test.apiDemo.broadcast.TestBroadcastReceiverLocalActivity");
        intent.putExtra("local","我是一个本地广播");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    class MyBroadcastReceiverLocal extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {

            String local = intent.getStringExtra("local");
            textView.setText(local);
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcastReceiverLocal);
    }
}
