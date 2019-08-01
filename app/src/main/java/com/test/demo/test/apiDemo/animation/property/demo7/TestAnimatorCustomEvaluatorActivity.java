package com.test.demo.test.apiDemo.animation.property.demo7;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.ShapeHolder;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestAnimatorCustomEvaluatorActivity extends BaseActivity {

    private MyCustomEvaluatorView myCustomEvaluatorView;

    @Override
    public int setLayout() {
        return R.layout.activity_test_animation_custom_evaluator;
    }

    @Override
    public void initView() {
        LinearLayout container = (LinearLayout) findViewById(R.id.test_animation_custom_evaluator_container);
        myCustomEvaluatorView = new MyCustomEvaluatorView(this);
        container.addView(myCustomEvaluatorView);
    }

    @Override
    public void initListener() {

    }

    public void startTestCustomEvaluator(View view){
        myCustomEvaluatorView.startAnimation();
    }

    class MyCustomEvaluatorView extends View implements ValueAnimator.AnimatorUpdateListener{

        ShapeHolder ball;
        BallHoldXY ballHoldXY;
        ObjectAnimator ballAnim;

        public MyCustomEvaluatorView(Context context) {
            this(context,null);
        }

        public MyCustomEvaluatorView(Context context, @Nullable AttributeSet attrs) {
            this(context, attrs,0);
        }

        public MyCustomEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            ball = addBall(25,25);
            ballHoldXY = new BallHoldXY(ball);
        }



        private ShapeHolder addBall(int x, int y) {

            OvalShape circle = new OvalShape();
            circle.resize(50f,50f);

            ShapeDrawable drawable = new ShapeDrawable(circle);
            ShapeHolder holder = new ShapeHolder(drawable);
            holder.setX(x - 25);
            holder.setY(y - 25);

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            int color = 0xff000000 | red << 16 | green << 8 | blue;
            int darkColor = 0xff000000 | red/4 << 16 | green/4 << 8 | blue/4;
            RadialGradient gradient = new RadialGradient(32.7f,12.5f,50f,color,darkColor, Shader.TileMode.CLAMP);
            Paint paint = drawable.getPaint();
            paint.setShader(gradient);
            holder.setPaint(paint);

            return holder;
        }

        public void startAnimation(){

            createAnimation();
            ballAnim.start();
        }

        private void createAnimation() {
            if(ballAnim == null){
                HolderXY startHolderXY = new HolderXY(0,0);
                HolderXY endHolderXY = new HolderXY(300,500);
                ballAnim = ObjectAnimator.ofObject(ballHoldXY,"xY",new MyCustomEvaluator(),startHolderXY,endHolderXY).setDuration(1500);
                ballAnim.addUpdateListener(this);
            }
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.save();
            canvas.translate(ball.getX(),ball.getY());
            ball.getShape().draw(canvas);
            canvas.restore();
        }

        class MyCustomEvaluator implements TypeEvaluator<HolderXY> {

            @Override
            public HolderXY evaluate(float fraction, HolderXY startValue, HolderXY endValue) {
                return new HolderXY(startValue.getmX() + fraction * (endValue.getmX() - startValue.getmX()),startValue.getmY() + fraction * (endValue.getmY() - startValue.getmY()));
            }
        }

        class HolderXY{

            float mX,mY;

            public HolderXY(float mX, float mY) {
                this.mX = mX;
                this.mY = mY;
            }

            public float getmX() {
                return mX;
            }

            public void setmX(float mX) {
                this.mX = mX;
            }

            public float getmY() {
                return mY;
            }

            public void setmY(float mY) {
                this.mY = mY;
            }
        }

        class BallHoldXY{

            ShapeHolder ballHolder;

            public BallHoldXY(ShapeHolder ballHolder) {
                this.ballHolder = ballHolder;
            }

            public void setXY(HolderXY holderXY){
                ballHolder.setX(holderXY.getmX());
                ballHolder.setY(holderXY.getmY());
            }

            public HolderXY getXY() {
                return new HolderXY(ballHolder.getX(), ballHolder.getY());
            }

        }

    }

}
