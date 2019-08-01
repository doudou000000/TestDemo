package com.test.demo.test.apiDemo.handler;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.lang.ref.WeakReference;

public class TestHandlerSendActivity extends BaseActivity{
    private TextView mTextView;

    private Handler mHandler = new MyHandler(this);

    @Override
    public int setLayout() {
        return R.layout.activity_test_handler_send;
    }

    @Override
    public void initView() {
        mTextView = (TextView) findViewById(R.id.test_handler_send_tv);
    }

    @Override
    public void initListener() {

    }

    public void sendHandlerSend(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(1);
            }
        }).start();

    }

    static class MyHandler extends Handler{

        WeakReference<Activity> weakReference;

        MyHandler(Activity activity){
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final Activity activity = weakReference.get();
            if (activity != null) {
                ((TestHandlerSendActivity)activity).mTextView.setText("我是handler—send更新的");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(null);
    }
}
