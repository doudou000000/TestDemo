package com.test.demo.test.apiDemo.matrix;

import android.app.Activity;
import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.TestFragmentPageAdapterActivity;
import com.test.demo.test.apiDemo.viewpager.fragmentSatePagerAdapter.TestFragmentStatePageAdapterActivity;
import com.test.demo.test.apiDemo.viewpager.pageAdapter.TestPageAdapterActivity;
import com.test.demo.test.apiDemo.viewpager.pageTransformer.TestPageTransformerActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestMatrixActivity extends BaseActivity{

    @Override
    public int setLayout() {
        return R.layout.activity_test_matrix;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    public void testMatrixDemo1(View view){
        IntentUtils.startActivity(this,TestMatrixDemo1Activity.class);
    }
    public void testMatrixDemo2(View view){
        IntentUtils.startActivity(this,TestMatrixDemo2Activity.class);
    }

    public void testMatrixDemo3(View view){
        IntentUtils.startActivity(this,TestMatrixDemo3Activity.class);
    }

}
