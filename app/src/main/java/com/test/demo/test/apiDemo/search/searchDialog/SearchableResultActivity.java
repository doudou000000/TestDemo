package com.test.demo.test.apiDemo.search.searchDialog;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.demo.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV002 on 2018/6/13.
 */

public class SearchableResultActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        listView = (ListView) findViewById(R.id.search_result_list);

        Intent intent = getIntent();
        if(intent.getAction() == Intent.ACTION_SEARCH){
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }

    }
    private void doMySearch(String query) {

        List<String> datas = new ArrayList<>();

        if(query.equals("搜索")){
            for(int i = 0; i < 20; i++){
                datas.add("搜索结果" + i);
            }
            arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_bind_service,R.id.bind_service_tv,datas);
            listView.setAdapter(arrayAdapter);
        }

    }

}
