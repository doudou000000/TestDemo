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

public class TestAsyncTaskExecuteActivity extends BaseActivity{

    ProgressBar progressBar1,progressBar2,progressBar3;

    @Override
    public int setLayout() {
        return R.layout.activity_test_async_task_execute;
    }

    @Override
    public void initView() {
        progressBar1 = (ProgressBar) findViewById(R.id.test_async_task_execute_progressbar_1);
        progressBar2 = (ProgressBar) findViewById(R.id.test_async_task_execute_progressbar_2);
        progressBar3 = (ProgressBar) findViewById(R.id.test_async_task_execute_progressbar_3);
    }

    @Override
    public void initListener() {

    }

    public void testAsyncTaskExecuteBeginBtn(View view) {
        for(int i = 0; i < 3; i++){

            AsyncTask asyncTask = new MyAsyncTask((i + 1)).execute();


            asyncTask.cancel(true);
        }
    }

    public void testAsyncTaskExecuteEndBtn(View view) {
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
                    if(isCancelled()){
                        break;
                    }
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
