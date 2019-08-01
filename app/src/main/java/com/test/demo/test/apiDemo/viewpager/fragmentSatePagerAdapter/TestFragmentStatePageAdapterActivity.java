package com.test.demo.test.apiDemo.viewpager.fragmentSatePagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment01;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment02;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment03;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment04;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment05;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment06;

import java.util.ArrayList;
import java.util.List;

public class TestFragmentStatePageAdapterActivity extends BaseActivity {

    ViewPager mViewPager;
    List<Fragment> fragmentList;

    @Override
    public int setLayout() {
        return R.layout.activity_test_fragment_page_adapter;
    }

    @Override
    public void initView() {

        mViewPager = (ViewPager) findViewById(R.id.test_fragment_page_adapter_view_pager);
        initData();
        mViewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager(),fragmentList));
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        Fragment fragment01 = new MyFragment01();
        Fragment fragment02 = new MyFragment02();
        Fragment fragment03 = new MyFragment03();
        Fragment fragment04 = new MyFragment04();
        Fragment fragment05 = new MyFragment05();
        Fragment fragment06 = new MyFragment06();
        fragmentList.add(fragment01);
        fragmentList.add(fragment02);
        fragmentList.add(fragment03);
        fragmentList.add(fragment04);
        fragmentList.add(fragment05);
        fragmentList.add(fragment06);


    }

    @Override
    public void initListener() {

    }
}
