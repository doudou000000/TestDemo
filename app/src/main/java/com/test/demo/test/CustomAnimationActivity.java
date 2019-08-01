package com.test.demo.test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

/**
 * Created by DEV002 on 2018/5/30.
 */

public class CustomAnimationActivity extends AppCompatActivity {

    View view;

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_animation);
        view = (View) findViewById(R.id.custom_animation_circle_view);
        button = (Button) findViewById(R.id.custom_animation_exit_enter_btn);
        // get the center for the clipping circle
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                int cx = (view.getLeft() + view.getRight()) / 2;
                int cy = (view.getTop() + view.getBottom()) / 2;
                // get the initial radius for the clipping circle
                int initialRadius = view.getWidth();
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(view, view.getWidth()/2, view.getHeight()/2, initialRadius, 0);
                anim.setDuration(2000);
                // make the view invisible when the animation is done
                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.GONE);
                    }
                });
                // start the animation
                anim.start();
            }
        },1000);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomAnimationActivity.this,CustomAnimationShareElementActivity.class);
                ActivityOptions options =  ActivityOptions.makeSceneTransitionAnimation(CustomAnimationActivity.this,view,"share_element_1");
                startActivity(intent,options.toBundle());
            }
        });

    }
}
