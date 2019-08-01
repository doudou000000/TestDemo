package com.test.demo.test.apiDemo.animation.property.demo5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.property.demo4.MyBallView;

public class TestAnimatorSet2Activity extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animator_set);
        linearLayout = (LinearLayout) findViewById(R.id.test_animator_set_container);
        linearLayout.addView(new MyAnimatorView(this));
    }

}
