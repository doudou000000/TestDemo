package com.test.demo.test.apiDemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.test.demo.test.R;

import okhttp3.OkHttpClient;

public class TestLifeActivityB extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_life_a);
        Log.i(TestLifeActivityA.TAG,"TestLifeActivityB=====onCreate===" );
        TextView textView = (TextView) findViewById(R.id.test_life_tv);
        textView.setText("我是B,我没有Button");
        Button btn = (Button) findViewById(R.id.test_life_btn);
        Button dialogBtn = (Button) findViewById(R.id.test_life_dialog_btn);
        dialogBtn.setVisibility(View.GONE);
        btn.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TestLifeActivityA.TAG,"TestLifeActivityB=====onStart===" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TestLifeActivityA.TAG,"TestLifeActivityB=====onResume===" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TestLifeActivityA.TAG,"TestLifeActivityB=====onPause===" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TestLifeActivityA.TAG,"TestLifeActivityB=====onStop===" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TestLifeActivityA.TAG,"TestLifeActivityB=====onRestart===" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TestLifeActivityA.TAG,"TestLifeActivityB=====onDestroy===" );
    }
}
