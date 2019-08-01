package com.test.demo.test.apiDemo.animation.property.demo;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by DEV002 on 2018/6/26.
 */

public class PaowuxianTypeEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {

        Point point = new Point();
        //不使用startValue和endValue，实现抛物线
        point.x = 200 * (fraction * 1.5f);
        point.y = 200 * (fraction * 1.5f) * (fraction * 1.5f);

        //使用startValue和endValue，实现抛物线
        point.x = (fraction * (endValue.x - startValue.x));
        Log.i("TypeEvaluator","startValue ===" + startValue.x);
        Log.i("TypeEvaluator","endValue ===" + endValue.x);
        Log.i("TypeEvaluator","point.x ===" + point.x);
        point.y = point.x * point.x/200;

        return point;
    }
}
