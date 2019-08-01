package com.test.demo.java_test.testJson;

import java.io.Serializable;
import java.util.List;

public class TestJsonXY  implements Serializable {

    private List<TestJsonX> x;

    private List<TestJsonY> y;


    public List<TestJsonX> getX() {
        return x;
    }

    public void setX(List<TestJsonX> x) {
        this.x = x;
    }

    public List<TestJsonY> getY() {
        return y;
    }

    public void setY(List<TestJsonY> y) {
        this.y = y;
    }
}
