package com.test.demo.java_test.testJson;

import java.io.Serializable;
import java.util.List;

public class TestJsonBean  implements Serializable {

    private String name;

    private TestJsonXY xy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestJsonXY getXy() {
        return xy;
    }

    public void setXy(TestJsonXY xy) {
        this.xy = xy;
    }
}
