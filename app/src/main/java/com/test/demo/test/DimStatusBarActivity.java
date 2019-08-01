package com.test.demo.test;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by DEV002 on 2018/5/29.
 */

public class DimStatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //淡化状态栏
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
        //隐藏状态栏
        if(Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else{
            View decorView1 = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions1 = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView1.setSystemUiVisibility(uiOptions1);
        }
        setContentView(R.layout.activity_dim_system_bar);
        TextView textView = (TextView) findViewById(R.id.dim_system_bar_tv);
        textView.setOutlineProvider(new MyViewOutlineProvider());
        textView.setClipToOutline(true);
//        LinearLayout root = (LinearLayout) findViewById(R.id.dim_system_bar_root);
//        root.setOutlineProvider(new MyViewOutlineProvider());
//        root.setClipToOutline(true);

    }
}
