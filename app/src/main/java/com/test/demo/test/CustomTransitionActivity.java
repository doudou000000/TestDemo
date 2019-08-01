package com.test.demo.test;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
import android.support.transition.Scene;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionValues;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DEV002 on 2018/5/23.
 */

public class CustomTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_transition_framework_2);
        //-------------------------------------------------------------------
//        ViewGroup mSceneRoot = (ViewGroup) findViewById(R.id.custom_transition_scene_root);
//        TextView textView = (TextView) findViewById(R.id.custom_transition_tv);
//        final Scene mAnotherScene = Scene.getSceneForLayout(mSceneRoot, R.layout.activity_custom_transition_b, this);
//        final Scene mScene = Scene.getSceneForLayout(mSceneRoot, R.layout.activity_custom_transition_a, this);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TransitionManager.go(mAnotherScene,new CustomTransition());
//            }
//        });
        //-------------------------------------------------------------------
        final ViewGroup rootView = (ViewGroup) findViewById(R.id.rootView);
        Button button = (Button) findViewById(R.id.begin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加载Scene
                Scene scene2 = Scene.getSceneForLayout(rootView, R.layout.activity_custom_transition_a_2_1, CustomTransitionActivity.this);
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.addTarget(R.id.image1);
                TransitionManager.go(scene2, changeBounds);
            }
        });
        //-------------------------------------------------------------------
//        final ViewGroup rootView = (ViewGroup) findViewById(R.id.rootView_3);
//        Button button = (Button) findViewById(R.id.begin_3);
//        //加载Scene
//        final Scene scene2 = Scene.getSceneForLayout(rootView, R.layout.activity_custom_transition_b_3, CustomTransitionActivity.this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                TransitionManager.go(scene2, new CustomTransition3());
//            }
//        });
        //-------------------------------------------------------------------
//        final ViewGroup rootView = (ViewGroup) findViewById(R.id.rootView_4);
//        Button button = (Button) findViewById(R.id.begin_4);
//        final View view = (View) findViewById(R.id.delayed_transition);
//        final View view1 = (View) findViewById(R.id.delayed_transition_1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ChangeBounds changeBounds = new ChangeBounds();
//                changeBounds.setDuration(1000);
//                TransitionManager.beginDelayedTransition(rootView,changeBounds);
//                ViewGroup.LayoutParams childParam = view.getLayoutParams();
//                childParam.height = 400;
//                childParam.width = 400;
//                view.setLayoutParams(childParam);
//                ViewGroup.LayoutParams childParam1 = view1.getLayoutParams();
//                childParam1.height = 100;
//                childParam1.width = 100;
//                view1.setLayoutParams(childParam1);
//            }
//        });

    }

    class CustomTransition extends Transition{

        private static final String PROPNAME_HEIGHT =
                "com.test.demo.test:CustomTransition:height";
        private static final String PROPNAME_ALPHA =
                "com.test.demo.test:CustomTransition:alpha";

        @Override
        public void captureStartValues(@NonNull TransitionValues transitionValues) {
            captrueValues(transitionValues);
        }

        @Override
        public void captureEndValues(@NonNull TransitionValues transitionValues) {
            captrueValues(transitionValues);
        }

        public void captrueValues(TransitionValues transitionValues){
//            if(transitionValues.view instanceof TextView){
//                transitionValues.values.put(PROPNAME_HEIGHT,((TextView)transitionValues.view).getCurrentTextColor());
//            }
//            transitionValues.values.put(PROPNAME_ALPHA,((TextView)transitionValues.view).getTextColors());
            transitionValues.values.put(PROPNAME_HEIGHT,transitionValues.view.getHeight());
        }

        @Nullable
        @Override
        public Animator createAnimator(@NonNull ViewGroup sceneRoot, @Nullable TransitionValues startValues, @Nullable TransitionValues endValues) {

            final View endView = endValues.view;

            int startHeight = (int) startValues.values.get(PROPNAME_HEIGHT);

            int endHeight = (int) endValues.values.get(PROPNAME_HEIGHT);
            final ViewGroup.LayoutParams layoutParams = endView.getLayoutParams();
//            ObjectAnimator animator = ObjectAnimator.ofInt(endView, "textColor", startHeight,endHeight);

            if(startHeight != endHeight){
                ValueAnimator animator = ValueAnimator.ofInt(startHeight,endHeight);
                animator.setDuration(15000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int height = (int) animation.getAnimatedValue();
                        layoutParams.height = height;
                        endView.setLayoutParams(layoutParams);
                        endView.requestFocus();
                    }
                });
                return animator;
            }
            return null;
        }
    }

    class CustomTransition3 extends Transition{

        private static final String PROPNAME_RADIUS =
                "com.test.demo.test:CustomTransition:radius";
        private static final String PROPNAME_COLOR =
                "com.test.demo.test:CustomTransition:color";
        private static final String PROPNAME_CRNTER_X =
                "com.test.demo.test:CustomTransition:centerx";
        private static final String PROPNAME_CRNTER_Y =
                "com.test.demo.test:CustomTransition:centery";

        @Override
        public void captureStartValues(@NonNull TransitionValues transitionValues) {
            captrueValues(transitionValues);
        }

        @Override
        public void captureEndValues(@NonNull TransitionValues transitionValues) {
            captrueValues(transitionValues);
        }

        public void captrueValues(TransitionValues transitionValues){
            if(transitionValues.view instanceof CustomCircleView){
                transitionValues.values.put(PROPNAME_RADIUS,((CustomCircleView)transitionValues.view).getRadius());
                transitionValues.values.put(PROPNAME_COLOR,((CustomCircleView)transitionValues.view).getColor());
                transitionValues.values.put(PROPNAME_CRNTER_X,((CustomCircleView)transitionValues.view).getCenterX());
                transitionValues.values.put(PROPNAME_CRNTER_Y,((CustomCircleView)transitionValues.view).getCenterY());
            }
//            transitionValues.values.put(PROPNAME_ALPHA,((TextView)transitionValues.view).getTextColors());
//            transitionValues.values.put(PROPNAME_HEIGHT,transitionValues.view.getWidth());
        }

        @Nullable
        @Override
        public Animator createAnimator(@NonNull ViewGroup sceneRoot, @Nullable TransitionValues startValues, @Nullable TransitionValues endValues) {

            final CustomCircleView endView = (CustomCircleView) endValues.view;

            int startRadius = (int) startValues.values.get(PROPNAME_RADIUS);
            int endRadius = (int) endValues.values.get(PROPNAME_RADIUS);

            int startColor = (int) startValues.values.get(PROPNAME_COLOR);
            int endColor = (int) endValues.values.get(PROPNAME_COLOR);

            int startCenterX = (int) startValues.values.get(PROPNAME_CRNTER_X);
            int endCenterX = (int) endValues.values.get(PROPNAME_CRNTER_X);

            int startCenterY = (int) startValues.values.get(PROPNAME_CRNTER_Y);
            int endCenterY = (int) endValues.values.get(PROPNAME_CRNTER_Y);

//            ValueAnimator animator = ValueAnimator.ofInt(startRadius,endRadius);
//            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    int radius = (int) animation.getAnimatedValue();
//                    endView.setRadius(radius);
//                }
//            });
            ValueAnimator animator1 = ValueAnimator.ofObject(new ArgbEvaluator(),startColor,endColor);
            animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int color = (int) animation.getAnimatedValue();
                    endView.setColor(color);
                }
            });

            ValueAnimator animator2 = ValueAnimator.ofInt(startCenterX,endCenterX);
            animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int centerX = (int) animation.getAnimatedValue();
                    endView.setCenterX(centerX);
                }
            });
            ValueAnimator animator3 = ValueAnimator.ofInt(startCenterY,endCenterY);
            animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int centerY = (int) animation.getAnimatedValue();
                    endView.setCenterY(centerY);
                }
            });
//            ObjectAnimator animator2 = ObjectAnimator.ofInt(endView,"centerX",startCenterX,endCenterX);
//            ObjectAnimator animator3 = ObjectAnimator.ofInt(endView,"centerY",startCenterY,endCenterY);
            AnimatorSet set = new AnimatorSet();
            set.playTogether(animator1,animator2,animator3);
            set.setDuration(10000);
            return set;

        }
    }

}
