package com.test.demo.test.apiDemo.path.line;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TestPathLineView extends View {

    private Paint mPaint;

    private Path mPath,mPath1;

    private PathMeasure pathMeasure;

    private float dis[] = new float[2];

    public TestPathLineView(Context context) {
        this(context,null);
    }

    public TestPathLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestPathLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.RED);

        mPath = new Path();
        mPath1 = new Path();

        pathMeasure = new PathMeasure();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        //----------------lineTo-------------------------

//        mPath.lineTo(100,100);
//        canvas.drawPath(mPath,mPaint);
        //----------------moveTo-------------------------
//        mPath.moveTo(50,50);
//        mPath.lineTo(150,150);
//        canvas.drawPath(mPath,mPaint);
        //---------------rMoveTo(相对于前一个MoveTo点移动)-配合moveTo使用-------------------------
//        mPath.moveTo(0, 0);
//        mPath.lineTo(100, 100);
//        mPath.rMoveTo(100, 100);
//        mPath.lineTo(400, 400);
//        canvas.drawPath(mPath,mPaint);

        //-------------arcTo-----------------------
//        RectF mRectF = new RectF(10, 100, 400, 800);
//        mPath.arcTo(mRectF, 0, 90,true);
////        mPath.addRect(mRectF, Path.Direction.CW);
////        mPath.close();
//        canvas.drawPath(mPath,mPaint);
        //-------------贝塞尔曲线------二次-----------------

//        mPath.moveTo(100,400);
//        mPath.lineTo(300,200);
//        mPath.lineTo(400,400);
//
//        mPath1.moveTo(100,400);
//        mPath1.quadTo(300,200,400,400);
//        pathMeasure.setPath(mPath1,false);
//        canvas.drawPath(mPath1,mPaint);
//        canvas.drawPath(mPath,mPaint);
//
//        canvas.drawCircle(dis[0],dis[1],5,mPaint);

        //-------------贝塞尔曲线------三次-----------------
//        mPath.moveTo(100,400);
//        mPath.lineTo(150,200);
//        mPath.lineTo(300,200);
//        mPath.lineTo(400,400);
//
//        mPath1.moveTo(100,400);
//        mPath1.cubicTo(150,200,300,200,400,400);
//        pathMeasure.setPath(mPath1,false);
//
//        canvas.drawPath(mPath,mPaint);
//        canvas.drawPath(mPath1,mPaint);
//
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(dis[0],dis[1],5,mPaint);
          //-------------贝塞尔曲线demo----画心-------------------
        mPaint.setStyle(Paint.Style.STROKE);
        mPath1.moveTo(200,200);
        mPath1.quadTo(300,150,200,300);
        mPath1.quadTo(100,150,200,200);
        mPath1.close();
        pathMeasure.setPath(mPath1,false);
        canvas.drawPath(mPath1,mPaint);

        canvas.drawCircle(dis[0],dis[1],5,mPaint);

        setLayerType(LAYER_TYPE_SOFTWARE,null);

    }


    public void startAnimation(){
        float len = pathMeasure.getLength();
        ValueAnimator animator = ValueAnimator.ofFloat(0,pathMeasure.getLength());
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                pathMeasure.getPosTan(value,dis,null);
                invalidate();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mPaint.setMaskFilter(new BlurMaskFilter(5, BlurMaskFilter.Blur.SOLID));//android:hardwareAccelerated="false"  关闭硬件加速
                invalidate();
            }
        });
        animator.start();
    }


}
