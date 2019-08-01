package com.test.demo.test.apiDemo.animation.property.demo7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.property.FixedGridLayout;
import com.test.demo.test.apiDemo.base.BaseActivity;

/**
 * 布局中设置android:animateLayoutChanges="true"来改变添加或删除时的动画效果
 */
public class TestLayoutAnimations1Activity extends BaseActivity {


    private int i = 0;

    LinearLayout parent;

    @Override
    public int setLayout() {
        return R.layout.activity_test_layout_animations_1;
    }

    @Override
    public void initView() {
        parent = (LinearLayout) findViewById(R.id.test_layout_animations_1_parent);
    }

    @Override
    public void initListener() {

    }

    public void testLayoutAnimations1AddComment(View view){

        i++;
        Button newButton = new Button(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        newButton.setText("button" + i);
        parent.addView(newButton,lp);

    }
    public void testLayoutAnimations1RemoveComment(View view){
        if(i > 0){
            parent.removeViewAt(0);
        }
    }
}
