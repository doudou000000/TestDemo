package com.test.demo.test;


import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class TestProxy {

    interface DREAM {

        @GET("/dream/query")
        Call<ResponseBody> get(@Query("q") String q, @Query("key") String key);

        @POST("/dream/query")
        Call<ResponseBody> post(@Query("q") String q,@Query("key") String key);

    }

    @Test
    public void testProxy(){
        DREAM dream = (DREAM) Proxy.newProxyInstance(DREAM.class.getClassLoader(), new Class[]{DREAM.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Annotation[] methodAnnotations = method.getAnnotations();
                Type[] parameterTypes = method.getGenericParameterTypes();
                Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();
                Type returnType = method.getGenericReturnType();
                Type responseType = getCallResponseType(returnType);
                return proxy;
            }
        });
        dream.get("123","456");
    }

    Type getCallResponseType(Type returnType) {
        if (!(returnType instanceof ParameterizedType)) {
            throw new IllegalArgumentException(
                    "Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        return getParameterUpperBound(0, (ParameterizedType) returnType);
    }

    Type getParameterUpperBound(int index, ParameterizedType type) {
        Type[] types = type.getActualTypeArguments();
        if (index < 0 || index >= types.length) {
            throw new IllegalArgumentException(
                    "Index " + index + " not in range [0," + types.length + ") for " + type);
        }
        Type paramType = types[index];
        if (paramType instanceof WildcardType) {
            return ((WildcardType) paramType).getUpperBounds()[0];
        }
        return paramType;
    }
}
