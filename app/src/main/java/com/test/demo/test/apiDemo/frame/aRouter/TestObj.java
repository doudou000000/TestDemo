package com.test.demo.test.apiDemo.frame.aRouter;

public class TestObj {

    public String name;
    public int id;

    public TestObj() {
    }

    public TestObj(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
