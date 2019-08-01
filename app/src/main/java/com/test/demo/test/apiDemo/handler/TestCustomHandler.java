package com.test.demo.test.apiDemo.handler;


import java.util.concurrent.LinkedBlockingQueue;

public class TestCustomHandler {

    LinkedBlockingQueue<TestCustomMessage> mQueue;

    public void handleMessage(TestCustomMessage msg) {
    }

    public TestCustomHandler(){

        TestCustomLooper testCustomLooper = TestCustomLooper.myLooper();
        if (testCustomLooper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        mQueue = testCustomLooper.mQueue;

    }


    public void sendMessage(TestCustomMessage msg){
        msg.setTarget(this);
        mQueue.offer(msg);

    }


    public void dispatchMessage(TestCustomMessage msg) {

        handleMessage(msg);

    }
}
