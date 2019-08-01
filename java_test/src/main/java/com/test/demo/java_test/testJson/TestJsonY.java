package com.test.demo.java_test.testJson;

import java.io.Serializable;

public class TestJsonY  implements Serializable {


    private String height;

    private TestJsonShotY shotY;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public TestJsonShotY getShotY() {
        return shotY;
    }

    public void setShotY(TestJsonShotY shotY) {
        this.shotY = shotY;
    }
}
