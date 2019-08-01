package com.test.demo.test.volley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.google.gson.Gson;
import com.test.demo.test.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DEV002 on 2018/5/25.
 */

public class VolleyCutomRequestActivity extends AppCompatActivity {



    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_request);
        textView = (TextView) findViewById(R.id.volley_custom_request_tv);
        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
        RequestQueue queue = new RequestQueue(cache,network);
        queue.start();
        Map<String,String> headers = new HashMap<>();
        VolleyCutomRequest request = new VolleyCutomRequest(Request.Method.GET, "", null, headers, new Response.Listener() {
            @Override
            public void onResponse(Object o) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(request);

    }

    class VolleyCutomRequest<T> extends Request<T>{

        private final Gson gson = new Gson();

        private Response.Listener<T> listener;

        private Map<String,String> headers;

        private Class<T> clazz;

        public VolleyCutomRequest(int method, String url, Class<T> clazz,Map<String,String> headers, Response.Listener<T> listener,Response.ErrorListener errorListener) {
            super(method, url, errorListener);
            this.clazz = clazz;
            this.headers = headers;
            this.listener = listener;
        }

        @Override
        protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
            String jsonData = "";
            try {
                jsonData = new String(networkResponse.data,HttpHeaderParser.parseCharset(networkResponse.headers));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.success(gson.fromJson(jsonData,clazz),HttpHeaderParser.parseCacheHeaders(networkResponse));
        }

        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            return (headers != null) ? headers : super.getHeaders();
        }

        @Override
        protected void deliverResponse(T t) {
            listener.onResponse(t);
        }
    }

}
