package com.test.demo.test.apiDemo.Loader;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV002 on 2018/6/1.
 */

//public class CursorLoaderListFragment extends ListFragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{
//
//    SimpleCursorAdapter adapter;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        adapter = new SimpleCursorAdapter(getActivity(),android.R.layout.simple_list_item_1,null,new String[]{ ContactsContract.Contacts.DISPLAY_NAME},new int[]{android.R.id.text1},0);
//        setListAdapter(adapter);
//        getLoaderManager().initLoader(0,null, CursorLoaderListFragment.this);
//    }
//
//
//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        return new CursorLoader(getActivity(), ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.Contacts._ID},null,null,null);
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//
//        adapter.swapCursor(data);
//
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//
//        adapter.swapCursor(null);
//
//    }
public class CursorLoaderListFragment extends ListFragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<List<String>>{

    MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new MyAdapter(new ArrayList<String>());
        setListAdapter(adapter);
        getLoaderManager().initLoader(1,null, CursorLoaderListFragment.this);
    }

    @Override
    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
        return new MyLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
        adapter.setDatas(data);
    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {

        adapter.setDatas(new ArrayList<String>());

    }


    static class MyLoader extends AsyncTaskLoader<List<String>>{

        private List<String> datas;

        public MyLoader(Context context) {
            super(context);
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            if(datas != null){
                deliverResult(datas);
            }else{
                forceLoad();
            }
        }



        @Override
        public List<String> loadInBackground() {

            List<String> stringList = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                stringList.add("测试Loader" + (i + 1));
            }
            return stringList;
        }
    }


    class MyAdapter extends BaseAdapter{

        List<String> datas;

        public MyAdapter(List<String> datas) {
            this.datas = datas;
        }

        public void setDatas(List<String> datas) {
            this.datas = datas;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
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
                convertView = LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
                viewHolder.textView = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.textView.setText(datas.get(position));
            return convertView;
        }
    }

    class ViewHolder{

        TextView textView;

    }

}
