package com.test.demo.test.apiDemo.viewpager.pageTransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by DEV002 on 2018/5/22.
 */

public class MyAlphaPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_ALPHA = 0.6f;

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

//        if (position < -1 || position > 1) { // [-Infinity,-1)
//            // This page is way off-screen to the left.
//            view.setAlpha(MIN_ALPHA);
//            view.setScaleX(MIN_SCALE);
//            view.setScaleY(MIN_SCALE);
//
//        } else {
////            if (position < 0) { // [-1,0]
////                // Use the default slide transition when moving to the left page
////                float alphaFactor = MIN_ALPHA
////                        + (1 - MIN_ALPHA) * (1 - Math.abs(position));
////                view.setAlpha(alphaFactor);
////
////            } else if (position <= 1) {
////                float alphaFactor = 1 - MIN_ALPHA * (Math.abs(position));
////                view.setAlpha(alphaFactor);
////            }
//            float alphaFactor = MIN_ALPHA
//                    + (1 - MIN_ALPHA) * (1 - Math.abs(position));
//            view.setAlpha(alphaFactor);
//            float scaleFactor = MIN_SCALE
//                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
//
//            view.setScaleX(scaleFactor);
//            view.setScaleY(scaleFactor);
////            float scale=Math.max(MIN_SCALE,1-Math.abs(position));
////            view.setScaleX(scale);
////            view.setScaleY(scale);
//        }
//        if (position <= 0) {
//            view.setRotation(45 * position);
//            view.setTranslationX((view.getWidth() / 2 * position));
//        } else {
//            //移动X轴坐标，使得卡片在同一坐标
//            view.setTranslationX(-position * view.getWidth());
//            //缩放卡片并调整位置
//            float scale = (view.getWidth() - 60 * position) / view.getWidth();
//            view.setScaleX(scale);
//            view.setScaleY(scale);
//            //移动Y轴坐标
//            view.setTranslationY(position * 60);
//        }


//        if(position < -1){
//            view.setAlpha(0);
//        }else if(position <= 0){
//            view.setAlpha(1);
//            view.setTranslationX(0);
//            view.setTranslationY(pageWidth * position);
////            view.setRotationY(90 * position);
//
//        }else if(position <= 1){
//            view.setAlpha(1 - position);
//            view.setTranslationX(pageWidth * -position);
//        }else{
//            view.setAlpha(0);
//        }
        view.setPivotX(pageWidth);
        if(position < -1){
            view.setAlpha(0);
        }else if(position <= 0){
            view.setAlpha(1-Math.abs(position));
            view.setTranslationX(pageWidth * -position);
            view.setRotationY(90 * position);
            view.setScaleX(1-Math.abs(position));
        }else if(position <= 1){
            view.setAlpha(1 - position);
            view.setTranslationX(pageWidth * -position);
        }else{
            view.setAlpha(0);
        }
     }

}
