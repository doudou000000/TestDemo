package com.test.demo.test.apiDemo.architecture.model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.test.demo.test.apiDemo.architecture.bean.Weather;
import com.test.demo.test.apiDemo.architecture.listener.TestOnWeatherListener;

public class TestWeatherModelImp implements TestWeatherModel {

    private RequestQueue requestQueue;

    private Context context;

    public TestWeatherModelImp(Context context) {
        this.context = context;
    }

    @Override
    public void getWeatherInfo(String cityNumber, final TestOnWeatherListener listener) {

        requestQueue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(" https://www.sojson.com/open/api/weather/json.shtml?city=" + cityNumber, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if(s != null){
                    Gson gson = new Gson();
                    Weather weather = gson.fromJson(s,Weather.class);
                    listener.getWeatherSucess(weather);
                }else {
                    listener.getWeatherError();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.getWeatherError();
            }
        });

        requestQueue.add(request);

    }
}
