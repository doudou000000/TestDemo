package com.test.demo.test.apiDemo.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.test.demo.test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DEV002 on 2018/6/7.
 */

public class TestThreadActivity extends AppCompatActivity {

    /**
     * android提供的三种更新UI的方法
     * Activity.runOnUiThread(Runnable)
     * View.post(Runnable)
     * View.postDelayed(Runnable, long)
     * AsyncTask
     * Handler
     * HanlderThread
     * EventBus
     */

    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_thread);
        imageView = (ImageView) findViewById(R.id.test_thread_iv);
        String url = "https://img-blog.csdn.net/20160903083245762";
        newThread(url);
        EventBus.getDefault().register(this);

//        new DownloadImageTask().execute("url");
    }

    private void newThread(final String url) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetwork(url);
                /**
                 //                 * View.post(Runnable)
                 //                 */
//                imageView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//                /**
//                 * Activity.runOnUiThread(Runnable)
//                 */
//                TestThreadActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
                /**
                 * EventBus
                 */
                EventBus.getDefault().post(new MessageEvent(bitmap));
            }

        }).start();
    }


    private Bitmap loadImageFromNetwork(String url) {
        URL imageUrl;
        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            imageUrl = new URL(url);
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.connect();
            if(conn.getResponseCode() == 200){
                is = conn.getInputStream();
                return BitmapFactory.decodeStream(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }

    class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        /** The system calls this to perform work in a worker thread and
         * delivers it the parameters given to AsyncTask.execute() */
        protected Bitmap doInBackground(String... urls) {
            return loadImageFromNetwork(urls[0]);
        }
        /** The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground() */
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setImageBitmap(MessageEvent messageEvent){
        imageView.setImageBitmap(messageEvent.getBitmap());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
