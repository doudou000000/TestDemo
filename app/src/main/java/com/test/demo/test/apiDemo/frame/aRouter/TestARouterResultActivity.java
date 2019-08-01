package com.test.demo.test.apiDemo.frame.aRouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.test.demo.test.R;
import com.test.demo.test.apiDemo.frame.aRouter.bean.TestData;

@Route(path = "/aRouter/TestARouterResultActivity")
public class TestARouterResultActivity extends AppCompatActivity {
    TextView textView;

    @Autowired(name = "key")
    String value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_arouter_normal);
        textView = (TextView) findViewById(R.id.test_arouter_normal_textView);
        //
        ARouter.getInstance().inject(this);
        textView.setText(value);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result","结果123");
                setResult(123,intent);
                finish();
            }
        });
    }
}
