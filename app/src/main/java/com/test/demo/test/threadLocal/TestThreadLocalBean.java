package com.test.demo.test.threadLocal;

public class TestThreadLocalBean {

    String name;

    public TestThreadLocalBean() {
    }

    public TestThreadLocalBean(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
