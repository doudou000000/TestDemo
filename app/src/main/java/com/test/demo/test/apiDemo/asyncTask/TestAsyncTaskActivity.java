package com.test.demo.test.apiDemo.asyncTask;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.utils.IntentUtils;

public class TestAsyncTaskActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_task);
    }

    public void testAsyncTaskExecute(View view) {
        IntentUtils.startActivity(this,TestAsyncTaskExecuteActivity.class);
    }

    public void testAsyncTaskExecuteOnExecutor(View view) {
        IntentUtils.startActivity(this,TestAsyncTaskExecuteOnExecutorActivity.class);
    }

    public void testAsyncTaskLoader(View view) {
        IntentUtils.startActivity(this,TestAsyncTaskLoaderActivity.class);
    }
}
