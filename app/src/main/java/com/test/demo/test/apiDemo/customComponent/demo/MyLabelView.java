package com.test.demo.test.apiDemo.customComponent.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

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

public class MyLabelView extends View {

    Paint mPaint;
    String text;
    int textSize;
    private int mAscent;

    public MyLabelView(Context context) {
        this(context,null);
    }

    public MyLabelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLabelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLabelView();
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LabelView);
        text = ta.getString(R.styleable.LabelView_text);
        if(text != null){
            setText();
        }
        setTextColor(ta.getColor(R.styleable.LabelView_textColor,0xFF000000));
        textSize = ta.getDimensionPixelOffset(R.styleable.LabelView_textSize,0);
        if(textSize > 0){
            setTextSize();
        }
    }

    private void setTextSize() {
        mPaint.setTextSize(textSize);
        requestLayout();
        invalidate();
    }

    private void setTextColor(int color) {
        mPaint.setColor(color);
        requestLayout();
        invalidate();
    }

    private void setText() {
        requestLayout();
        invalidate();
    }

    private void initLabelView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        mPaint.setColor(0xFF000000);
        setPadding(3, 3, 3, 3);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));

    }

    private int measureHeight(int heightMeasureSpec) {
        int result = 0;

        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        mAscent = (int) mPaint.ascent();
        if(specMode == MeasureSpec.EXACTLY){
            result  = specSize;
        }else{
            result = (int) (mPaint.descent() - mAscent + getPaddingTop() + getPaddingBottom());
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {

        int result = 0;

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result  = specSize;
        }else{
            result = (int) (mPaint.measureText(text) + getPaddingLeft() + getPaddingRight());
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text,getPaddingLeft(), getPaddingTop() - mAscent,mPaint);
    }
}
