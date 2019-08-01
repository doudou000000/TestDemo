package com.test.demo.test.apiDemo.viewTouch;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.test.demo.test.R;

public class TestViewGroupTouchActivity extends Activity {

    TestCustomViewGroup testCustomViewGroup;

    private final static float[] MATRIX = new float[] {
            1.0f,0.7f,0.0f,
            0.0f,1.0f,0.0f,
            0.0f,0.0f,1.0f};

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_group_touch);
        testCustomViewGroup = (TestCustomViewGroup) findViewById(R.id.test_view_group_touch_view);
        imageView = (ImageView) findViewById(R.id.test_view_group_touch_image_view);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
//        TestMatrixActivity.setRotate(45,imageView.getWidth()/2,imageView.getHeight()/2);
        matrix.setValues(MATRIX);
        imageView.setImageMatrix(matrix);
    }
}
