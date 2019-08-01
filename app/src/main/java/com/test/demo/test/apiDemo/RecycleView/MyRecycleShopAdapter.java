package com.test.demo.test.apiDemo.RecycleView;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.demo.test.R;

import java.util.List;

public class MyRecycleShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;

    private List<ShopInfo> shopInfoList;

    private int opened = -1;

    boolean isOpen = false;

    public MyRecycleShopAdapter(Context context, List<ShopInfo> shopInfoList) {
        this.context = context;
        this.shopInfoList = shopInfoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_test_recycle_view_shop_item,parent,false);

        return new MyRecycleShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        ((MyRecycleShopViewHolder)holder).bindView(position,shopInfoList.get(position));

    }

    @Override
    public int getItemCount() {
        return shopInfoList.size();
    }

    class MyRecycleShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView nameTv,useTv,useTipTv,useDataTv,detailTv;

        private RelativeLayout detailRl;

        private ImageView downIv;

        private ViewGroup.LayoutParams lp;

        private int height;


        public MyRecycleShopViewHolder(View itemView) {
            super(itemView);

            nameTv = (TextView) itemView.findViewById(R.id.test_recycle_view_shop_item_name_tv);
            useTv = (TextView) itemView.findViewById(R.id.test_recycle_view_shop_item_use_tv);
            useTipTv = (TextView) itemView.findViewById(R.id.test_recycle_view_shop_item_use_tip_tv);
            useDataTv = (TextView) itemView.findViewById(R.id.test_recycle_view_shop_item_use_data_tv);
            detailTv = (TextView) itemView.findViewById(R.id.test_recycle_view_shop_item_detail_info_tv);
            detailRl = (RelativeLayout) itemView.findViewById(R.id.test_recycle_view_shop_item_detail_info_rl);
            downIv = (ImageView) itemView.findViewById(R.id.test_recycle_view_shop_item_down_iv);
            downIv.setOnClickListener(this);
//            final ViewGroup.LayoutParams lp = detailRl.getLayoutParams();
//            isOpen = false;
//            downIv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ValueAnimator valueAnimator;
//
//                    if(!isOpen){
//                        isOpen = true;
//                        valueAnimator = ValueAnimator.ofFloat(0.0f,1.0f);
//                    }else{
//                        isOpen = false;
//                        valueAnimator = ValueAnimator.ofFloat(1.0f,0.0f);
//                    }
//                    valueAnimator.setDuration(1000);
//                    valueAnimator.setInterpolator(new LinearInterpolator());
//                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            float value = (float) animation.getAnimatedValue();
//                            lp.height = (int) (100 * value);
//                            detailRl.setLayoutParams(lp);
//                        }
//                    });
//                    valueAnimator.start();
//                }
//            });
        }

        public void bindView(int pos, ShopInfo bean) {
            nameTv.setText(bean.getShopName());
            useTv.setText(bean.getIsUse());
            useTipTv.setText(bean.getShopTip());
            useDataTv.setText(bean.getUseData());
            detailTv.setText(bean.getShopDetailInfo().getVersion());

            if (pos == opened){
                detailRl.setVisibility(View.VISIBLE);
            } else{
                detailRl.setVisibility(View.GONE);
            }

        }
        /**
         * item的点击事件
         * @param v
         */
        @Override
        public void onClick(View v) {
            if (opened == getAdapterPosition()) {
                //当点击的item已经被展开了, 就关闭.
                opened = -1;
                notifyItemChanged(getAdapterPosition());
            } else {
                int oldOpened = opened;
                opened = getAdapterPosition();
                notifyItemChanged(oldOpened);
                notifyItemChanged(opened);
            }
        }

    }

}
