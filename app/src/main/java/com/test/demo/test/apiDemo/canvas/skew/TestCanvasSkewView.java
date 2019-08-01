package com.test.demo.test.apiDemo.canvas.skew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TestCanvasSkewView extends View {

    private Paint mPaint;
    ;

    public TestCanvasSkewView(Context context) {
        this(context,null);
    }

    public TestCanvasSkewView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestCanvasSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
//        canvas.skew(1,0);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawRect(0,0,400,400,mPaint);
        //-----------------------------------------
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(0,0,400,400,mPaint);
//        canvas.skew(0,1);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawRect(0,0,400,400,mPaint);
        //-----------------------------------------
        mPaint.setColor(Color.RED);
        canvas.drawRect(0,0,400,400,mPaint);
        canvas.skew(0.5f,0.5f);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,400,400,mPaint);
    }

}
