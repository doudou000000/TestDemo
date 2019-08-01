package com.test.demo.test.apiDemo.animation.property.demo7;

import android.animation.ObjectAnimator;
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
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.ShapeHolder;

/**
 * 改变球运动的时间
 */
public class TestAnimationSeekingActivity extends Activity {

    private static final float BALL_SIZE = 100f;

    LinearLayout container;

    SeekBar seekBar;
    MyBallView ballView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animation_seeking);
        container = (LinearLayout) findViewById(R.id.test_animation_seekBar_container);
        seekBar = (SeekBar) findViewById(R.id.test_animation_seekBar);
        seekBar.setMax(1500);
        ballView = new MyBallView(this);
        container.addView(ballView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(ballView.getHeight() != 0){
                    ballView.seek(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void startTestAnimationSeekBar(View view) {
        ballView.startAnimation();
    }

    class MyBallView extends View{

        ShapeHolder ball = null;

        ObjectAnimator animator = null;

        public MyBallView(Context context) {
            this(context,null);
        }

        public MyBallView(Context context, @Nullable AttributeSet attrs) {
            this(context, attrs,0);
        }

        public MyBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            ball = addBall(200,0);
        }

        public void startAnimation(){

            createAnimation();
            animator.start();

        }

        public void seek(int seekTime){
            createAnimation();
            animator.setCurrentPlayTime(seekTime);
        }

        private void createAnimation() {

            if(animator == null){
                animator = ObjectAnimator.ofFloat(ball,"y",ball.getY(),(getHeight() - BALL_SIZE)).setDuration(1500);
                animator.setInterpolator(new BounceInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        invalidate();
                    }
                });
            }

        }

        private ShapeHolder addBall(int x, int y) {

            OvalShape circle = new OvalShape();

            circle.resize(BALL_SIZE,BALL_SIZE);

            ShapeDrawable drawable = new ShapeDrawable(circle);

            ShapeHolder holder = new ShapeHolder(drawable);

            holder.setX(x);
            holder.setY(y);

            Paint paint = drawable.getPaint();

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            int color = 0xff000000 | red << 16 | green << 8 | blue;
            int darkColor = 0xff000000 | red/4 << 16 | green/4 << 8 | blue/4;
            RadialGradient gradient = new RadialGradient(37.5f, 12.5f,
                    50f, color, darkColor, Shader.TileMode.CLAMP);
            paint.setShader(gradient);
            holder.setPaint(paint);

            return holder;
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.translate(ball.getX(),ball.getY());
            ball.getShape().draw(canvas);
        }
    }

}
