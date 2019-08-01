package com.test.glidelib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;

public class BitmapDispatcher extends Thread {

    private LinkedBlockingQueue<BitmapRequest> requestQueue;

    private Handler handler = new Handler(Looper.getMainLooper());

    public BitmapDispatcher(LinkedBlockingQueue<BitmapRequest> requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        super.run();

        while (!interrupted()){

            try {
                BitmapRequest bitmapRequest = requestQueue.take();
                showResID(bitmapRequest);
                Bitmap bitmap = findBitmap(bitmapRequest);
                showImageView(bitmap,bitmapRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private void showImageView(final Bitmap bitmap, final BitmapRequest bitmapRequest) {
        if(bitmap != null && bitmapRequest.getImageView() != null && bitmapRequest.getUrlMd5().equals(bitmapRequest.getImageView().getTag())){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    bitmapRequest.getImageView().setImageBitmap(bitmap);
                    if(bitmapRequest.getRequestListener() != null){
                        bitmapRequest.getRequestListener().onSuccess(bitmap);
                    }
                }
            });
        }
    }

    private Bitmap findBitmap(BitmapRequest bitmapRequest) {
        Bitmap bitmap = downLoadBitmap(bitmapRequest.getUrl());
        return bitmap;
    }

    private Bitmap downLoadBitmap(String uri) {
        Bitmap bitmap = null;
        URL url = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            url = new URL(uri);
            conn = (HttpURLConnection)url.openConnection();
            is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
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
            if(conn != null){
                conn.disconnect();
            }
        }

        return bitmap;
    }

    private void showResID(final BitmapRequest bitmapRequest) {

        if(bitmapRequest.getResID() > 0 && bitmapRequest.getImageView() != null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    bitmapRequest.getImageView().setImageResource(bitmapRequest.getResID());
                }
            });
        }
    }
}
