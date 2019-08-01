package com.test.demo.test.apiDemo.architecture.model;

import com.test.demo.test.apiDemo.architecture.listener.TestOnWeatherListener;

public interface TestWeatherModel {

    void getWeatherInfo(String cityNumber, TestOnWeatherListener listener);

}
