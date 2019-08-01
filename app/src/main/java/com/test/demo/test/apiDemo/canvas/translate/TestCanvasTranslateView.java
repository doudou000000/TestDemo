package com.test.demo.test.apiDemo.canvas.translate;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class TestCanvasTranslateView extends View {

    private Paint mPaint;

    private int degrees = 60;
    private int i = 0;
    private boolean isFirst;

    public TestCanvasTranslateView(Context context) {
        this(context,null);
    }

    public TestCanvasTranslateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestCanvasTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        isFirst= true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);


//        canvas.save();
//        canvas.rotate(90 + i,getWidth()/2,getHeight()/2);
//        canvas.drawLine(getWidth()/2,getHeight()/2,getWidth()/2 - 170,getHeight()/2,mPaint);
//        if(isFirst && degrees == 0){
////            Log.i("degrees","degrees===="+ degrees + "=====i===" + i + "====isFirst====" + isFirst);
//            isFirst = false;
////            Log.i("degrees","degrees1111===="+ degrees + "=====i===" + i + "====isFirst====" + isFirst);
//            i++;
//        }else if(degrees != 0){
////            Log.i("degrees","degrees2222===="+ degrees + "=====i===" + i + "====isFirst====" + isFirst);
//            isFirst = true;
//        }
//        canvas.restore();

//        canvas.translate(100, 0);
//        canvas.drawRect(new Rect(0, 0, 400, 400), mPaint);
//        canvas.translate(100, 0);
//        canvas.drawRect(new Rect(0, 0, 400, 400), mPaint);

        canvas.drawRect(new Rect(5, 10, getWidth() - 5, 80), mPaint);
        int count = (getWidth() - 20)/10;
        canvas.translate(10,0);
        for(int i = 0; i <= count; i++){
            if(i % 5 == 0){
                canvas.drawLine(0,80,0,40,mPaint);
            }else{
                canvas.drawLine(0,80,0,60,mPaint);
            }
            canvas.translate(10,0);
        }

//        canvas.save();
//        canvas.rotate(90 + (degrees * 6),getWidth()/2,getHeight()/2);
//        canvas.drawLine(getWidth()/2,getHeight()/2,getWidth()/2 - 180,getHeight()/2,mPaint);
//        canvas.restore();


    }


    public void startAnimation(){

        ValueAnimator animator = ValueAnimator.ofInt(0,60).setDuration(60000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degrees = (int) animation.getAnimatedValue();
                Log.i("degrees","degrees33333===="+ degrees);
                invalidate();
            }
        });
        animator.start();
    }

}
