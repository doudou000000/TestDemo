package com.test.demo.test.volley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.test.demo.test.R;

import java.util.Map;

import okhttp3.internal.http.HttpMethod;

/**
 * Created by DEV002 on 2018/5/24.
 */

public class VolleyActivity extends AppCompatActivity {
    public static final String TAG = "MyTag";
    private TextView textView;
    private RequestQueue queue;

    private static final String IMAGE_URL = "http://i9.hexunimg.cn/2013-07-05/155842064.jpg";
    LruCache<String,Bitmap> mCache;

    ImageView imageView;

    NetworkImageView networkImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        textView = (TextView) findViewById(R.id.volley_tv);
        imageView = (ImageView) findViewById(R.id.volley_img);
        networkImageView = (NetworkImageView) findViewById(R.id.volley_net_img);
        queue = Volley.newRequestQueue(VolleyActivity.this);

//        JsonObjectRequest;
//        JsonArrayRequest;
//
//        ImageLoader

        StringRequest request = new StringRequest(Request.Method.POST,"",null,null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

//        StringRequest request = new StringRequest("https://www.baidu.com/?tn=62095104_5_oem_dg", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                textView.setText(s);
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(VolleyActivity.this,volleyError.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        request.setTag(TAG);
        queue.add(request);
//
//        //------------------------------------
//        // Instantiate the cache
//        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
//        // Set up the network to use HttpURLConnection as the HTTP client.
//        Network network = new BasicNetwork(new HurlStack());
//        // Instantiate the RequestQueue with the cache and network.
//        queue = new RequestQueue(cache, network);
//        // Start the queue
//        queue.start();
//        String url ="http://www.myurl.com";
//        // Formulate the request and handle the response.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        textView.setText(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        textView.setText(error.toString());
//                    }
//                });
//// Add the request to the RequestQueue.
//        queue.add(stringRequest);



        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {

                mCache = new LruCache<String,Bitmap>(10 * 1024 * 1024){

                    @Override
                    protected int sizeOf(String key, Bitmap value) {
                        return value.getRowBytes() * value.getHeight();
                    }
                };

                return mCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url,bitmap);
            }
        });

//        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView,R.drawable.occupancy,R.drawable.error);
//
//        imageLoader.get(IMAGE_URL,imageListener);


        networkImageView.setDefaultImageResId(R.drawable.occupancy);
        networkImageView.setErrorImageResId(R.drawable.error);
        networkImageView.setImageUrl(IMAGE_URL,imageLoader);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(queue != null){
            queue.cancelAll(TAG);
        }
    }
}
