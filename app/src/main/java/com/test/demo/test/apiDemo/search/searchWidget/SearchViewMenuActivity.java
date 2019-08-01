package com.test.demo.test.apiDemo.search.searchWidget;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.search.suggestProvider.MySuggestionProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV002 on 2018/6/14.
 */

public class SearchViewMenuActivity extends AppCompatActivity {

    ListView mListView;

    ArrayAdapter<String> mAdapter;

    SearchManager searchManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.search_view_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        TextView textView = (TextView) findViewById(R.id.search_view_toolbar_title);
        textView.setText("测试SearchView");
        mListView = (ListView) findViewById(R.id.search_view_result_list);
        searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search_view).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("搜索");
        //添加搜索按钮，默认false
//        searchView.setSubmitButtonEnabled(true);
        //设置搜索输入框是否打开，true打开,false关闭
//        searchView.setIconified(false);
        //设置搜索输入框总是打开的，默认true显示搜索图标，点击打开
//        searchView.setIconifiedByDefault(false);
        //为SearchRecentSuggestions列表添加按钮
//        searchView.setQueryRefinementEnabled(true);
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        if(intent.getAction() == Intent.ACTION_SEARCH){
            String search = intent.getStringExtra(SearchManager.QUERY);
            List<String> dataList = new ArrayList<>();
            for(int i = 0; i < 20; i++){
                dataList.add(search + i);
            }
            mAdapter = new ArrayAdapter<String>(SearchViewMenuActivity.this,android.R.layout.simple_expandable_list_item_1,android.R.id.text1,dataList);
            mListView.setAdapter(mAdapter);
            //保存最近搜索的信息
            SearchRecentSuggestions searchRecentSuggestions = new SearchRecentSuggestions(SearchViewMenuActivity.this, MySuggestionProvider.AUTHORITY,MySuggestionProvider.MODE);
            searchRecentSuggestions.saveRecentQuery(search,null);
//            suggestions.clearHistory();//清空search历史
        }

    }


}
