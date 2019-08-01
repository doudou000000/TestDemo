package com.test.demo.test.comment.recycleview;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE;

public class TestRecycleViewActivity extends BaseActivity {

    RecyclerView listView;
    List<String> titleList;
    List<String> timeList;
    MyListAdapter listAdapter;
    @Override
    public int setLayout() {
        return R.layout.activity_test_recycle_view;
    }

    @Override
    public void initView() {
        listView = (RecyclerView) findViewById(R.id.test_recycle_view_list);
        initData();
        listAdapter = new MyListAdapter();
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.addItemDecoration(new MyItemDecoration(3));
        listView.setAdapter(listAdapter);

    }

    private void initData() {
        titleList = new ArrayList<>();
        timeList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            titleList.add("我是第" + (i + 1) + "条测试数据");
            if(i < 9){
                timeList.add("2018-7-0" + (i + 1));
            }else{
                timeList.add("2018-7-" + (i + 1));
            }

        }
    }

    @Override
    public void initListener() {
        listView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int count = listView.getChildCount();
                ObjectAnimator animator;
                for(int i = 0; i < count; i++){
                    View child = listView.getChildAt(i);
                    RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
                    MyLayoutLayoutParams params = new MyLayoutLayoutParams(child,lp);
                    if(i == count - 1){
                        lp.bottomMargin = 0;
                    }else{
                        if(newState == SCROLL_STATE_IDLE){
                        lp.bottomMargin = 2;
//                            animator = ObjectAnimator.ofObject(params,"bottom",new IntEvaluator(),15,2).setDuration(300);
                        }else{
//                            animator = ObjectAnimator.ofObject(params,"bottom",new IntEvaluator(),2,15).setDuration(100);
                        lp.bottomMargin = 15;
                        }
//                        animator.start();
                    }
                    child.setLayoutParams(lp);
                }

            }
        });
    }

    class MyListAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(TestRecycleViewActivity.this).inflate(R.layout.activity_test_recycle_view_list_item,parent,false);
            return new MyListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyListViewHolder)holder).titleTv.setText(titleList.get(position));
            ((MyListViewHolder)holder).timeTv.setText(timeList.get(position));
        }

        @Override
        public int getItemCount() {
            return titleList.size();
        }
    }

    class MyListViewHolder extends RecyclerView.ViewHolder{

        TextView titleTv,timeTv;

        public MyListViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.test_recycle_view_list_item_title);
            timeTv = (TextView) itemView.findViewById(R.id.test_recycle_view_list_item_time);
        }
    }

    class MyItemDecoration extends RecyclerView.ItemDecoration{

        private int driveHeight;
        ObjectAnimator animator;
        public MyItemDecoration(int driveHeight) {
            this.driveHeight = driveHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.bottom = driveHeight;
        }
    }

    class MyLayoutLayoutParams{
        RecyclerView.LayoutParams params;
        View child;

        int bottom;

        public MyLayoutLayoutParams(View child, RecyclerView.LayoutParams lp) {
            this.child = child;
            this.params = lp;
        }

        public void setBottom(int bottom){
            this.bottom = bottom;
            params.bottomMargin = bottom;
            child.setLayoutParams(params);
        }

        public int getBottom() {
            return bottom;
        }
    }

}
