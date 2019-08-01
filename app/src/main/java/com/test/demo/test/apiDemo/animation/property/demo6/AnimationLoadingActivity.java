package com.test.demo.test.apiDemo.animation.property.demo6;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.ShapeHolder;

import java.util.ArrayList;

public class AnimationLoadingActivity extends AppCompatActivity {

    private static final int DURATION = 1500;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animator_loading);
        LinearLayout container = (LinearLayout) findViewById(R.id.test_animator_loading_container_ll);
        final MyAnimationView animView = new MyAnimationView(this);
        container.addView(animView);

        Button starter = (Button) findViewById(R.id.test_animator_loading_btn);
        starter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                animView.startAnimation();
            }
        });
    }

    public class MyAnimationView extends View implements ValueAnimator.AnimatorUpdateListener {

        private static final float BALL_SIZE = 100f;

        public final ArrayList<ShapeHolder> balls = new ArrayList<ShapeHolder>();
        Animator animation = null;

        public MyAnimationView(Context context) {
            super(context);
            addBall(50, 50);
            addBall(200, 50);
            addBall(350, 50);
            addBall(500, 50, Color.GREEN);
            addBall(650, 50);
            addBall(800, 50);
            addBall(950, 50);
            addBall(1100, 50, Color.YELLOW);
        }

        private void createAnimation() {
            Context appContext = AnimationLoadingActivity.this;

            if (animation == null) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.
                        loadAnimator(appContext, R.animator.object_animator);
                anim.addUpdateListener(this);
                anim.setTarget(balls.get(0));

                ValueAnimator fader = (ValueAnimator) AnimatorInflater.
                        loadAnimator(appContext, R.animator.animator);
                fader.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        balls.get(1).setAlpha((Float) animation.getAnimatedValue());
                    }
                });

                AnimatorSet seq =
                        (AnimatorSet) AnimatorInflater.loadAnimator(appContext,
                                R.animator.animator_set);
                seq.setTarget(balls.get(2));

                ObjectAnimator colorizer = (ObjectAnimator) AnimatorInflater.
                        loadAnimator(appContext, R.animator.color_animator);
                colorizer.setTarget(balls.get(3));
//    <propertyValuesHolder android:propertyName="x" android:valueTo="400"/>
//    <propertyValuesHolder android:propertyName="y" android:valueTo="200"/>
                PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("x",400);
                PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("y",200);
                ObjectAnimator animPvh = ObjectAnimator.ofPropertyValuesHolder(balls.get(4),propertyValuesHolder1,propertyValuesHolder2);
                animPvh.setDuration(1000);
                animPvh.setRepeatCount(1);
                animPvh.setRepeatMode(ObjectAnimator.REVERSE);
//                ObjectAnimator animPvh = (ObjectAnimator) AnimatorInflater.
//                        loadAnimator(appContext, R.animator.object_animator_pvh);
//                animPvh.setTarget(balls.get(4));
//
//<propertyValuesHolder android:propertyName="x" >
//        <keyframe android:fraction="0" android:value="800" />
//        <keyframe android:fraction=".2" android:value="1000" />
//        <keyframe android:fraction="1" android:value="400" />
//    </propertyValuesHolder>
//    <propertyValuesHolder android:propertyName="y" >
//        <keyframe/>
//        <keyframe android:fraction=".2" android:value="300" />
//        <keyframe android:value="1000" />
//    </propertyValuesHolder>

//                ObjectAnimator animPvhKf = (ObjectAnimator) AnimatorInflater.
//                        loadAnimator(appContext, R.animator.object_animator_pvh_kf);
//                animPvhKf.setTarget(balls.get(5));
//
                Keyframe keyframe1 = Keyframe.ofFloat(0,1);
                Keyframe keyframe2 = Keyframe.ofFloat(0.2f,0.4f);
                Keyframe keyframe3 = Keyframe.ofFloat(1,0);

                PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("alpha",keyframe1,keyframe2,keyframe3);
                ValueAnimator faderKf = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder);
                faderKf.setDuration(1000);
                faderKf.setRepeatCount(1);
                faderKf.setRepeatMode(ValueAnimator.REVERSE);
//                ValueAnimator faderKf = (ValueAnimator) AnimatorInflater.
//                        loadAnimator(appContext, R.animator.value_animator_pvh_kf);
                faderKf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        balls.get(6).setAlpha((Float) animation.getAnimatedValue());
                    }
                });

                // This animation has an accelerate interpolator applied on each
                // keyframe interval. In comparison, the animation defined in
                // R.anim.object_animator_pvh_kf uses the default linear interpolator
                // throughout the animation. As these two animations use the
                // exact same path, the effect of the per-keyframe interpolator
                // has been made obvious.
//                <propertyValuesHolder android:propertyName="x" >
//        <keyframe android:fraction="0" android:value="800" />
//        <keyframe android:fraction=".2"
//                  android:interpolator="@android:anim/accelerate_interpolator"
//                  android:value="1000" />
//        <keyframe android:fraction="1"
//                  android:interpolator="@android:anim/accelerate_interpolator"
//                  android:value="400" />
//    </propertyValuesHolder>
//    <propertyValuesHolder android:propertyName="y" >
//        <keyframe/>
//        <keyframe android:fraction=".2"
//                  android:interpolator="@android:anim/accelerate_interpolator"
//                  android:value="300"/>
//        <keyframe android:interpolator="@android:anim/accelerate_interpolator"
//                  android:value="1000" />
//    </propertyValuesHolder>

                Keyframe keyframe9 = Keyframe.ofFloat(0,800);
                Keyframe keyframe10 = Keyframe.ofFloat(0.2f,1000);
                keyframe10.setInterpolator(new AccelerateInterpolator());
                Keyframe keyframe11 = Keyframe.ofFloat(1,400);
                keyframe11.setInterpolator(new AccelerateInterpolator());
                Keyframe keyframe12 = Keyframe.ofFloat(0.2f,300);
                keyframe12.setInterpolator(new AccelerateInterpolator());
                Keyframe keyframe13 = Keyframe.ofFloat(1000);
                keyframe13.setInterpolator(new AccelerateInterpolator());
                PropertyValuesHolder propertyValuesHolder5 = PropertyValuesHolder.ofKeyframe("x",keyframe9,keyframe10,keyframe11);
                PropertyValuesHolder propertyValuesHolder6 = PropertyValuesHolder.ofKeyframe("y",keyframe12,keyframe13);
                ObjectAnimator animPvhKfInterpolated = ObjectAnimator.ofPropertyValuesHolder(balls.get(7),propertyValuesHolder5,propertyValuesHolder6);
                animPvhKfInterpolated.setDuration(1000);
                animPvhKfInterpolated.setRepeatCount(1);
                animPvhKfInterpolated.setRepeatMode(ValueAnimator.REVERSE);


                Keyframe keyframe5 = Keyframe.ofFloat(0,800);
                Keyframe keyframe6 = Keyframe.ofFloat(0.2f,1000);
                Keyframe keyframe7 = Keyframe.ofFloat(1,400);
                Keyframe keyframe8 = Keyframe.ofFloat(0.2f,300);
                Keyframe keyframe14 = Keyframe.ofFloat(1000);
                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofKeyframe("x",keyframe5,keyframe6,keyframe7);
//                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("x",800,1000,400);
                PropertyValuesHolder propertyValuesHolder4 = PropertyValuesHolder.ofKeyframe("y",keyframe8,keyframe14);
//                PropertyValuesHolder propertyValuesHolder4 = PropertyValuesHolder.ofFloat("y",300,0);
                ObjectAnimator animPvhKf = ObjectAnimator.ofPropertyValuesHolder(balls.get(5),propertyValuesHolder3,propertyValuesHolder4);
                animPvhKf.setDuration(1000);
                animPvhKf.setRepeatCount(1);
                animPvhKf.setRepeatMode(ObjectAnimator.REVERSE);


//                ObjectAnimator animPvhKfInterpolated = (ObjectAnimator) AnimatorInflater.
//                        loadAnimator(appContext, R.animator.object_animator_pvh_kf_interpolated);
//                animPvhKfInterpolated.setTarget(balls.get(7));

                animation = new AnimatorSet();
                ((AnimatorSet) animation).playTogether(anim, fader, seq, colorizer, animPvh,
                        animPvhKf, faderKf, animPvhKfInterpolated);
//                ((AnimatorSet) animation).playTogether(anim, fader, seq, colorizer,faderKf,animPvh,animPvhKfInterpolated);
//                ((AnimatorSet) animation).playTogether(anim,animPvhKf);

            }
        }

        public void startAnimation() {
            createAnimation();
            animation.start();
        }

        private ShapeHolder createBall(float x, float y) {
            OvalShape circle = new OvalShape();
            circle.resize(BALL_SIZE, BALL_SIZE);
            ShapeDrawable drawable = new ShapeDrawable(circle);
            ShapeHolder shapeHolder = new ShapeHolder(drawable);
            shapeHolder.setX(x);
            shapeHolder.setY(y);
            return shapeHolder;
        }

        private void addBall(float x, float y, int color) {
            ShapeHolder shapeHolder = createBall(x, y);
            shapeHolder.setColor(color);
            balls.add(shapeHolder);
        }

        private void addBall(float x, float y) {
            ShapeHolder shapeHolder = createBall(x, y);
            int red = (int)(100 + Math.random() * 155);
            int green = (int)(100 + Math.random() * 155);
            int blue = (int)(100 + Math.random() * 155);
            int color = 0xff000000 | red << 16 | green << 8 | blue;
            Paint paint = shapeHolder.getShape().getPaint();
            int darkColor = 0xff000000 | red/4 << 16 | green/4 << 8 | blue/4;
            RadialGradient gradient = new RadialGradient(37.5f, 12.5f,
                    50f, color, darkColor, Shader.TileMode.CLAMP);
            paint.setShader(gradient);
            balls.add(shapeHolder);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            for (ShapeHolder ball : balls) {
                canvas.translate(ball.getX(), ball.getY());
                ball.getShape().draw(canvas);
                canvas.translate(-ball.getX(), -ball.getY());
            }
        }

        public void onAnimationUpdate(ValueAnimator animation) {

            invalidate();
            ShapeHolder ball = balls.get(0);
            ball.setY((Float)animation.getAnimatedValue());
        }
    }

}
