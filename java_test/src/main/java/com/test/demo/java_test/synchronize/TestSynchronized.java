package com.test.demo.java_test.synchronize;

public class TestSynchronized {

    public synchronized void test(String name){


        for(int i = 0; i < 100; i++){
            System.out.println("=======test=======" + i + name);
        }
    }


    public static synchronized void test1(String name){

        for(int i = 0; i < 100; i++){
            System.out.println("=======test1=======" + i + name);
        }

    }


    public static void test2(String name){

        for(int i = 0; i < 100; i++){
            System.out.println("=======test2=======" + i + name);
        }

    }

}
