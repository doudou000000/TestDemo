package com.test.demo.test.apiDemo.handlerThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.test.demo.test.R;
import java.lang.ref.WeakReference;

public class TestAndroidHandleThreadActivity extends Activity {


    private HandlerThread handlerThread;

    private Handler mainHandler,threadHandler;

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handle_thread_android);
        textView = (TextView) findViewById(R.id.test_handler_thread_android_tv);
        handlerThread = new HandlerThread("handlerThread");
        handlerThread.start();

        mainHandler = new MainHandler(this);

        threadHandler = new ThreadHandler(this,handlerThread.getLooper());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = threadHandler.obtainMessage();
                msg.obj = "我是主线程，现在去子线程家做客";
                threadHandler.sendMessage(msg);
            }
        });
    }


    static class ThreadHandler extends Handler{

        WeakReference<Activity> activityWeakReference;

        public ThreadHandler(Activity activity, Looper looper) {
            super(looper);
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try{
                Thread.sleep(5000);
                TestAndroidHandleThreadActivity testAndroidHandleThreadActivity = (TestAndroidHandleThreadActivity)activityWeakReference.get();
                Message mainMsg = testAndroidHandleThreadActivity.mainHandler.obtainMessage();
                mainMsg.obj = (String)msg.obj + "，我在子线程家休息了5秒，我现在要回家了";
                testAndroidHandleThreadActivity.mainHandler.sendMessage(mainMsg);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    static class MainHandler extends Handler{

        WeakReference<Activity> activityWeakReference;

        public MainHandler(Activity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try{
                TestAndroidHandleThreadActivity testAndroidHandleThreadActivity = (TestAndroidHandleThreadActivity)activityWeakReference.get();
                testAndroidHandleThreadActivity.textView.setText((String)msg.obj);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
