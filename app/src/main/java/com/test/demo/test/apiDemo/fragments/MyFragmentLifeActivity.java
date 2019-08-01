package com.test.demo.test.apiDemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment01;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment02;
import com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter.MyFragment03;

/**
 * Created by DEV002 on 2018/5/31.
 */

public class MyFragmentLifeActivity extends FragmentActivity{

    FragmentManager fragmentManager;

    Fragment myFragment01,myFragment02,myFragment03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        myFragment01 = new MyFragment01();
        fragmentTransaction.replace(R.id.test_fragment_life_container,myFragment01,"myFragment01");
//        fragmentTransaction.addToBackStack("myFragment01");
        fragmentTransaction.commit();
    }


    public void addFragmentLife(View view) {
        myFragment02 = new MyFragment02();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.test_fragment_life_container,myFragment02,"myFragment02");
        fragmentTransaction.addToBackStack("myFragment02");
        fragmentTransaction.commit();
    }

    public void replaceFragmentLife(View view) {
        myFragment03 = new MyFragment03();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.test_fragment_life_container,myFragment03,"myFragment03");
        fragmentTransaction.addToBackStack("myFragment03");
        fragmentTransaction.commit();
    }

    public void removeFragmentLife(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(myFragment03);
        fragmentTransaction.commit();
    }
}
