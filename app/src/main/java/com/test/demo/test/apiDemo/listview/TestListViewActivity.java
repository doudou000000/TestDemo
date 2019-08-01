package com.test.demo.test.apiDemo.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TestListViewActivity extends BaseActivity {

    private List<String> dataList;

    private ListView listView;

    private MyAdapter myAdapter;

    @Override
    public int setLayout() {
        return R.layout.activity_test_list_view;
    }

    @Override
    public void initView() {
        listView = (ListView)findViewById(R.id.test_list_view_list);
        dataList = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            dataList.add("我是第" + i + "数据");
        }
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
    }

    @Override
    public void initListener() {

    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null){
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(TestListViewActivity.this).inflate(R.layout.activity_test_recycle_view_item,null);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.test_list_view_list_item_tv);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.textView.setText(dataList.get(position));

            return convertView;
        }
    }

    class ViewHolder{
        TextView textView;
    }

}
