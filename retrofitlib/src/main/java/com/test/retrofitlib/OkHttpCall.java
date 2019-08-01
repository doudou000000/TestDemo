package com.test.retrofitlib;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpCall implements Call {

    private ServiceMethod serviceMethod;
    private Object[] args;

    okhttp3.Call call;

    public OkHttpCall(ServiceMethod serviceMethod, Object[] args) {
        this.serviceMethod = serviceMethod;
        this.args = args;
        Request request = serviceMethod.toRequest(args);
        call = serviceMethod.callFactory.newCall(request);
    }


    @Override
    public Request request() {
        return call.request();
    }

    @Override
    public Response execute() throws IOException {
        return call.execute();
    }

    @Override
    public void enqueue(Callback responseCallback) {
        call.enqueue(responseCallback);
    }

    @Override
    public void cancel() {
        call.cancel();
    }

    @Override
    public boolean isExecuted() {
        return call.isExecuted();
    }

    @Override
    public boolean isCanceled() {
        return call.isCanceled();
    }

    @Override
    public Call clone() {
        return new OkHttpCall(serviceMethod,args);
    }
}
