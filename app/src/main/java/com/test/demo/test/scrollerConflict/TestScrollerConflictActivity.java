package com.test.demo.test.scrollerConflict;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.demo.test.R;

import java.util.ArrayList;
import java.util.List;

public class TestScrollerConflictActivity extends AppCompatActivity {

    ListView listView;
    List<String> dataList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scroller_conflict);
        listView = (ListView) findViewById(R.id.test_scroller_conflict_list_view);
        initData();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,dataList);
        listView.setAdapter(adapter);
    }

    private void initData() {
        dataList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            dataList.add("测试数据" + i);
        }
    }
}
