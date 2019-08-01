package com.test.demo.test.apiDemo.viewpager;

import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.TestFragmentPageAdapterActivity;
import com.test.demo.test.apiDemo.viewpager.fragmentSatePagerAdapter.TestFragmentStatePageAdapterActivity;
import com.test.demo.test.apiDemo.viewpager.pageAdapter.TestPageAdapterActivity;
import com.test.demo.test.apiDemo.viewpager.pageTransformer.TestPageTransformerActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestViewPagerActivity extends BaseActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_test_view_pager;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    public void testPageAdapterViewPager(View view){
        IntentUtils.startActivity(this,TestPageAdapterActivity.class);
    }
    public void testPageTransformViewPager(View view){
        IntentUtils.startActivity(this,TestPageTransformerActivity.class);
    }

    public void testFragmentPageAdapterViewPager(View view){
        IntentUtils.startActivity(this,TestFragmentPageAdapterActivity.class);
    }
    public void testFragmentStatePageAdapterViewPager(View view){
        IntentUtils.startActivity(this,TestFragmentStatePageAdapterActivity.class);
    }
}
