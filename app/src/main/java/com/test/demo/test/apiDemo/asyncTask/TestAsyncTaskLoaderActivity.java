package com.test.demo.test.apiDemo.asyncTask;

import android.view.View;
import android.widget.ProgressBar;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.handler.TestHandlerPostActivity;
import com.test.demo.test.apiDemo.handler.TestHandlerSendActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestAsyncTaskLoaderActivity extends BaseActivity{

    ProgressBar progressBar1,progressBar2,progressBar3;

    @Override
    public int setLayout() {
        return R.layout.activity_test_async_task_loader;
    }

    @Override
    public void initView() {
        progressBar1 = (ProgressBar) findViewById(R.id.test_async_task_loader_progressbar_1);
        progressBar2 = (ProgressBar) findViewById(R.id.test_async_task_loader_progressbar_2);
        progressBar3 = (ProgressBar) findViewById(R.id.test_async_task_loader_progressbar_3);
    }

    @Override
    public void initListener() {

    }

    public void testAsyncTaskLoaderBeginBtn(View view) {

    }

    public void testAsyncTaskLoaderEndBtn(View view) {
        IntentUtils.startActivity(this,TestHandlerSendActivity.class);
    }

}
