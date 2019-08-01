package com.test.demo.test.eventBus;

import java.lang.reflect.Method;

public class SubscribeMethod {

    private Method method;

    private TestThreadMode threadMode;

    private Class<?> type;

    private boolean stick;

    public SubscribeMethod(Method method, TestThreadMode threadMode, Class<?> type,boolean stick) {
        this.method = method;
        this.threadMode = threadMode;
        this.type = type;
        this.stick = stick;
    }

    public boolean isStick() {
        return stick;
    }

    public void setStick(boolean stick) {
        this.stick = stick;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public TestThreadMode getThreadMode() {
        return threadMode;
    }

    public void setThreadMode(TestThreadMode threadMode) {
        this.threadMode = threadMode;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}
