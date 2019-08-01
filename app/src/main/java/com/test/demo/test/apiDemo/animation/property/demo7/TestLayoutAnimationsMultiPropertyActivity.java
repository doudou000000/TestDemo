package com.test.demo.test.apiDemo.animation.property.demo7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.ShapeHolder;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TestLayoutAnimationsMultiPropertyActivity extends BaseActivity {

    private static final int DURATION = 1500;

    Button startBtn;
    LinearLayout container;

    MyMultiPropertyView myMultiPropertyView;

    @Override
    public int setLayout() {
        return R.layout.activity_test_layout_animations_multi_property;
    }

    @Override
    public void initView() {
        startBtn = (Button) findViewById(R.id.test_layout_animation_multi_property_startButton);
        container = (LinearLayout) findViewById(R.id.test_layout_animation_multi_property_container);
        myMultiPropertyView = new MyMultiPropertyView(this);
        container.addView(myMultiPropertyView);
    }

    @Override
    public void initListener() {

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMultiPropertyView.startAnimation();
            }
        });
    }

    class MyMultiPropertyView extends View implements ValueAnimator.AnimatorUpdateListener{

        private static final float BALL_SIZE = 100f;

        private List<ShapeHolder> balls = new ArrayList<ShapeHolder>();

        private ShapeHolder ball;

        private AnimatorSet animatorSet;

        public MyMultiPropertyView(Context context) {
            super(context);
            addBall(50,0);
            addBall(150,0);
            addBall(250,0);
            addBall(350,0);
        }

        private void addBall(int x, int y) {

            OvalShape circle = new OvalShape();
            circle.resize(BALL_SIZE,BALL_SIZE);

            ShapeDrawable drawable = new ShapeDrawable(circle);
            ShapeHolder holder = new ShapeHolder(drawable);

            holder.setX(x);
            holder.setY(y);

            int red = (int)(Math.random() * 255);
            int green = (int)(Math.random() * 255);
            int blue = (int)(Math.random() * 255);
            int color = 0xff000000 | red << 16 | green << 8 | blue;
            int darkColor = 0xff000000 | red/4 << 16 | green/4 << 8 | blue/4;
            RadialGradient gradient = new RadialGradient(37.5f,12.5f,BALL_SIZE,color,darkColor, Shader.TileMode.CLAMP);

            Paint paint = drawable.getPaint();
            paint.setShader(gradient);

            holder.setPaint(paint);

            balls.add(holder);

        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            invalidate();
        }

        public void startAnimation() {
            createAnimation();
            animatorSet.start();
        }

        private void createAnimation() {
            if(animatorSet == null){
                ball = balls.get(0);
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(ball,"y",ball.getY(),getHeight() - BALL_SIZE).setDuration(DURATION);
                objectAnimator1.setInterpolator(new BounceInterpolator());
                objectAnimator1.addUpdateListener(this);

                ball = balls.get(1);
                PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("y",ball.getY(),getHeight() - BALL_SIZE);
                PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("alpha",1f,0f);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(ball,propertyValuesHolder1,propertyValuesHolder2).setDuration(DURATION);
                objectAnimator2.setInterpolator(new AccelerateInterpolator());
                objectAnimator2.setRepeatCount(1);
                objectAnimator2.setRepeatMode(ValueAnimator.REVERSE);


                ball = balls.get(2);
                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("width",ball.getWidth(),ball.getWidth() * 2);
                PropertyValuesHolder propertyValuesHolder4 = PropertyValuesHolder.ofFloat("height",ball.getHeight(),ball.getHeight() * 2);
                PropertyValuesHolder propertyValuesHolder5 = PropertyValuesHolder.ofFloat("x",ball.getX(),ball.getX() - BALL_SIZE/2);
                PropertyValuesHolder propertyValuesHolder6 = PropertyValuesHolder.ofFloat("y",ball.getY(),ball.getY() - BALL_SIZE/2);
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(ball,propertyValuesHolder3,propertyValuesHolder4,propertyValuesHolder5,propertyValuesHolder6).setDuration(DURATION/2);
                objectAnimator3.setRepeatCount(1);
                objectAnimator3.setRepeatMode(ValueAnimator.REVERSE);


                ball = balls.get(3);
                PropertyValuesHolder propertyValuesHolder7 = PropertyValuesHolder.ofFloat("y",ball.getY(),getHeight() - BALL_SIZE);
                Keyframe keyframe = Keyframe.ofFloat(0f,ball.getX());
                Keyframe keyframe1 = Keyframe.ofFloat(0.5f,ball.getX() + 100);
                Keyframe keyframe2 = Keyframe.ofFloat(1f,ball.getX() + 50);
                PropertyValuesHolder propertyValuesHolder8 = PropertyValuesHolder.ofKeyframe("x",keyframe,keyframe1,keyframe2);
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofPropertyValuesHolder(ball,propertyValuesHolder7,propertyValuesHolder8).setDuration(DURATION/2);
                objectAnimator4.setRepeatCount(1);
                objectAnimator4.setRepeatMode(ValueAnimator.REVERSE);

                animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3,objectAnimator4);

            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for(ShapeHolder ball: balls){
                canvas.translate(ball.getX(),ball.getY());
                ball.getShape().draw(canvas);
                canvas.translate(-ball.getX(),-ball.getY());
            }
        }
    }

}
