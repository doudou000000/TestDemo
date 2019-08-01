package com.test.demo.test.apiDemo.architecture.bean;

import java.util.List;

public class WeatherData {

    private String shidu;

    private String pm25;

    private String pm10;

    private String quality;

    private String wendu;

    private String ganmao;

    private WeatherDataInfo yesterday;

    private List<WeatherDataInfo> forecast;

    public WeatherData() {
    }

    public WeatherData(String shidu, String pm25, String pm10, String quality, String wendu, String ganmao, WeatherDataInfo yesterday, List<WeatherDataInfo> forecast) {
        this.shidu = shidu;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.quality = quality;
        this.wendu = wendu;
        this.ganmao = ganmao;
        this.yesterday = yesterday;
        this.forecast = forecast;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public WeatherDataInfo getYesterday() {
        return yesterday;
    }

    public void setYesterday(WeatherDataInfo yesterday) {
        this.yesterday = yesterday;
    }

    public List<WeatherDataInfo> getForecast() {
        return forecast;
    }

    public void setForecast(List<WeatherDataInfo> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "shidu='" + shidu + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", pm10='" + pm10 + '\'' +
                ", quality='" + quality + '\'' +
                ", wendu='" + wendu + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", yesterday=" + yesterday +
                ", forecast=" + forecast +
                '}';
    }
}
