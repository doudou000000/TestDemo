package com.test.demo.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DEV002 on 2018/5/23.
 */

public class CustomCircleView extends View {

    private Paint mPaint;

    private int radius;

    private int color;

    private int centerX;

    private int centerY;

    private RectF rectF;

    public CustomCircleView(Context context) {
        this(context,null);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyCircleView);
        radius = (int) ta.getDimension(R.styleable.MyCircleView_radius,10);
        color = ta.getColor(R.styleable.MyCircleView_color,context.getResources().getColor(R.color.colorPrimary));
        centerX = (int) ta.getDimension(R.styleable.MyCircleView_x,100);
        centerY = (int) ta.getDimension(R.styleable.MyCircleView_y,100);
        ta.recycle();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        rectF = new RectF();
        rectF.left = 0;
        rectF.top = 0;
        rectF.right = 100;
        rectF.bottom = 100;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(color);
//        canvas.drawCircle(centerX,centerY,radius,mPaint);
//        canvas.drawRoundRect(rectF,centerX,centerY,mPaint);
        canvas.drawRoundRect(rectF,centerX,centerY,mPaint);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        invalidate();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    public int getCenterX() {
        return centerX;

    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
        invalidate();
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
        invalidate();
    }
}
