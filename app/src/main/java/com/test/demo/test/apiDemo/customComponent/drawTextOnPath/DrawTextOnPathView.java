package com.test.demo.test.apiDemo.customComponent.drawTextOnPath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * Android的Canvas提供了一个drawTextOnPath(String text,Path path,float hOffset,float vOffset,Paint paint)方法，
 * 该方法可以沿着Path路径绘制文本，其中text指文本内容，hOffset参数指定水平偏移、vOffset指定垂直偏移
 *
 * Created by DEV002 on 2018/6/22.
 */

public class DrawTextOnPathView extends View {

    private String text = "天行健，君子以自强不息";

    private Paint mPaint;

    private Path pathLine,pathOval,pathArc;

    public DrawTextOnPathView(Context context) {
        this(context,null);
    }

    public DrawTextOnPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawTextOnPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        //初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(1);

        //初始化直线
        pathLine = new Path();
        pathLine.moveTo(0,0);
//        for(int i = 0; i < 7; i++){
//            pathLine.lineTo(i * 30, (float) (Math.random() * 30));
//        }
        pathLine.moveTo(0,0);
        pathLine.lineTo(400, 400);
        RectF rectF = new RectF(0,0,200,120);
        //初始化椭圆
        pathOval = new Path();
        pathOval.addOval(rectF, Path.Direction.CCW);

        //初始化圆弧
        pathArc = new Path();
        pathArc.addArc(rectF,60,180);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.translate(40,40);
        //从右开始绘制
        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSize(20);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(pathLine,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(text,pathLine,-8,20,mPaint);

        canvas.translate(0,120);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(pathOval,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(text,pathOval,-20,20,mPaint);

        canvas.translate(0,120);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(pathArc,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(text,pathArc,-10,20,mPaint);

    }
}
