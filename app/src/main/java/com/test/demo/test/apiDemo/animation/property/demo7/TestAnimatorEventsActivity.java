package com.test.demo.test.apiDemo.animation.property.demo7;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.ShapeHolder;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestAnimatorEventsActivity extends BaseActivity {

    TextView startText, repeatText, cancelText, endText;
    TextView startTextAnimator, repeatTextAnimator, cancelTextAnimator, endTextAnimator;

    Button playBtn,cancelBtn,endBtn;

    MyEventsBallView myEventsBallView;

    CheckBox checkBox;

    @Override
    public int setLayout() {
        return R.layout.activity_test_animation_events;
    }

    @Override
    public void initView() {
        startText = (TextView) findViewById(R.id.test_animation_events_startText);
        startText.setAlpha(.5f);
        repeatText = (TextView) findViewById(R.id.test_animation_events_repeatText);
        repeatText.setAlpha(.5f);
        cancelText = (TextView) findViewById(R.id.test_animation_events_cancelText);
        cancelText.setAlpha(.5f);
        endText = (TextView) findViewById(R.id.test_animation_events_endText);
        endText.setAlpha(.5f);
        startTextAnimator = (TextView) findViewById(R.id.test_animation_events_startTextAnimator);
        startTextAnimator.setAlpha(.5f);
        repeatTextAnimator = (TextView) findViewById(R.id.test_animation_events_repeatTextAnimator);
        repeatTextAnimator.setAlpha(.5f);
        cancelTextAnimator = (TextView) findViewById(R.id.test_animation_events_cancelTextAnimator);
        cancelTextAnimator.setAlpha(.5f);
        endTextAnimator = (TextView) findViewById(R.id.test_animation_events_endTextAnimator);
        endTextAnimator.setAlpha(.5f);

        LinearLayout container = (LinearLayout) findViewById(R.id.test_animation_events_container);

        myEventsBallView = new MyEventsBallView(this);
        container.addView(myEventsBallView);

        playBtn = (Button) findViewById(R.id.test_animation_events_startBtn);
        cancelBtn = (Button) findViewById(R.id.test_animation_events_cancelBtn);
        endBtn = (Button) findViewById(R.id.test_animation_events_endBtn);

        checkBox = (CheckBox) findViewById(R.id.test_animation_events_endCB);

    }

    @Override
    public void initListener() {
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEventsBallView.startAnimation(checkBox.isChecked());
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEventsBallView.cancelAnimation();
            }
        });
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEventsBallView.endAnimation();
            }
        });
    }


    class MyEventsBallView extends View implements ValueAnimator.AnimatorUpdateListener,Animator.AnimatorListener{

        ShapeHolder ball;

        AnimatorSet animatorSet;

        boolean endImmediately = false;

        public MyEventsBallView(Context context) {
            this(context,null);
        }

        public MyEventsBallView(Context context, @Nullable AttributeSet attrs) {
            this(context, attrs,0);
        }

        public MyEventsBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            ball = addBall(25,25);
        }

        public void startAnimation(boolean endImmediately){
            this.endImmediately = endImmediately;
            startText.setAlpha(.5f);
            repeatText.setAlpha(.5f);
            cancelText.setAlpha(.5f);
            endText.setAlpha(.5f);
            startTextAnimator.setAlpha(.5f);
            repeatTextAnimator.setAlpha(.5f);
            cancelTextAnimator.setAlpha(.5f);
            endTextAnimator.setAlpha(.5f);
            createAnimation();

            animatorSet.start();

        }

        public void cancelAnimation() {
            createAnimation();
            animatorSet.cancel();
        }

        public void endAnimation() {
            createAnimation();
            animatorSet.end();
        }

        private void createAnimation() {

            if(animatorSet == null){
                ObjectAnimator yAnim = ObjectAnimator.ofFloat(ball,"y",ball.getY(),getHeight() - 50f).setDuration(1500);
                yAnim.setRepeatCount(1);
                yAnim.setRepeatMode(ValueAnimator.REVERSE);
                yAnim.setInterpolator(new AccelerateInterpolator(2f));
                yAnim.addUpdateListener(this);
                yAnim.addListener(this);

                ObjectAnimator xAnim = ObjectAnimator.ofFloat(ball,"x",ball.getX(),ball.getX() + 300).setDuration(1000);
                xAnim.setStartDelay(0);
                xAnim.setRepeatCount(0);
                xAnim.setRepeatMode(ValueAnimator.REVERSE);
                xAnim.setInterpolator(new AccelerateInterpolator(2f));

                ObjectAnimator widthAnim = ObjectAnimator.ofFloat(ball,"width",ball.getWidth(),ball.getWidth() + 50).setDuration(1000);
                widthAnim.setRepeatCount(0);
                widthAnim.setRepeatMode(ValueAnimator.REVERSE);
                widthAnim.setInterpolator(new AccelerateInterpolator(2f));

                animatorSet = new AnimatorSet();
                animatorSet.play(yAnim).after(widthAnim).with(xAnim);
                animatorSet.addListener(this);
            }



        }

        private ShapeHolder addBall(int x, int y) {

            OvalShape circle = new OvalShape();
            circle.resize(50f, 50f);

            ShapeDrawable drawable = new ShapeDrawable(circle);
            ShapeHolder holder = new ShapeHolder(drawable);

            holder.setX(x - 25);
            holder.setY(x - 25);

            Paint paint = drawable.getPaint();

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            int color = 0xff000000 | red << 16 | green << 8 | blue;
            int darkColor = 0xff000000 | red / 4 << 16 | green / 4 << 8 | blue / 4;

            RadialGradient gradientDrawable = new RadialGradient(37.5f, 12.5f, 50f, color, darkColor, Shader.TileMode.CLAMP);
            paint.setShader(gradientDrawable);

            holder.setPaint(paint);

            return holder;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.save();
            canvas.translate(ball.getX(),ball.getY());
            ball.getShape().draw(canvas);
            canvas.restore();
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            invalidate();
        }

        @Override
        public void onAnimationStart(Animator animation) {
            if (animation instanceof AnimatorSet) {
                startText.setAlpha(1f);
            }else{
                startTextAnimator.setAlpha(1f);
            }
            if(endImmediately){
                animatorSet.end();
            }
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (animation instanceof AnimatorSet) {
                endText.setAlpha(1f);
            }else{
                endTextAnimator.setAlpha(1f);
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            if (animation instanceof AnimatorSet) {
                cancelText.setAlpha(1f);
            }else{
                cancelTextAnimator.setAlpha(1f);
            }
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            if (animation instanceof AnimatorSet) {
                repeatText.setAlpha(1f);
            }else{
                repeatTextAnimator.setAlpha(1f);
            }
        }
    }

}
