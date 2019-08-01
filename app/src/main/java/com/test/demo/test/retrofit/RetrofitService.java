package com.test.demo.test.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DEV002 on 2018/6/20.
 */


public interface RetrofitService {

    @GET("20160903083245762")
    Call<ResponseBody> getImageStream();

}
