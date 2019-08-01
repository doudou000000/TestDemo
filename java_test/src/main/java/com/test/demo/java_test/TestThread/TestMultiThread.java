package com.test.demo.java_test.TestThread;

import java.util.ArrayList;
import java.util.List;

public class TestMultiThread {

    private boolean isStop = false;
    private static  List<String>  testLists ;

    public static void main(String args[]){

        List<String>  testLists = new ArrayList<>();

        addListItem();

    }

    class MyThread1 extends Thread{

        @Override
        public void run() {
            super.run();


            isStop = false;


        }


    }

    private static void addListItem() {

        for(int i = 0; i < 100; i++){

            testLists.add("我是第" + (i + 1) + "条数据");

        }
    }

}
