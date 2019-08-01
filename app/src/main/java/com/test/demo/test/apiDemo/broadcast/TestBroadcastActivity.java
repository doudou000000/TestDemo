package com.test.demo.test.apiDemo.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.demo.test.R;

public class TestBroadcastActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_broadcast_receiver);
    }

    public void testBroadcastReceiverNorm(View view) {
        Intent intent = new Intent(this,TestBroadcastReceiverNormActivity.class);
        startActivity(intent);
    }

    public void testBroadcastReceiverOrder(View view) {
        Intent intent = new Intent(this,TestBroadcastReceiverOrderActivity.class);
        startActivity(intent);
    }
    public void testBroadcastReceiverLocal(View view) {
        Intent intent = new Intent(this,TestBroadcastReceiverLocalActivity.class);
        startActivity(intent);
    }

}
