package com.test.demo.test.apiDemo.animation.property.demo7;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * LayoutAnimation
 */
public class TestLayoutAnimations2Activity extends BaseActivity {

    private RecyclerView listview;

    private MyLayoutAnimation2ListAdapter listAdapter;

    private List<String> dataList;

    @Override
    public int setLayout() {
        return R.layout.activity_test_layout_animations_2;
    }

    @Override
    public void initView() {
        listview = (RecyclerView) findViewById(R.id.test_layout_animation_2_list_view);
        listview.setLayoutManager(new LinearLayoutManager(this));
        //1、android:layoutAnimation="@anim/layout_anim"在布局中设置
        //2、代码中设置LayoutAnimation
////        TranslateAnimation translateAnimation = new TranslateAnimation(100,0,0,0);
////        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
////        AnimationSet animationSet = new AnimationSet(true);
////        animationSet.addAnimation(translateAnimation);
////        animationSet.addAnimation(alphaAnimation);
////        animationSet.setDuration(500);
//        Animation animationSet = AnimationUtils.loadAnimation(this,R.anim.left_anim);
//        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animationSet);
//        layoutAnimationController.setDelay(0.3f);
//        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_REVERSE);
//        listview.setLayoutAnimation(layoutAnimationController);
        initData();
        listAdapter = new MyLayoutAnimation2ListAdapter();
        listview.setAdapter(listAdapter);
    }

    private void initData() {
        dataList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            dataList.add("测试" + i);
        }
    }

    @Override
    public void initListener() {

    }

    class MyLayoutAnimation2ListAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(TestLayoutAnimations2Activity.this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10,0,10,15);
            textView.setTextSize(20);
            textView.setBackgroundColor(Color.RED);
            textView.setLayoutParams(lp);
            return new MyLayoutAnimation2ViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((TextView)(((MyLayoutAnimation2ViewHolder)holder).itemView)).setText(dataList.get(position));
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

    class MyLayoutAnimation2ViewHolder extends RecyclerView.ViewHolder{

        public MyLayoutAnimation2ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
