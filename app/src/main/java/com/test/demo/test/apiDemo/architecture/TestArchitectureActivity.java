package com.test.demo.test.apiDemo.architecture;

import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.architecture.mvc.TestMVCArchitectureActivity;
import com.test.demo.test.apiDemo.architecture.mvp.TestMVPArchitectureActivity;
import com.test.demo.test.apiDemo.architecture.mvvm.TestMVVMArchitectureActivity;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestArchitectureActivity extends BaseActivity {

//    https://www.sojson.com/open/api/weather/json.shtml?city=%E5%8C%97%E4%BA%AC

    @Override
    public int setLayout() {
        return R.layout.activity_test_architecture;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    public void testMVCArchitecture(View view) {
        IntentUtils.startActivity(this,TestMVCArchitectureActivity.class);
    }

    public void testMVPArchitecture(View view) {
        IntentUtils.startActivity(this,TestMVPArchitectureActivity.class);
    }

    public void testMVVMArchitecture(View view) {
        IntentUtils.startActivity(this,TestMVVMArchitectureActivity.class);
    }

}
