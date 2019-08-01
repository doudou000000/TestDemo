package com.test.demo.test;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by DEV002 on 2018/5/22.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
//    private static final float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        Log.i("position","====================="+position);

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
//            float scaleFactor = Math.abs(position);
            float vertMargin = pageHeight * scaleFactor;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position <= 0) {
                view.setTranslationX(horzMargin);
            } else {
                view.setTranslationX(-horzMargin);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
//            view.setAlpha(MIN_ALPHA +
//                    (scaleFactor - MIN_SCALE) /
//                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));
            view.setAlpha(scaleFactor);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
