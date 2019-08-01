package com.test.demo.test.apiDemo.animation.property.demo7;

import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *layoutTransition
 */
public class TestLayoutAnimations3Activity extends BaseActivity {

    private LinearLayout container;
    private Button addBtn;

    private LayoutTransition layoutTransition;

    private int i = 0;

    @Override
    public int setLayout() {
        return R.layout.activity_test_layout_animations_3;
    }

    @Override
    public void initView() {
        container = (LinearLayout) findViewById(R.id.test_layout_animation_3_container);
        addBtn = (Button) findViewById(R.id.test_layout_animation_3_add_btn);
        layoutTransition = new LayoutTransition();
        container.setLayoutTransition(layoutTransition);
        setLayoutTransition();
    }

    private void setLayoutTransition() {
//        //系统自带的效果
//        layoutTransition.setAnimator(LayoutTransition.APPEARING,layoutTransition.getAnimator(LayoutTransition.APPEARING));
//        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,layoutTransition.getAnimator(LayoutTransition.DISAPPEARING));
//        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING,layoutTransition.getAnimator(LayoutTransition.CHANGE_APPEARING));
//        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,layoutTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING));
        //使用自定义动画效果
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotationX", 0f,
                90f).setDuration(
                layoutTransition.getDuration(LayoutTransition.DISAPPEARING));
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, animOut);
//--------------------------------------------------------------
        PropertyValuesHolder pvhLeft =
                PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop =
                PropertyValuesHolder.ofInt("top", 0, 1);
//        PropertyValuesHolder pvhRight =
//                PropertyValuesHolder.ofInt("right", 0, 1);
//        PropertyValuesHolder pvhBottom =
//                PropertyValuesHolder.ofInt("bottom", 0, 1);
//        PropertyValuesHolder pvhScaleX =
//                PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
//        PropertyValuesHolder pvhScaleY =
//                PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f);

        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(.9999f, 360f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder pvhRotation =
                PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
        ObjectAnimator animOut2 = ObjectAnimator.ofPropertyValuesHolder(container,
                pvhLeft,pvhTop,pvhRotation).setDuration(layoutTransition.getDuration(LayoutTransition.CHANGE_APPEARING));
        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, animOut2);


    }


    @Override
    public void initListener() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Button btn = new Button(TestLayoutAnimations3Activity.this);
                btn.setText("" + i);
                btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        container.removeView(v);
                    }
                });
                if(container.getChildCount() == 0){
                    container.addView(btn, new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                }else{
                    container.addView(btn,1, new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                }

            }
        });
    }

    public void setLeft(int x){

    }
    public void setTop(int x){

    }
//    public void setRight(int x){
//
//    }
//    public void setBottom(int x){
//
//    }
    public void setScaleX(float x){

    }
    public void setScaleY(float x){

    }
    public void setX(float x){

    }

}
