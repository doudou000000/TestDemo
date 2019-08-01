package com.test.demo.test.apiDemo.viewTouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class TestCustomViewGroup extends ViewGroup {

    Scroller mScroller;

    int defaultHeight;

    int screenHeight;

    int lastY,mStart,mEnd;

    int height = 0;
    int childHeight = 0;

    public TestCustomViewGroup(Context context) {
        super(context);
        init(context);
    }

    public TestCustomViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TestCustomViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //所有子view加起来总的Measured Dimension高度和宽度
        int measuredWidth = 0;
        int measuredHeight = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View v = getChildAt(i);
            if (v.getVisibility() != View.GONE) {
                measureChild(v, widthMeasureSpec,heightMeasureSpec);
                measuredWidth=Math.max(measuredWidth,v.getMeasuredWidth());
                measuredHeight += v.getMeasuredHeight();
            }
        }

        //仔细检查！不要疏忽掉一些padding的值
        measuredWidth += getPaddingLeft() + getPaddingRight();
        measuredHeight += getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(measuredWidth, measuredHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        for(int i = 0; i < childCount; i++){
            View child = getChildAt(i);

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            int top = height;
            child.layout(1,top,childWidth,top + childHeight);
            height += childHeight;
        }
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        screenHeight = height;// 屏幕高度(dp)
        defaultHeight = height * 1/3;
        scrollTo(0,screenHeight);
        startScroll();
    }




//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastY = (int) event.getY();
//                mStart = getScrollY();
////                Log.i("Scroller","==mStart==" + mStart);
////                Log.i("Scroller","==screenHeight==" + screenHeight);
////                Log.i("Scroller","==defaultHeight==" + defaultHeight);
////                Log.i("Scroller","==screenHeight - defaultHeight==" + (screenHeight - defaultHeight));
//                break;
//            case MotionEvent.ACTION_MOVE:
////                if (!mScroller.isFinished()) {
////                    // 终止滑动
////                    mScroller.abortAnimation();
////                }
//                int offsetY = (int) (lastY - event.getY());
//
////                Log.i("Scroller","==mStart==" + mStart);
//                // 到达顶部,使用offset判断方向
//                if (getScrollY() + offsetY > 0) { // 当前已经滑动的 Y 位置
//                    offsetY = 0;
//                }
//                // 到达底部
//                if (getScrollY() < -(getHeight() - 400) && offsetY < 0) {
//                    offsetY = 0;
//                }
//
//                scrollBy(0, offsetY);
//                // 滑动完成后,重新设置LastY位置
//                lastY = (int) event.getY();
//                break;
//            case MotionEvent.ACTION_UP:
//                mEnd = getScrollY();
//                int distance = mEnd - mStart;
//                Log.i("Scroller","==mEnd==" + mEnd);
//                if (distance > 0) { // 向上滑动
//                    if (distance < screenHeight / 3) {
//                        // 回到原来位置
//                        mScroller.startScroll(0, getScrollY(), 0, -distance);
//                    } else {
//                        // 滚到屏幕的剩余位置
//                        mScroller.startScroll(0, getScrollY(), 0, screenHeight * 2/ 3 - distance);
//                    }
//                } else {             // 向下滑动
//                    if (-distance < screenHeight / 3) {
//                        Log.i("Scroller","==screenHeight / 3==" + distance);
//                        mScroller.startScroll(0, getScrollY(), 0, -distance);
//                    } else {
//                        Log.i("Scroller","==screenHeight 2/ 3==" + distance);
//                        mScroller.startScroll(0, getScrollY(), 0, -screenHeight * 2/ 3 - distance);
//                    }
//                }
//                postInvalidate();
//                break;
//        }
//        return true;
//    }

    public void startScroll(){
        mScroller.startScroll(0,0,0,screenHeight,10000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            int y = -mScroller.getCurrY();
            scrollTo(0,mScroller.getCurrY());
            postInvalidate();
        }
    }

}
