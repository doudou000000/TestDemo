package com.test.demo.test.apiDemo.animation.property.demo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

/**
 * 自定义估值器实现抛物线效果
 * Created by DEV002 on 2018/6/26.
 */

public class PaowuxianActivity extends BaseActivity{

    private ImageView mBlueBall;

    @Override
    public int setLayout() {
        return R.layout.activity_paowuxian_demo;
    }

    @Override
    public void initView() {
        mBlueBall = (ImageView) findViewById(R.id.id_ball);
    }

    @Override
    public void initListener() {

    }

    /**
     * 抛物线
     * @param view
     */
    public void paowuxian(View view){
        //设置自定义的TypeEvaluator，起始属性
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PaowuxianTypeEvaluator(), new Point(0, 0),new Point(400,600));
        //设置持续时间
        valueAnimator.setDuration(1500);
        //设置线性时间插值器
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                mBlueBall.setX(point.x);
                mBlueBall.setY(point.y);
            }
        });
        valueAnimator.start();
    }

}
