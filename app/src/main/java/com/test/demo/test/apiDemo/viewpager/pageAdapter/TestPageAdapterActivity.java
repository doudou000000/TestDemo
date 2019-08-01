package com.test.demo.test.apiDemo.viewpager.pageAdapter;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TestPageAdapterActivity extends BaseActivity {

    private ViewPager mViewPager;

    private MyPagerAdapter mPagerAdapter;

    private List<View> viewList;

    private RadioGroup radioGroup;

    private RadioButton radioButton_1,radioButton_2,radioButton_3;

    @Override
    public int setLayout() {
        return R.layout.activity_test_view_pager_page_adapter;
    }

    @Override
    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.test_page_adapter_view_pager);
        radioGroup = (RadioGroup) findViewById(R.id.test_page_adapter_radio_group);
        radioButton_1 = (RadioButton) findViewById(R.id.test_page_adapter_radio_btn_1);
        radioButton_2 = (RadioButton) findViewById(R.id.test_page_adapter_radio_btn_2);
        radioButton_3 = (RadioButton) findViewById(R.id.test_page_adapter_radio_btn_3);
        initData();
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(3);
        mPagerAdapter = new MyPagerAdapter(viewList);
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void initData() {
        viewList = new ArrayList<>();
        LayoutInflater inflater1 = LayoutInflater.from(this);
        View view1 = inflater1.inflate(R.layout.activity_test_view_pager_item_view_1,null);
        LayoutInflater inflater2 = LayoutInflater.from(this);
        View view2 = inflater2.inflate(R.layout.activity_test_view_pager_item_view_2,null);
        LayoutInflater inflater3 = LayoutInflater.from(this);
        View view3 = inflater3.inflate(R.layout.activity_test_view_pager_item_view_3,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

    }


    @Override
    public void initListener() {

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioButton_1.setChecked(true);
                        radioButton_2.setChecked(false);
                        radioButton_3.setChecked(false);
                        break;
                    case 1:
                        radioButton_1.setChecked(false);
                        radioButton_2.setChecked(true);
                        radioButton_3.setChecked(false);
                        break;
                    case 2:
                        radioButton_1.setChecked(false);
                        radioButton_2.setChecked(false);
                        radioButton_3.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.test_page_adapter_radio_btn_1:
                        mViewPager.setCurrentItem(0);
                        radioButton_1.setChecked(true);
                        radioButton_2.setChecked(false);
                        radioButton_3.setChecked(false);
                        break;
                    case R.id.test_page_adapter_radio_btn_2:
                        mViewPager.setCurrentItem(1);
                        radioButton_1.setChecked(false);
                        radioButton_2.setChecked(true);
                        radioButton_3.setChecked(false);
                        break;
                    case R.id.test_page_adapter_radio_btn_3:
                        mViewPager.setCurrentItem(2);
                        radioButton_1.setChecked(false);
                        radioButton_2.setChecked(false);
                        radioButton_3.setChecked(true);
                        break;
                    default:
                         break;
                }
            }
        });

    }
}
