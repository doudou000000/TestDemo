package com.test.demo.test;

import com.test.retrofitlib.Retrofit;
import com.test.retrofitlib.http.GET;
import com.test.retrofitlib.http.Query;

import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Call;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitTest {

    private static final String BASE_URL = "http://v.juhe.cn/dream/query/";

    private static final String KEY="e136460f8f0bf18f431bdb7848267fbc";

    private static final String Q="吃饭";
    @ClassRule
    public static RxSchedulersOverrideRule sSchedulersOverrideRule = new RxSchedulersOverrideRule();
    interface DREAM {

        @GET("/dream/query")
        Call get(@Query("q") String q, @Query("key") String key);

//        @POST("/dream/query")
//        Call<TestBean> post(@Query("q") String q,@Query("key") String key);

    }



    @Test
    public void retrofit2() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)
                .build();


//        retrofit2.Retrofit;
//        GsonConverterFactory;
//        RxJava2CallAdapterFactory



        DREAM dream = retrofit.create(DREAM.class);

        {
            Call observable = dream.get(Q, KEY);
            Response response = observable.execute();
//            Response<TestBean> response = call.
//
            if (response != null && response.body() != null) {
                System.out.println("Retrofit GET请求》》》" + response.body().string());
            }

//            observable.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Observer<TestBean>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onNext(TestBean value) {
//                            System.out.println("Retrofit GET请求》》》" + value.toString());
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onComplete() {
//
//                        }
//                    });


        }
//        {
//            Call<ResponseBody> call = dream.post(Q, KEY);
//
//            Response<ResponseBody> response = call.execute();
//
//            if (response != null && response.body() != null) {
//                System.out.println("Retrofit POST请求》》》" + response.body().string());
//            }
//        }
    }

}
