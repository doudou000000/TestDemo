package com.test.demo.test.apiDemo.frame.aRouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.test.demo.test.R;
import com.test.demo.test.apiDemo.frame.aRouter.bean.TestData;

@Route(path = "/aRouter/TestARouterWithDataActivity")
public class TestARouterWithDataActivity extends AppCompatActivity{

    TextView textView;

    @Autowired(name = "key")
    String value;
    @Autowired(name = "testData")
    TestData testData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_arouter_normal);
        textView = (TextView) findViewById(R.id.test_arouter_normal_textView);

        //接受参数有两种形式
        //-------------------------------------------------------------
        //1、使用getIntent
//        String value = getIntent().getStringExtra("key");
//        textView.setText("你好！我是" + value + "跳转的页面");
        //-------------------------------------------------
        //2、使用ARouter的Autowired
        ARouter.getInstance().inject(this);
        textView.setText(testData.getName() + "今年" + testData.getAge() + "。他说，我是" + value);
    }
}
