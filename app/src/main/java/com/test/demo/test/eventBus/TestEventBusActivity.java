package com.test.demo.test.eventBus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.test.demo.test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TestEventBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_eventbus_receivce);

//        TestEventBus.getDefault().register(this);
        TestEventBus.getDefault().postStick(new EventBusBean("你好aaaaa！！！","粘性EventBus"));


    }

    public void testEventBus(View view) {

        Intent intent = new Intent(this,TestEventBusSendActivity.class);
        startActivity(intent);

    }

    @TestSubscribe(threadMode = TestThreadMode.MAIN)
    public void getMessage(EventBusBean eventBusBean){

        Log.i("TestEventBus","=====getMessage======" + eventBusBean.toString());

    }
    @TestSubscribe(threadMode = TestThreadMode.MAIN)
    public void getMessage1(EventBusBean eventBusBean){

        Log.i("TestEventBus","=====getMessage111111111======" + eventBusBean.toString());

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getMessage2(EventBusBean eventBusBean){

        Log.i("TestEventBus","=====getMessage111111111======" + eventBusBean.toString());

    }

}
