package com.test.demo.test;

public class TestBean {

    private String  reason;

    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "reason='" + reason + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
