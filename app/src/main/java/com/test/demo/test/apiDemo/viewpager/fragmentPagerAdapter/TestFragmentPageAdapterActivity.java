package com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.viewpager.pageAdapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestFragmentPageAdapterActivity extends BaseActivity {

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
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList));
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
