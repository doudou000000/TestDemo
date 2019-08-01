package com.test.demo.test.apiDemo.backStack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.utils.IntentUtils;

/**
 * Created by DEV002 on 2018/6/4.
 */

public class TaskActivityB extends BaseActivity {

    TextView textView;

    @Override
    public int setLayout() {
        return R.layout.activity_task;
    }

    @Override
    public void initView() {
        textView = (TextView) findViewById(R.id.task_tv);
        textView.setText("TaskActivityB==TaskId===" + getTaskId());
    }

    @Override
    public void initListener() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("str","你好，C。我是B");
                IntentUtils.startActivityForBundle(TaskActivityB.this,TaskActivityC.class,bundle);
            }
        });
    }

}
