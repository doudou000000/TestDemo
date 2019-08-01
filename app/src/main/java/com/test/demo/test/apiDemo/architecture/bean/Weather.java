package com.test.demo.test.apiDemo.architecture.bean;

public class Weather {

    private String date;

    private String message;

    private int status;

    private String city;

    private WeatherData data;

    public Weather() {
    }

    public Weather(String date, String message, int status, String city, WeatherData data) {
        this.date = date;
        this.message = message;
        this.status = status;
        this.city = city;
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", data=" + data +
                '}';
    }
}
