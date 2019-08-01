package com.test.demo.test.apiDemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by DEV002 on 2018/6/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initListener();
    }
    public abstract int setLayout();

    public abstract void initView();

    public abstract void initListener();

    public void showStrToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    public void showIdToast(int resourceId){
        Toast.makeText(this,resourceId,Toast.LENGTH_SHORT).show();
    }
}
