package com.test.demo.test.retrofit;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DEV002 on 2018/6/7.
 */

public class TestRetrofitActivity extends BaseActivity implements View.OnClickListener{

    String url = "https://img-blog.csdn.net/";

    ImageView imageView;

    @Override
    public int setLayout() {
        return R.layout.activity_test_retrofit;
    }

    @Override
    public void initView() {
        imageView = (ImageView) findViewById(R.id.test_retrofit_iv);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<ResponseBody> responseCall = service.getImageStream();
        responseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream inputStream = response.body().byteStream();
                imageView.setImageBitmap(BitmapFactory.decodeStream(inputStream));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }



    @Override
    public void initListener() {
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_retrofit_iv:
                showStrToast("点我");
                break;
            default:
                break;
        }
    }
}
