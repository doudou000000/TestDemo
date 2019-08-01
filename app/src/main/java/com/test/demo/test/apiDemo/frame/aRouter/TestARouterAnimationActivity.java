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

@Route(path = "/aRouter/TestARouterAnimationActivity")
public class TestARouterAnimationActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_arouter_normal);
        textView = (TextView) findViewById(R.id.test_arouter_normal_textView);

        String value = getIntent().getStringExtra("key");
        textView.setText("你好！我是" + value + "跳转的页面");
    }

}
