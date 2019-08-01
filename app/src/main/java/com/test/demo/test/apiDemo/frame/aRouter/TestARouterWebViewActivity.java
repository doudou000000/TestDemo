package com.test.demo.test.apiDemo.frame.aRouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.demo.test.R;

@Route(path = "/aRouter/TestARouterWebViewActivity")
public class TestARouterWebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_arouter_webview);
        webView = (WebView) findViewById(R.id.test_arouter_web_view);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
