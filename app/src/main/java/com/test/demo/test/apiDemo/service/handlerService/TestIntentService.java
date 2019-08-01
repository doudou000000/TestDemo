package com.test.demo.test.apiDemo.service.handlerService;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.FrameLayout;

import com.test.demo.test.utils.ImageUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DEV002 on 2018/6/6.
 */



public class TestIntentService extends IntentService{

    public static final String TAG = "INTENT_SERVICE";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public TestIntentService() {
        super("TestIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"====onHandleIntent====");
        String imageUrl = intent.getStringExtra("url");
        int imageId = intent.getIntExtra("id",1);
        URL url = null;
        HttpURLConnection connection = null;
        InputStream is = null;
        ByteArrayOutputStream outStream = null;
        try {
            url = new URL(imageUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            if(connection.getResponseCode() == 200){
                is = connection.getInputStream();
//                Bitmap bitmap = BitmapFactory.decodeStream(is);
//                is.
//                sendImageBroadcast(bitmap,imageId);
                byte[] buffer = new byte[1024];
                int len;
                outStream = new ByteArrayOutputStream();
                while ((len = is.read(buffer)) != -1){
                    outStream.write(buffer,0,len);
                }
                final byte[] data = outStream.toByteArray();
                sendImageBroadcast(ImageUtils.decodeSampledBitmapFromBytes(data,100,100),imageId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"====onCreate====");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG,"====onStartCommand====");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"====onDestroy====");
        super.onDestroy();
    }

    public void sendImageBroadcast(Bitmap bitmap, int imageId){

        Intent intent = new Intent("com.test.demo.test.apiDemo.service.handlerService");
        Bundle bundle = new Bundle();
        bundle.putParcelable("bitmap", bitmap);//注意：putParcelable有大小限制 java.lang.RuntimeException: android.os.TransactionTooLargeException: data parcel size 2785776 bytes
        bundle.putInt("id",imageId);
        intent.putExtra("bundle",bundle);
        sendBroadcast(intent);
    }

}
