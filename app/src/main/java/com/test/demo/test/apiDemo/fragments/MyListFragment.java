package com.test.demo.test.apiDemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by DEV002 on 2018/5/31.
 */

public class MyListFragment extends ListFragment{

    public static final String TAG = "MyListFragment";

    private OnContentClick onContentClick;


    String[] classes = {
            "计算机网络",
            "操作系统",
            "C语言",
            "Java",
            "数据库原理",
            "移动开发",
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onContentClick = (OnContentClick) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG,"=============onCreateView==============");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG,"=============onViewCreated==============");
        this.setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, classes));

    }



    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"=============onStart==============");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"=============onResume==============");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"=============onPause==============");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"=============onStop==============");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"=============onDestroy==============");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"=============onDestroyView==============");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        onContentClick.onContentClick(position);
    }

    public interface OnContentClick{

        public void onContentClick(int position);

    }

}
