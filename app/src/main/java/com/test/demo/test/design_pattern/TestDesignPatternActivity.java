package com.test.demo.test.design_pattern;

import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.design_pattern.factory_pattern.TestCarFactoryActivity;
import com.test.demo.test.design_pattern.observer_pattern.TestWeatherObserverActivity;
import com.test.demo.test.utils.IntentUtils;

/**
 * Created by DEV002 on 2018/6/25.
 */

public class TestDesignPatternActivity extends BaseActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_test_design_pattern;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    public void testObserver(View view) {

        IntentUtils.startActivity(this,TestWeatherObserverActivity.class);

    }
    public void testFactory(View view) {

        IntentUtils.startActivity(this,TestCarFactoryActivity.class);

    }
}
