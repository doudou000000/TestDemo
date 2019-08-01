package com.test.demo.test.apiDemo.animation.property.demo4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.test.demo.test.R;

public class TestAnimatorSetActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    MyBallView myBallView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animator_set);
        linearLayout = (LinearLayout) findViewById(R.id.test_animator_set_container);
        linearLayout.addView(new MyBallView(this));
    }
}
