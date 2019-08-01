package com.test.demo.test.apiDemo.architecture.mvp.presenter;

import android.content.Context;

import com.test.demo.test.apiDemo.architecture.bean.Weather;
import com.test.demo.test.apiDemo.architecture.listener.TestOnWeatherListener;
import com.test.demo.test.apiDemo.architecture.model.TestWeatherModel;
import com.test.demo.test.apiDemo.architecture.model.TestWeatherModelImp;
import com.test.demo.test.apiDemo.architecture.mvp.imp.TestMVPArchitectureImp;

public class TestMVPArchitecturePresenter implements TestOnWeatherListener {

    private TestMVPArchitectureImp testMVPArchitectureImp;

    private TestWeatherModel testWeatherModel;

    public TestMVPArchitecturePresenter(Context context,TestMVPArchitectureImp testMVPArchitectureImp) {
        this.testMVPArchitectureImp = testMVPArchitectureImp;
        testWeatherModel = new TestWeatherModelImp(context);
    }

    public void getWeatherInfo(String cityName){
        testWeatherModel.getWeatherInfo(cityName,this);
    }

    @Override
    public void getWeatherSucess(Weather weather) {
        testMVPArchitectureImp.setTextContent(weather.toString());
    }

    @Override
    public void getWeatherError() {
        testMVPArchitectureImp.setTextContent("获取失败！");
    }
}
