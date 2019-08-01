package com.test.glidelib;

import android.content.Context;
import android.widget.ImageView;

import java.lang.ref.SoftReference;

public class BitmapRequest {

    //图片的URL
    private String url;

    //图片加载控件
    private SoftReference<ImageView> imageView;

    //占位图片
    private int resID;

    //回调对象
    RequestListener requestListener;

    //图片标识
    private String urlMd5;

    private Context context;

    public BitmapRequest(Context context) {
        this.context = context;
    }

    public BitmapRequest load(String url){
        this.url = url;
        this.urlMd5 = MD5Util.MD5Encryption(url);
        return this;
    }

    public BitmapRequest loading(int resID){
        this.resID = resID;
        return this;
    }

    public BitmapRequest listener(RequestListener listener){
        this.requestListener = listener;
        return this;
    }

    public void into(ImageView imageView){
        imageView.setTag(this.urlMd5);
        this.imageView = new SoftReference<>(imageView);
        RequestManager.getInstance().addRequestQueue(this);
    }



    public String getUrl() {
        return url;
    }

    public ImageView getImageView() {
        return imageView.get();
    }

    public int getResID() {
        return resID;
    }

    public RequestListener getRequestListener() {
        return requestListener;
    }

    public String getUrlMd5() {
        return urlMd5;
    }
}
