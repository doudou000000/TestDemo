package com.test.demo.test;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/**
 * Created by DEV002 on 2018/5/29.
 */

public class MyViewOutlineProvider extends ViewOutlineProvider {
    @Override
    public void getOutline(View view, Outline outline) {
        int margin = Math.max(view.getWidth(), view.getHeight());
        int width = view.getWidth();
        int height = view.getHeight();
        int top = view.getTop();
        int bottom = view.getBottom();
        int left = view.getLeft();
        int right = view.getRight();

        outline.setRoundRect(0, 0, width,height, 10);
    }
}
