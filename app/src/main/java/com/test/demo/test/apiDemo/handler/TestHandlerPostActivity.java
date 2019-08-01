package com.test.demo.test.apiDemo.handler;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

/**
 * handler post的使用
 * 包含Activity.runOnUIThread(runnable) 和 view.post(runnable)的使用
 */
public class TestHandlerPostActivity extends BaseActivity{

    private TextView mTextView;

    private Handler mHandler = new Handler();

    @Override
    public int setLayout() {
        return R.layout.activity_test_handler_post;
    }

    @Override
    public void initView() {
        mTextView = (TextView) findViewById(R.id.test_handler_post_tv);
    }

    @Override
    public void initListener() {

    }

    public void sendHandlerPost(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTextView.setText("我是handler—post更新的");
                    }
                });

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextView.setText("我是runOnUiThread更新的");
                    }
                });
//
                mTextView.post(new Runnable() {
                    @Override
                    public void run() {
                        mTextView.setText("我是view—post更新的");
                    }
                });

            }
        }).start();

    }

}
