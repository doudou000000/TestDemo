package com.test.demo.test.apiDemo.search.searchDialog;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.demo.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV002 on 2018/6/13.
 */

public class SearchableActivity extends AppCompatActivity implements SearchManager.OnDismissListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //注册SearchManager服务
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        //设置searchDialog消失事件
        searchManager.setOnDismissListener(this);
    }

    public void searchData(View view) {

        onSearchRequested();
    }

    // 重写onSearchRequested方法，除了输入查询的值，还可额外绑定一些数据
    @Override
    public boolean onSearchRequested() {
        // 除了输入查询的值，还可额外绑定一些数据
        Bundle appSearchData = new Bundle();
        appSearchData.putString("KEY", "text");

        startSearch(null, false, appSearchData, false);
        // 必须返回true。否则绑定的数据作废
        return true;
    }

    /**
     * 监听searchDialog消失事件，官方推荐使用OnDismissListener
     */
    @Override
    public void onDismiss() {
        System.out.println("searchDialog消失");
    }


    /**
     * 启动与处理dialog在同一个activity中时使用onNewIntent来接受intent,因为启动模式设置singleTop防止一个activity启动两次
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        if(intent.getAction() == Intent.ACTION_SEARCH){
            String query = intent.getStringExtra(SearchManager.QUERY);
            //做搜索操作
            // doMySearch(query);
        }
    }
}
