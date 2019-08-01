package com.test.demo.test.apiDemo.handler;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.handlerThread.TestCustomHandleThreadActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestHandlerActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handler);
    }

    public void testHandlerPost(View view) {
        IntentUtils.startActivity(this,TestHandlerPostActivity.class);
    }

    public void testHandleSend(View view) {
        IntentUtils.startActivity(this,TestHandlerSendActivity.class);
    }

    public void testCustomHandleSend(View view) {
        IntentUtils.startActivity(this,TestCustomHandleSendActivity.class);
    }

}
