package com.test.demo.test.apiDemo.canvas.rotate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TestCanvasRotateView extends View {

    private Paint mPaint;
    ;

    public TestCanvasRotateView(Context context) {
        this(context,null);
    }

    public TestCanvasRotateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestCanvasRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
//        canvas.rotate(45);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawRect(0,0,400,400,mPaint);
        //-----------------------------------------
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(0,0,400,400,mPaint);
//        canvas.save();
//        canvas.rotate(45);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawRect(0,0,400,400,mPaint);
//        canvas.restore();
//        canvas.rotate(45,200,200);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(new Rect(0,0,400,400),mPaint);
        //-----------------------------------------
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getWidth()/2,getHeight()/2,200,mPaint);
        for(int i = 0; i < 60; i++){
            canvas.save();
            canvas.rotate(i * 6,getWidth()/2,getHeight()/2);
            if(i % 5 == 0){
                canvas.drawLine(getWidth()/2,(getHeight()/2 - 180),getWidth()/2,(getHeight()/2 - 200),mPaint);
            }else{
                canvas.drawLine(getWidth()/2,(getHeight()/2 - 190),getWidth()/2,(getHeight()/2 - 200),mPaint);
            }
            canvas.restore();
        }
    }

}
