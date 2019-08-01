package com.test.demo.test.apiDemo.animation.property.demo7;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestTransitionShareElementDetailActivity extends BaseActivity {

    private static final String KEY_ID = "ViewTransitionValues:id";

    private int mImageResourceId = R.drawable.ducky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(new ColorDrawable(randomColor()));
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_test_animation_transition_share_element_detail;
    }

    @Override
    public void initView() {
        ImageView titleImage = (ImageView) findViewById(R.id.test_animation_translation_detail_iv);
        titleImage.setImageDrawable(getHeroDrawable());
    }

    @Override
    public void initListener() {

    }

    private Drawable getHeroDrawable() {
        mImageResourceId = getIntent().getIntExtra(KEY_ID,mImageResourceId);
        return getResources().getDrawable(mImageResourceId);
    }

    private static int randomColor() {
        int red = (int)(Math.random() * 128);
        int green = (int)(Math.random() * 128);
        int blue = (int)(Math.random() * 128);
        return 0xFF000000 | (red << 16) | (green << 8) | blue;
    }
}
