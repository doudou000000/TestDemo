package com.test.demo.test;

import android.os.Environment;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public class OkioTest {

    public static final String ROOT = "D://";

    @Test
    public void testOkio(){

//        writeFile();
//        readFile();

        List<String> str = new ArrayList<>();
        str.add(null);
        str.add("123");
        str.add("456");
        int s = str.indexOf(null);
        int start = str.indexOf(null) + 1;
        for (int i = start, count = str.size(); i < count; i++) {
            System.out.println(str.get(i));
        }

    }

    private void readFile() {

        File file = new File(ROOT,"Okio.txt");
        if(!file.exists()){
            return;
        }
        try{
            Source read = Okio.source(file);
            BufferedSource bufferedSource = Okio.buffer(read);
            String result = null;
            while ((result = bufferedSource.readUtf8Line()) != null){
                System.out.println("=====result=====" + result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void writeFile() {


        File dir = new File(ROOT);

        File file = new File(dir,"Okio.txt");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try{
            Sink writeSink = Okio.sink(file);
            BufferedSink bufferedSink = Okio.buffer(writeSink);
            bufferedSink.writeUtf8("你好！\r\n");
            bufferedSink.writeUtf8("我是Okio\r\n");
            bufferedSink.writeUtf8("请多多指教\r\n");
            bufferedSink.close();
            writeSink.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
