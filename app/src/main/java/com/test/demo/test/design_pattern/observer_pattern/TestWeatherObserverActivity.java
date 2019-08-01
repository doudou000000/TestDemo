package com.test.demo.test.design_pattern.observer_pattern;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.test.demo.test.R;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by DEV002 on 2018/6/21.
 */

public class TestWeatherObserverActivity extends AppCompatActivity implements Observer {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_observer);
        textView = (TextView) findViewById(R.id.weather_observer_tv);

        WeatherObservable.getInstance().addObserver(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WeatherObservable.getInstance().setWeatherContent("今天天气晴朗，适宜出去逛街！！！");
            }
        },5000);
    }


    @Override
    public void update(Observable o, Object arg) {
        textView.setText(((WeatherObservable)o).getWeatherContent());
    }
}
