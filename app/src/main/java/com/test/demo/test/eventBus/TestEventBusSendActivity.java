package com.test.demo.test.eventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.test.demo.test.R;

import org.greenrobot.eventbus.EventBus;

public class TestEventBusSendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_eventbus_send);
        TestEventBus.getDefault().register(this);
    }

    public void testEventBusSend(View view) {
        TestEventBus.getDefault().post(new EventBusBean("你好aaaaa！！！","EventBus"));
    }

    @TestSubscribe(threadMode = TestThreadMode.MAIN,stick = true)
    public void getMessage(EventBusBean eventBusBean){

        Log.i("TestEventBus","=====getMessage======" + eventBusBean.toString());

    }

}
