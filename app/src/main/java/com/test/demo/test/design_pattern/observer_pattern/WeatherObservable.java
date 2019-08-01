package com.test.demo.test.design_pattern.observer_pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by DEV002 on 2018/6/21.
 */

public class WeatherObservable extends Observable {

    private static WeatherObservable instance;

    public static WeatherObservable getInstance(){

        if(instance == null){
            instance = new WeatherObservable();
        }

        return instance;

    }

    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        setChanged();
        notifyObservers();
    }
}
