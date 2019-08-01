package com.test.demo.test.apiDemo.customComponent.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.test.demo.test.R;

/**
 *
 * String str = "Hello";
 canvas.drawText( str , x , y , paint);

 //1. 粗略计算文字宽度
 Log.d(TAG, "measureText=" + paint.measureText(str));

 //2. 计算文字所在矩形，可以得到宽高
 Rect rect = new Rect();
 paint.getTextBounds(str, 0, str.length(), rect);
 int w = rect.width();
 int h = rect.height();
 Log.d(TAG, "w=" +w+"  h="+h);

 //3. 精确计算文字宽度
 int textWidth = getTextWidth(paint, str);
 Log.d(TAG, "textWidth=" + textWidth);

 public static int getTextWidth(Paint paint, String str) {
 int iRet = 0;
 if (str != null && str.length() > 0) {
 int len = str.length();
 float[] widths = new float[len];
 paint.getTextWidths(str, widths);
 for (int j = 0; j < len; j++) {
 iRet += (int) Math.ceil(widths[j]);
 }
 }
 return iRet;
 }
 *
 *
 * Created by DEV002 on 2018/6/22.
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView {

    Paint mPaint;
    String text = "HOT";
    Path path,path1;


    public MyImageView(Context context) {
        this(context,null);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(1);
        path = new Path();
        path1 = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.moveTo(getWidth() - 100,0);
        path.lineTo(getWidth() - 200,0);
        path.lineTo(getWidth(), 200);
        path.lineTo(getWidth(), 100);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path,mPaint);



        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(30);
        path1.moveTo(getWidth() - 200,0);
        path1.lineTo(getWidth(), 200);
        canvas.drawTextOnPath(text,path1,120,-20,mPaint);
    }
}
