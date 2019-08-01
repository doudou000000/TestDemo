package com.test.demo.test.scrollerConflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class TestCustomLinearLayout extends LinearLayout {

    int lastY;
    int lastInterceptY;

    Scroller mScroller;

    boolean intercept = false;

    public TestCustomLinearLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
    }

    public TestCustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TestCustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int intercepted = 0;
        int y = (int) event.getY();
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                lastInterceptY = y;
                lastY = y;
                intercepted = 0;
                break;
            case MotionEvent.ACTION_MOVE:

                int dy = y - lastInterceptY;
                System.out.println("dy===222===" + dy + "========" + getScrollY() + "=========" + getTop());
                if(dy > 0){
                    System.out.println("dy===1111===" + dy + "========" + getScrollY() + "=========" + getTop());
                    if(Math.abs(dy) > 50){
                        intercepted = 0;
                    }else{
                        intercepted = 1;
                    }
                }else{
                    System.out.println("dy======" + dy + "========" + getScrollY() + "=========" + getTop());
                    if(Math.abs(dy) > 50){
                        intercepted = 0;
                    }else{
                        intercepted = 1;
                    }

                }

                break;
            case MotionEvent.ACTION_UP:
//                lastInterceptY = 0;
                intercepted = 0;
                break;

        }
        return intercepted != 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:

                scrollBy(0,lastY-y);

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        lastY = y;
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            scrollTo(0,-mScroller.getCurrY());
            invalidate();
        }
    }

//    public void smoothToScroller(int dexY){
//
//        int scrollerY = getScrollY();
//
//        int dy = dexY - scrollerY;
//
//        mScroller.startScroll(0,startY,0,dexY-scrollerY,2000);
//        invalidate();
//    }

}
