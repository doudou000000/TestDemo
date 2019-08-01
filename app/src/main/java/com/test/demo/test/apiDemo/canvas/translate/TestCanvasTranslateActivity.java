package com.test.demo.test.apiDemo.canvas.translate;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestCanvasTranslateActivity extends BaseActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_test_canvas_translate;
    }

    @Override
    public void initView() {
        TestCanvasTranslateView testCanvasTranslateView = (TestCanvasTranslateView) findViewById(R.id.test_canvas_translate_custom_view);
        testCanvasTranslateView.startAnimation();
    }

    @Override
    public void initListener() {

    }
}
