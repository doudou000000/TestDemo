package com.test.demo.test.apiDemo.handlerThread;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.utils.IntentUtils;

public class TestHandleThreadActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handle_thread);
    }

    public void testCustomHandleThread(View view) {
        IntentUtils.startActivity(this,TestCustomHandleThreadActivity.class);
    }

    public void testAndroidHandleThread(View view) {
        IntentUtils.startActivity(this,TestAndroidHandleThreadActivity.class);
    }
}
