package com.test.retrofitlib;

import com.test.retrofitlib.http.GET;
import com.test.retrofitlib.http.POST;
import com.test.retrofitlib.http.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.regex.Matcher;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class ServiceMethod {

    final okhttp3.Call.Factory callFactory;

    private  HttpUrl baseUrl;
    private  String httpMethod;
    private  String relativeUrl;
    private  boolean hasBody;
    private  ParameterHandler<?>[] parameterHandlers;

    public ServiceMethod(Builder builder) {
        this.callFactory = builder.retrofit.callFactory();
        this.baseUrl = builder.retrofit.baseUrl();
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.hasBody = builder.hasBody;
        this.parameterHandlers = builder.parameterHandlers;
    }

    public Request toRequest(Object[] args) {
        RequestBuilder requestBuilder = new RequestBuilder(httpMethod, baseUrl, relativeUrl, hasBody);

        ParameterHandler<Object>[] handlers = (ParameterHandler<Object>[]) parameterHandlers;

        int argumentCount = args != null ? args.length : 0;
        if (argumentCount != handlers.length) {
            throw new IllegalArgumentException("Argument count (" + argumentCount
                    + ") doesn't match expected count (" + handlers.length + ")");
        }

        for (int p = 0; p < argumentCount; p++) {
            handlers[p].apply(requestBuilder, (String)args[p]);
        }

        return requestBuilder.build();
    }

    public static class Builder {

        private Retrofit retrofit;
        private Method method;

        private Annotation[] methodAnnotations;
        private Annotation[][] parameterAnnotationsArray;
        private Type[] parameterTypes;

        private String httpMethod;
        private boolean hasBody;
        private String relativeUrl;
        ParameterHandler<?>[] parameterHandlers;
        public Builder(Retrofit retrofit, Method method) {
            this.retrofit = retrofit;
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
            this.parameterAnnotationsArray = method.getParameterAnnotations();
            this.parameterTypes = method.getGenericParameterTypes();
        }

        public ServiceMethod build() {

            for(Annotation annotation : methodAnnotations){

                parseMethodAnnotation(annotation);

            }
            int parameterCount = parameterAnnotationsArray.length;
            parameterHandlers = new ParameterHandler<?>[parameterCount];
            for (int p = 0; p < parameterCount; p++) {
                Type parameterType = parameterTypes[p];

                Annotation[] parameterAnnotations = parameterAnnotationsArray[p];

                parameterHandlers[p] = parseParameter(p, parameterType, parameterAnnotations);
            }

            return new ServiceMethod(this);
        }

        private ParameterHandler<?> parseParameter(int p, Type parameterType, Annotation[] parameterAnnotations) {
            ParameterHandler<?> result = null;
            for (Annotation annotation : parameterAnnotations) {
                ParameterHandler<?> annotationAction = parseParameterAnnotation(
                        p, parameterType, parameterAnnotations, annotation);
                result = annotationAction;
            }
            return result;
        }

        private ParameterHandler<?> parseParameterAnnotation(int p, Type parameterType, Annotation[] parameterAnnotations, Annotation annotation) {
            if (annotation instanceof Query) {
                Query query = (Query) annotation;
                String name = query.value();
                boolean encoded = query.encoded();
                return new ParameterHandler.Query<>(name, encoded);
            }
            return null;
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            }else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            }
        }

        private void parseHttpMethodAndPath(String httpMethod, String value, boolean hasBody) {
            this.httpMethod = httpMethod;
            this.hasBody = hasBody;

            if (value.isEmpty()) {
                return;
            }
            this.relativeUrl = value;
        }
    }
}
