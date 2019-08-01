package com.test.demo.test.design_pattern.factory_pattern;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.design_pattern.observer_pattern.WeatherObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by DEV002 on 2018/6/21.
 */

public class TestCarFactoryActivity extends BaseActivity {

    TextView textView;

    CarFactory carFactory;

    @Override
    public int setLayout() {
        return R.layout.activity_bind_service;
    }

    @Override
    public void initView() {
        textView = (TextView) findViewById(R.id.bind_service_tv);
        carFactory = new CarFactory(CarName.BMW);
        Car car = carFactory.getCar();
        textView.setText(car.driver());
    }

    @Override
    public void initListener() {

    }
}
