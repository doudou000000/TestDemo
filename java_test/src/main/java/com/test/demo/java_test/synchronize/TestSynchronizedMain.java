package com.test.demo.java_test.synchronize;

public class TestSynchronizedMain {

    public static void main(String[] args){

        final TestSynchronized testSynchronized = new TestSynchronized();
        final TestSynchronized testSynchronized1 = new TestSynchronized();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testSynchronized.test(Thread.currentThread().getName());
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestSynchronized.test1(Thread.currentThread().getName());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                TestSynchronized.test2(Thread.currentThread().getName());
            }
        }).start();

    }

}
