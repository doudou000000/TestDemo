package com.test.demo.test.apiDemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.broadcast.test.TestBroadcastNormalService;
import com.test.demo.test.apiDemo.broadcast.test.TestBroadcastOrderService;

public class TestBroadcastReceiverOrderActivity extends BaseActivity{

    public static final String TAG = "TEST_BROADCAST_RECEIVER";

    static TextView textView;
    static TextView textView1;
    static TextView textView2;

    @Override
    public int setLayout() {
        return R.layout.activity_test_broadcast_receiver_order;
    }

    @Override
    public void initView() {

        textView = (TextView) findViewById(R.id.test_broadcast_receiver_oeder_tv);
        textView1 = (TextView) findViewById(R.id.test_broadcast_receiver_oeder_tv_1);
        textView2 = (TextView) findViewById(R.id.test_broadcast_receiver_oeder_tv_2);

    }

    public void sendBroadcastReceiverOrder(View view){
        Intent intent = new Intent(this, TestBroadcastOrderService.class);
        startService(intent);
    }

    @Override
    public void initListener() {

    }

    public static class MyBroadcastReceiverOrder extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {

            String order = intent.getStringExtra("order");
            textView.setText(order);

            Bundle bundle = new Bundle();
            bundle.putString("order","我是一个有序的广播，我被修改了");
            setResultExtras(bundle);
//            abortBroadcast();  //终止消息再传递

        }
    }

    public static class MyBroadcastReceiverOrder1 extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {

            String order1 = intent.getStringExtra("order");
            Log.i(TAG,"order1===========" + order1);

            order1 = getResultExtras(true).getString("order");

            textView1.setText(order1);


            Bundle bundle = new Bundle();
            bundle.putString("order","我是一个有序的广播，我再次被修改了");
            setResultExtras(bundle);

        }
    }

    public static class MyBroadcastReceiverOrder2 extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {

            String order2 = intent.getStringExtra("order");
            Log.i(TAG,"order2===========" + order2);

            order2 = getResultExtras(true).getString("order");

            textView2.setText(order2);
        }
    }

}
