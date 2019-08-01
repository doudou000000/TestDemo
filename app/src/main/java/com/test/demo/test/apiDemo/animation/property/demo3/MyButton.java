package com.test.demo.test.apiDemo.animation.property.demo3;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;

public class MyButton extends android.support.v7.widget.AppCompatButton {

    private int propName;

    public MyButton(Context context) {
        this(context,null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getPropName() {
        return propName;
    }

    public void setPropName(int propName) {
        this.propName = propName;
        setAlpha(propName);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
