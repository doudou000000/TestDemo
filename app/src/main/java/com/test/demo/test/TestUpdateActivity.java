package com.test.demo.test;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.updatelibrary.TestUpdate;

import java.io.File;
import java.io.IOException;

public class TestUpdateActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_update);
        textView = (TextView) findViewById(R.id.test_update_version_tv);
        textView.setText(getVersionName());
    }
    ///通过PackageInfo得到的想要启动的应用的版本号
    private String getVersionName() {
        PackageInfo pInfo = null;

        try {
            //通过PackageManager可以得到PackageInfo
            PackageManager pManager = getPackageManager();
            pInfo = pManager.getPackageInfo(getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pInfo.versionName;

    }


    public void testUpdate(View view) {

        new MyAsyncTask().execute();
//        new MyDiffAsyncTask().execute();
    }


    class MyAsyncTask extends AsyncTask<Void,Void,File> {

        @Override
        protected File doInBackground(Void... voids) {
            String oldPath =  getApplication().getApplicationInfo().sourceDir;
            String newPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "out.apk";
            String patch = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "patch";
            File file = new File(newPath);
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            TestUpdate.testPatch(oldPath,newPath,patch);
            return file;
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            if(file == null){
                return;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW);

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            } else {
                // 声明需要的临时权限
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                // 第二个参数，即第一步中配置的authorities
                String packageName = getApplication().getPackageName();
                Uri contentUri = FileProvider.getUriForFile(TestUpdateActivity.this, packageName + ".fileprovider", file);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }

    class MyDiffAsyncTask extends AsyncTask<Void,Void,File> {

        @Override
        protected File doInBackground(Void... voids) {
            String oldPath =  Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "old.apk";
            String newPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "new.apk";
            String patch = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "patch";
            File file = new File(patch);
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            TestUpdate.testDiff(oldPath,newPath,patch);
            return null;
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            if(file == null) {
                return;
            }
        }
    }

}
