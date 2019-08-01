package com.test.demo.test.apiDemo.Loader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/1.
 */

public class CursorLoaderActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_loader);
        getSupportFragmentManager().beginTransaction().replace(R.id.cursor_loader_container,new CursorLoaderListFragment()).commit();
    }
}
