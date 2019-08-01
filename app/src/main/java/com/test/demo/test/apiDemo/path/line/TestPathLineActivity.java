package com.test.demo.test.apiDemo.path.line;

import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestPathLineActivity extends BaseActivity {
    @Override
    public int setLayout() {
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);     //关闭硬件加速
        return R.layout.activity_test_path_line;
    }

    @Override
    public void initView() {



    }

    public void testPathLineViewAnimation(View view){
        TestPathLineView  testPathLineView = (TestPathLineView) findViewById(R.id.test_path_line_view);
        testPathLineView.startAnimation();
    }

    @Override
    public void initListener() {

    }
}
