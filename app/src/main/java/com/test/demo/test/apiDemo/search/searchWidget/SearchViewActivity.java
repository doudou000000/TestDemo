package com.test.demo.test.apiDemo.search.searchWidget;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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

public class SearchViewActivity extends AppCompatActivity {

    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};
    private SearchView mSearchView;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_layout);
//        //设置背景
//        this.setBackgroundResource(R.drawable.search_bg);
//        //提示文本内容
//        this.setQueryHint("请搜索");
//        //默认展开
//        this.setIconifiedByDefault(false);
//        //去除下划线
//        int plateId = this.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
//        LinearLayout plate = (LinearLayout)this.findViewById(plateId);
//        plate.setBackgroundColor(Color.TRANSPARENT);
//        //设置搜索框EditText
//        int searchPlateId = this.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
//        EditText searchPlate = (EditText)this.findViewById(searchPlateId);
//        //提示文本颜色
//        searchPlate.setHintTextColor(getResources().getColor(R.color.white));
//        searchPlate.setTextColor(Color.WHITE);
//        searchPlate.setBackgroundColor(Color.TRANSPARENT);
//        searchPlate.setGravity(Gravity.CENTER);
//        //设置光标样式
//        try {
//            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
//            f.setAccessible(true);
//            f.set(searchPlate, R.drawable.cursor);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //自定义搜索图标
//        int search_mag_icon_id = this.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
//        ImageView search_mag_icon = (ImageView) this.findViewById(search_mag_icon_id);
//        search_mag_icon.setImageResource(R.drawable.widget_search_icon);
//        search_mag_icon.setScaleType(ImageView.ScaleType.CENTER);
//        //自定义清除图标
//        int search_close_icon_id = this.getContext().getResources().getIdentifier("android:id/search_close_btn", null, null);
//        ImageView search_close_btn = (ImageView) this.findViewById(search_close_icon_id);
//        search_close_btn.setImageResource(R.drawable.widget_search_del);
        mSearchView = (SearchView) findViewById(R.id.search_view_layout_sv);
        mListView = (ListView) findViewById(R.id.search_view_layout_list);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        mListView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText);
                }else{
                    mListView.clearTextFilter();
                }
                return true;
            }
        });


    }




}
