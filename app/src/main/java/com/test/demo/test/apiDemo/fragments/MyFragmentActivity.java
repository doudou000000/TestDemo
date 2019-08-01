package com.test.demo.test.apiDemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.utils.IntentUtils;

/**
 * Created by DEV002 on 2018/5/31.
 */

public class MyFragmentActivity extends FragmentActivity implements MyListFragment.OnContentClick{

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction list = fragmentManager.beginTransaction();
        list.replace(R.id.fragment_container_list,new MyListFragment());
        list.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        list.commit();
        MyListFragmentContent newFragment = new MyListFragmentContent();
        Bundle args = new Bundle();
        args.putInt("position", 0);
        newFragment.setArguments(args);
        FragmentTransaction content = fragmentManager.beginTransaction();
        content.replace(R.id.fragment_container_content,newFragment);
        content.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        content.commit();
    }

    public void addNextFragment(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_list,new MyListFragmentContent());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    @Override
    public void onContentClick(int position) {
        MyListFragmentContent newFragment = new MyListFragmentContent();
        Bundle args = new Bundle();
        args.putInt("position", position);
        newFragment.setArguments(args);
        FragmentTransaction content = fragmentManager.beginTransaction();
        content.replace(R.id.fragment_container_content,newFragment);
        content.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        content.commit();
    }

    public void testFragmentLife(View view) {
        IntentUtils.startActivity(this,MyFragmentLifeActivity.class);
    }
}
