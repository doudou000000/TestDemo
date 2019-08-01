package com.test.demo.test.apiDemo.canvas.scale;

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

public class TestCanvasScaleView extends View {

    private Paint mPaint;
    ;

    public TestCanvasScaleView(Context context) {
        this(context,null);
    }

    public TestCanvasScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestCanvasScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        //-----------------------------------------
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(0,0,400,400,mPaint);
//        canvas.scale(.5f,.5f);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawRect(0,0,400,400,mPaint);
        //-----------------------------------------
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(0,0,400,400,mPaint);
//        canvas.save();
//        canvas.scale(.5f,.5f);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawRect(0,0,400,400,mPaint);
//        canvas.restore();
//        canvas.scale(.5f,.5f,200,200);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(new Rect(0,0,400,400),mPaint);
        //-----------------------------------------
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        for(int i = 0; i < 10; i++){
            mPaint.setStrokeWidth((i + 1)/2);
            canvas.save();
            float scale = (float) i/10;
            canvas.scale(scale,scale,getWidth()/2,getHeight()/2);
            canvas.drawRect(new Rect(10,(getHeight()/2 - (getWidth() - 20)/2),(getWidth() - 10),(getHeight()/2 + (getWidth() - 20)/2)),mPaint);
            canvas.restore();

        }
        canvas.drawCircle(getWidth()/2,getHeight()/2,100,mPaint);
    }

}
