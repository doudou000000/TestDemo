package com.test.demo.test.apiDemo.handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestCustomHandleSendActivity extends BaseActivity {

    private TextView mTextView;

    static {
        TestCustomLooper.prepare();
    }

    private TestCustomHandler testCustomHandler = new TestCustomHandler(){

        @Override
        public void handleMessage(TestCustomMessage msg) {

            switch (msg.getWhen()){

                case 1:

                    String message = (String) msg.getMsg();

                    mTextView.setText(message);

                    break;
                case 2:

                    String message2 = (String) msg.getMsg();

                    mTextView.setText(message2);

                    break;

            }

        }
    };

    @Override
    public int setLayout() {

        return R.layout.activity_test_handler_send;
    }

    @Override
    public void initView() {
        mTextView = (TextView) findViewById(R.id.test_handler_send_tv);
        try {
            TestCustomLooper.loop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initListener() {

    }

    public void sendHandlerSend(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                TestCustomMessage msg = new TestCustomMessage();

                msg.setWhen(1);

                msg.setMsg("123");

                testCustomHandler.sendMessage(msg);
            }
        }).start();

    }

}
