package com.test.demo.test.apiDemo.viewpager.pageTransformer;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestPageTransformerActivity extends BaseActivity {

    private RelativeLayout container;

    private ViewPager mViewPager;

    private int images[] = new int[]{R.drawable.view_page_b,R.drawable.view_page_d,R.drawable.view_page_e,R.drawable.view_page_f,R.drawable.view_page_g,R.drawable.view_page_h};

    private MyPageFormerAdapter myPagerFormerAdapter;

    private int currentIndex = 0;
    boolean mIsChanged;
    @Override
    public int setLayout() {
        return R.layout.activity_test_view_pager_page_former;
    }

    @Override
    public void initView() {
        container = (RelativeLayout) findViewById(R.id.test_view_page_page_former_container);
        mViewPager = (ViewPager) findViewById(R.id.test_view_page_page_former_view);
        myPagerFormerAdapter = new MyPageFormerAdapter(this,images);
        mViewPager.setPageMargin(40);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageTransformer(true,new MyAlphaPageTransformer());
        mViewPager.setAdapter(myPagerFormerAdapter);
    }

    @Override
    public void initListener() {
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });
    }
}
