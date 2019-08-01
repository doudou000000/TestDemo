package com.test.demo.java_test.testJson;

import java.io.Serializable;

public class TestJsonX  implements Serializable {

    private String width;

    private TestJsonShotX shotX;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public TestJsonShotX getShotX() {
        return shotX;
    }

    public void setShotX(TestJsonShotX shotX) {
        this.shotX = shotX;
    }
}
