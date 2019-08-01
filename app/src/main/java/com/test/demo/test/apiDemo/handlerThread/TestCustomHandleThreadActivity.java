package com.test.demo.test.apiDemo.handlerThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;

public class TestCustomHandleThreadActivity extends Activity{

    TextView textView;

    private MyThread thread = new MyThread();

    private Handler handler = new Handler(thread.looper){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            thread.i = (int) msg.obj;
            System.out.println("i================" + thread.i);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handle_thread_custom);
        textView = (TextView) findViewById(R.id.test_handle_thread_custom_tv);
    }

    public void sendMsgToWorkThread(View view) {
        thread.start();
        Message msg = new Message();
        msg.obj = 1;
        handler.sendMessage(msg);
    }

    class MyThread extends Thread{

        Looper looper = Looper.myLooper();
        int i = 0;
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            try {
                Thread.sleep(3000);

            }catch (Exception e){
                e.printStackTrace();
            }
            Looper.loop();
        }
    }

}
