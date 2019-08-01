package com.test.demo.test.apiDemo.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.handler.TestHandlerPostActivity;
import com.test.demo.test.apiDemo.handler.TestHandlerSendActivity;
import com.test.demo.test.utils.IntentUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestAsyncTaskExecuteOnExecutorActivity extends BaseActivity{

    ProgressBar progressBar1,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6;

    public static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    public static Executor exec = new ThreadPoolExecutor(15, 200, 10,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    @Override
    public int setLayout() {
        return R.layout.activity_test_async_task_execute_executor;
    }

    @Override
    public void initView() {
        progressBar1 = (ProgressBar) findViewById(R.id.test_async_task_execute_executor_progressbar_1);
        progressBar2 = (ProgressBar) findViewById(R.id.test_async_task_execute_executor_progressbar_2);
        progressBar3 = (ProgressBar) findViewById(R.id.test_async_task_execute_executor_progressbar_3);
        progressBar4 = (ProgressBar) findViewById(R.id.test_async_task_execute_executor_progressbar_4);
        progressBar5 = (ProgressBar) findViewById(R.id.test_async_task_execute_executor_progressbar_5);
        progressBar6 = (ProgressBar) findViewById(R.id.test_async_task_execute_executor_progressbar_6);

        int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;

        Log.i("MyAsyncTask", "==CPU_COUNT==" + CPU_COUNT);
        Log.i("MyAsyncTask", "==CORE_POOL_SIZE==" + CORE_POOL_SIZE);
        Log.i("MyAsyncTask", "==MAXIMUM_POOL_SIZE==" + MAXIMUM_POOL_SIZE);
    }

    @Override
    public void initListener() {

    }

    public void testAsyncTaskExecuteExecutorBeginBtn(View view) {

        for(int i = 0; i < 150; i++){
//            new MyAsyncTask((i + 1)).executeOnExecutor(singleThreadExecutor);
//            new MyAsyncTask((i + 1)).executeOnExecutor(cachedThreadPool);
//            new MyAsyncTask((i + 1)).executeOnExecutor(fixedThreadPool);
//            new MyAsyncTask((i + 1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            new MyAsyncTask((i + 1)).executeOnExecutor(exec);
        }
    }

    public void testAsyncTaskExecuteExecutorEndBtn(View view) {
        IntentUtils.startActivity(this,TestHandlerSendActivity.class);
    }

    class MyAsyncTask extends AsyncTask<Void,Integer,Boolean>{

        private int tag;

        public MyAsyncTask(int tag) {
            this.tag = tag;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            try{

                for(int i = 0; i < 100; i++){
                    Thread.sleep(100);
                    publishProgress((i + 1));
                }
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            switch (tag){
                case 1:
                    progressBar1.setProgress(values[0]);
                    break;
                case 2:
                    progressBar2.setProgress(values[0]);
                    break;
                case 3:
                    progressBar3.setProgress(values[0]);
                    break;
                case 4:
                    progressBar4.setProgress(values[0]);
                    break;
                case 5:
                    progressBar5.setProgress(values[0]);
                    break;
                case 6:
                    progressBar6.setProgress(values[0]);
                    break;
                    default:
                        break;
            }

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                Log.i("MyAsyncTask",tag + "===加载完成");
            }else{
                Log.i("MyAsyncTask",tag + "===加载失败");
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

}
