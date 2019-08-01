package com.test.demo.test.apiDemo.frame.aRouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.demo.test.R;

@Route(path = "/aRouter/TestARouterNormalActivity")
public class TestARouterNormalActivity extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_arouter_normal);
        textView = (TextView) findViewById(R.id.test_arouter_normal_textView);
        textView.setText("你好！我是一个经过普通路由跳转的页面");
    }
}
