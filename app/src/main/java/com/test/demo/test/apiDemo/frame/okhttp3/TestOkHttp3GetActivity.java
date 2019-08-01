package com.test.demo.test.apiDemo.frame.okhttp3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.demo.test.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestOkHttp3GetActivity extends AppCompatActivity{

    OkHttpClient client;

    Request request;

    Call call;

    TextView textView;


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText((String)msg.obj);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_frame_ok_http_3_get);
        //创建OkHttpClient对象
        client = new OkHttpClient();

        request = new Request.Builder()
                .get()
                .url("http://www.baidu.com")
                .build();

        call = client.newCall(request);

        textView = (TextView) findViewById(R.id.testOKHttp3GetResponseTv);

    }

    public void testOKHttp3GetRequestBtn(View view){

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Message msg = handler.obtainMessage();
                msg.obj = response.body().string();
                handler.sendMessage(msg);

            }
        });

    }

}
