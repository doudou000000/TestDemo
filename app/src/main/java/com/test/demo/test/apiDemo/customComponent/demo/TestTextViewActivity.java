package com.test.demo.test.apiDemo.customComponent.demo;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;


/**
 * 测试动态设置textView的高度
 */

public class TestTextViewActivity extends BaseActivity {


    TextView textView;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lp.height = ((int)((float)height * (1f - i/100f)));
            textView.setLayoutParams(lp);
        }
    };
    int i,height;
    ViewGroup.LayoutParams lp;
    @Override
    public int setLayout() {
        return R.layout.activity_test_text_view_height;
    }

    @Override
    public void initView() {
        textView = (TextView) findViewById(R.id.test_text_view_height_tv);
        lp = textView.getLayoutParams();
        height = lp.height;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(i = 0; i < 100; i++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler.sendEmptyMessage(0);
                }
            }
        }).start();





    }

    @Override
    public void initListener() {

    }
}
