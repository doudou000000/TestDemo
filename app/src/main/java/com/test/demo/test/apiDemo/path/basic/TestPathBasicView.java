package com.test.demo.test.apiDemo.path.basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class TestPathBasicView extends View {

    private Paint mPaint;

    private Path mPath;

    private Context mContext;


    public TestPathBasicView(Context context) {
        this(context,null);
    }

    public TestPathBasicView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestPathBasicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        //-----------------------------------------
//        mPath.addCircle(300,300,100, Path.Direction.CW);
//        canvas.drawPath(mPath,mPaint);
        //-----------------------------------------
//        mPath.addCircle(300,300,100, Path.Direction.CW);
//        mPath.addRect(new RectF(50,50,250,200), Path.Direction.CW);
//        canvas.drawPath(mPath,mPaint);
        //-----------------------------------------
//        mPath.addCircle(300,300,100, Path.Direction.CW);
//        Path mPath1 = new Path();
//        mPath1.addRect(new RectF(50,50,250,200), Path.Direction.CW);
//        mPath.set(mPath1);//需要关闭硬件加速android:hardwareAccelerated="false"
//        canvas.drawPath(mPath,mPaint);
        //------------------------setFillType:填充模式----------------------
//        mPath.addCircle(300,300,100, Path.Direction.CW);
//        mPath.addCircle(380,380,100, Path.Direction.CW);
////        mPath.setFillType(Path.FillType.WINDING);//取path所有所在区域；
////        mPath.setFillType(Path.FillType.EVEN_ODD);//取path所在并不相交区域；
////        mPath.setFillType(Path.FillType.INVERSE_WINDING);//取path所有未占区域；
//        mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);//取path未占或相交区域；
//        canvas.drawPath(mPath,mPaint);
        //---------------------toggleInverseFillType():切换相反的填充模式----------
//        mPath.addCircle(300,300,100, Path.Direction.CW);
//        mPath.addCircle(380,380,100, Path.Direction.CW);
//        mPath.setFillType(Path.FillType.WINDING);//取path所有所在区域；
//        mPath.toggleInverseFillType();
//        canvas.drawPath(mPath,mPaint);
        //-------------------computeBounds:计算path所在区域--------------------------------
        mPath.addCircle(380,380,150, Path.Direction.CW);
        mPath.addRect(new RectF(200,300,500,500), Path.Direction.CW);
        RectF mComputeRect = new RectF();
        mPath.computeBounds(mComputeRect,false);
        Toast.makeText(mContext,"该path所在区域范围：（" + mComputeRect.left + "," + mComputeRect.top + "," + mComputeRect.right + "," + mComputeRect.bottom + ")",Toast.LENGTH_SHORT).show();
        canvas.drawPath(mPath,mPaint);
    }

}
