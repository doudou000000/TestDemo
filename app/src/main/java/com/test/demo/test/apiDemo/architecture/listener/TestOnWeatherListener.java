package com.test.demo.test.apiDemo.architecture.listener;

import com.test.demo.test.apiDemo.architecture.bean.Weather;

public interface TestOnWeatherListener {

    void getWeatherSucess(Weather weather);

    void getWeatherError();

}
