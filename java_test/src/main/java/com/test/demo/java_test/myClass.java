package com.test.demo.java_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class myClass {

    public static void main(String[] args){

        System.out.println("进入主线程" + Thread.currentThread().getName());
        DeamonThread deamonThread = new DeamonThread();
        Thread mThread = new Thread(deamonThread);
        mThread.setDaemon(true);
        mThread.start();

        Scanner sc = new Scanner(System.in);
        sc.next();

        System.out.println("退出主线程" + Thread.currentThread().getName());

    }

}
class DeamonThread implements Runnable {

    @Override
    public void run() {
        System.out.println("进入守护线程" + Thread.currentThread().getName());
        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("退出守护线程" + Thread.currentThread().getName());

    }

    private void writeToFile() throws Exception {
//        File filname = new File("c:" + File.separator + "deamon.txt");
//        OutputStream outputStream = new FileOutputStream(filname);
        int count = 0;
        while (count < 999) {
//            outputStream.write(("\r\tWord" + count).getBytes());
            System.out.println("守护线程" + Thread.currentThread().getName() + "向文件写入word" + count++);
            Thread.sleep(1000);
        }
    }
}