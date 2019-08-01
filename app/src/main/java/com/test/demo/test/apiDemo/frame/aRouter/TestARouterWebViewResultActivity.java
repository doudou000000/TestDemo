package com.test.demo.test.apiDemo.frame.aRouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.test.demo.test.R;

@Route(path = "/aRouter/TestARouterWebViewResultActivity")
public class TestARouterWebViewResultActivity extends AppCompatActivity {

    TextView textView;

    @Autowired
    String url;
    @Autowired
    String name;
    @Autowired
    int age;
    @Autowired
    boolean boy;
    @Autowired
    int high;
    @Autowired
    TestObj obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_arouter_normal);
        ARouter.getInstance().inject(this);
        textView = (TextView) findViewById(R.id.test_arouter_normal_textView);
        if(boy){
            textView.setText("我是URL跳转得到的" + "url=" + url + "name=" + name + "age=" + age + "high=" + high + "obj=" + obj.toString());
        }

    }

}
