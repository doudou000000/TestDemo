package com.test.demo.test.eventBus;

public class EventBusBean {

    private String one;

    private String tow;

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTow() {
        return tow;
    }

    public void setTow(String tow) {
        this.tow = tow;
    }

    public EventBusBean(String one, String tow) {
        this.one = one;
        this.tow = tow;
    }

    @Override
    public String toString() {
        return "EventBusBean{" +
                "one='" + one + '\'' +
                ", tow='" + tow + '\'' +
                '}';
    }
}
