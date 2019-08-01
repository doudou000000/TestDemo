package com.test.demo.test.apiDemo.animation.property.demo3;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.test.demo.test.R;

public class TestObjectAnimatorActivity extends AppCompatActivity {

    MyButton btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_object_animator);
        btn = (MyButton) findViewById(R.id.test_object_animator_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofInt(btn,"propName",1,0);
                objectAnimator.setInterpolator(new LinearInterpolator());
                objectAnimator.setDuration(5000);
                objectAnimator.start();
            }
        });
    }
}
