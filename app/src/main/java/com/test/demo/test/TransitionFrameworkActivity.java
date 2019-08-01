package com.test.demo.test;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionValues;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DEV002 on 2018/5/22.
 */

public class TransitionFrameworkActivity extends AppCompatActivity {

    private Scene mAScene;
    private Scene mAnotherScene;

    private ViewGroup mSceneRoot;
    private Transition mFadeTransition;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_framework);
        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        // Create the scenes
        mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.activity_transition_framework_a, this);
        mAnotherScene =
                Scene.getSceneForLayout(mSceneRoot, R.layout.activity_transition_framework_b, this);
        mFadeTransition =
                TransitionInflater.from(this).
                        inflateTransition(R.transition.fade_transition);
        TextView textView = (TextView) findViewById(R.id.title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(mAnotherScene, mFadeTransition);
            }
        });

        mFadeTransition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionEnd(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionCancel(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionPause(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionResume(@NonNull Transition transition) {

            }
        });

    }
}
