package com.test.retrofitlib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class Retrofit {
    private HttpUrl baseUrl;
    private Call.Factory callFactory;

    private Map<Method,ServiceMethod> serviceMethodMapCache = new ConcurrentHashMap<>();

    public Retrofit(HttpUrl baseUrl, Call.Factory callFactory) {

        this.baseUrl = baseUrl;

        this.callFactory = callFactory;

    }

    public HttpUrl baseUrl() {
        return baseUrl;
    }

    public Call.Factory callFactory() {
        return callFactory;
    }


    public <T> T create(Class<T> clazz){

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ServiceMethod serviceMethod = loadServiceMethod(method);
                return new OkHttpCall(serviceMethod, args);
            }
        });

    }

    private ServiceMethod loadServiceMethod(Method method) {
        ServiceMethod serviceMethod = serviceMethodMapCache.get(method);
        if(serviceMethod != null){
            return serviceMethod;
        }
        synchronized (serviceMethodMapCache){

            serviceMethod = serviceMethodMapCache.get(method);

            if(serviceMethod == null){

                serviceMethod = new ServiceMethod.Builder(this,method).build();

                serviceMethodMapCache.put(method,serviceMethod);

            }
        }
        return serviceMethod;
    }

    public static class Builder{

        private HttpUrl baseUrl;

        private Call.Factory factory;

        public Builder() {
        }

        public Builder baseUrl(String baseUrl){
            HttpUrl httpUrl = HttpUrl.parse(baseUrl);

            if(httpUrl == null){
                throw new IllegalArgumentException("Illegal URL: " + baseUrl);
            }

            return baseUrl(httpUrl);

        }

        private Builder baseUrl(HttpUrl httpUrl) {

            this.baseUrl = httpUrl;

            return this;
        }

        public Builder callFactory(Call.Factory factory){
            this.factory = factory;
            return this;

        }


        public Retrofit build(){

            if (baseUrl == null) {
                throw new IllegalStateException("Base URL required.");
            }

            okhttp3.Call.Factory callFactory = this.factory;
            if (factory == null) {
                factory = new OkHttpClient();
            }

            return new Retrofit(baseUrl,factory);
        }

    }

}
