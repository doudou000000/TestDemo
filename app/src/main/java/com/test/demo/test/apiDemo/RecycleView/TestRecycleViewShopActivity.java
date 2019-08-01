package com.test.demo.test.apiDemo.RecycleView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TestRecycleViewShopActivity extends BaseActivity {

    private List<ShopInfo> shopInfoList;

    private RecyclerView mRecyclerView;

    private MyRecycleShopAdapter mMyRecycleShopAdapter;

    @Override
    public int setLayout() {
        return R.layout.activity_test_recycle_view_shop;
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.test_recycle_view_shop_list);
        shopInfoList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            ShopDetailInfo shopDetailInfo = new ShopDetailInfo("仅限于App" + (i + 1) + "使用");
            ShopInfo shopInfo = new ShopInfo("商品" + (i + 1), "无门槛", "仅限银行卡支付","2018.08-2019.0" + i, shopDetailInfo );
            shopInfoList.add(shopInfo);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyRecycleShopAdapter = new MyRecycleShopAdapter(this,shopInfoList);
        mRecyclerView.setAdapter(mMyRecycleShopAdapter);
        mRecyclerView.getItemAnimator().setChangeDuration(1000);
        mRecyclerView.getItemAnimator().setMoveDuration(1000);
    }

    @Override
    public void initListener() {

    }
}
