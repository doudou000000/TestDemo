package com.test.demo.test.apiDemo.handler;

import android.os.Looper;
import android.os.MessageQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class TestCustomLooper {

    static ThreadLocal<TestCustomLooper> mThreadLocal = new ThreadLocal<>();

    final LinkedBlockingQueue<TestCustomMessage> mQueue;


    public static void prepare(){

        mThreadLocal.set(new TestCustomLooper(true));

    }

    public static TestCustomLooper myLooper() {
        return mThreadLocal.get();
    }

    private TestCustomLooper(boolean quitAllowed){

        mQueue = new LinkedBlockingQueue();

    }

    public static void loop() throws InterruptedException {

        TestCustomLooper testCustomLooper = myLooper();

        LinkedBlockingQueue<TestCustomMessage> mQueue = testCustomLooper.mQueue;

        while (true){

            if(mQueue.take() == null){

                return;

            }

            TestCustomMessage msg = mQueue.take();

            msg.getTarget().dispatchMessage(msg);

            mQueue.remove(msg);

        }

    }

}
