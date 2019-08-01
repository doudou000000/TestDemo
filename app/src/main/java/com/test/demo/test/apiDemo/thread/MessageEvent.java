package com.test.demo.test.apiDemo.thread;

import android.graphics.Bitmap;

/**
 * Created by DEV002 on 2018/6/7.
 */

public class MessageEvent {

    private Bitmap bitmap;

    public MessageEvent(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
