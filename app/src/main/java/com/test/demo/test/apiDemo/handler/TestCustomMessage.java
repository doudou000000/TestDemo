package com.test.demo.test.apiDemo.handler;

public class TestCustomMessage {

    private TestCustomHandler target;

    private Object msg;

    private int when;

    public TestCustomMessage() {
    }

    public TestCustomHandler getTarget() {
        return target;
    }

    public void setTarget(TestCustomHandler target) {
        this.target = target;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getWhen() {
        return when;
    }

    public void setWhen(int when) {
        this.when = when;
    }
}
