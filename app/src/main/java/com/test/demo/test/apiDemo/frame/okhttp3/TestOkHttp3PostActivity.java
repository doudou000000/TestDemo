package com.test.demo.test.apiDemo.frame.okhttp3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.test.demo.test.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

public class TestOkHttp3PostActivity extends AppCompatActivity{

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
        setContentView(R.layout.activity_test_frame_ok_http_3_post);
        //创建OkHttpClient对象
        client = new OkHttpClient();


        //使用post提交String
//        request = new Request.Builder()
//                .post(RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"),"I am jim"))
//                .url("https://api.github.com/markdown/raw")
//                .build();

        //使用post提交流

        RequestBody body = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("text/x-markdown; charset=utf-8");
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8("I am jvm");
            }
        };

        request = new Request.Builder()
                .post(body)
                .url("https://api.github.com/markdown/raw")
                .build();

        call = client.newCall(request);

        textView = (TextView) findViewById(R.id.testOKHttp3PostResponseTv);

    }

    public void testOKHttp3PostRequestBtn(View view){

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
