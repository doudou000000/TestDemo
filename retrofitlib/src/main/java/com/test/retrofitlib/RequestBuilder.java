package com.test.retrofitlib;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestBuilder {

    private final String method;

    private final HttpUrl baseUrl;
    private  String relativeUrl;
    private  HttpUrl.Builder urlBuilder;

    private final Request.Builder requestBuilder;
    private final boolean hasBody;
    private FormBody.Builder formBuilder;

    public RequestBuilder(String httpMethod, HttpUrl baseUrl, String relativeUrl, boolean hasBody) {
        this.method = httpMethod;
        this.baseUrl = baseUrl;
        this.relativeUrl = relativeUrl;
        this.requestBuilder = new Request.Builder();
        this.hasBody = hasBody;
        formBuilder = new FormBody.Builder();
    }

    public void addQueryParam(String name, String value, boolean encoded) {
        if (relativeUrl != null) {
            // Do a one-time combination of the built relative URL and the base URL.
            urlBuilder = baseUrl.newBuilder(relativeUrl);
            if (urlBuilder == null) {
                throw new IllegalArgumentException(
                        "Malformed URL. Base: " + baseUrl + ", Relative: " + relativeUrl);
            }
            relativeUrl = null;
        }

        if (encoded) {
            //noinspection ConstantConditions Checked to be non-null by above 'if' block.
            urlBuilder.addEncodedQueryParameter(name, value);
        } else {
            //noinspection ConstantConditions Checked to be non-null by above 'if' block.
            urlBuilder.addQueryParameter(name, value);
        }
    }

    Request build() {
        HttpUrl url;
        HttpUrl.Builder urlBuilder = this.urlBuilder;
        if (urlBuilder != null) {
            url = urlBuilder.build();
        } else {
            // No query parameters triggered builder creation, just combine the relative URL and base URL.
            //noinspection ConstantConditions Non-null if urlBuilder is null.
            url = baseUrl.resolve(relativeUrl);
            if (url == null) {
                throw new IllegalArgumentException(
                        "Malformed URL. Base: " + baseUrl + ", Relative: " + relativeUrl);
            }
        }

        RequestBody body = null;
        if (formBuilder != null) {
            body = formBuilder.build();
        }


        return requestBuilder
                .url(url)
                .method(method,null)
                .build();
    }
}
