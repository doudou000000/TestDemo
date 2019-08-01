package com.test.demo.test.apiDemo.animation.property.demo7;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestTransitionShareElementActivity extends BaseActivity {

    public static final int[] DRAWABLES = {
            R.drawable.ball,
            R.drawable.block,
            R.drawable.ducky,
            R.drawable.jellies,
            R.drawable.mug,
            R.drawable.pencil,
            R.drawable.scissors,
            R.drawable.woot,
    };

    private static final String KEY_ID = "ViewTransitionValues:id";

    private RecyclerView listView;

    private MyListAdapter adapter;

    @Override
    public int setLayout() {
        return R.layout.activity_test_animation_transition_share_element;
    }

    @Override
    public void initView() {
        listView = (RecyclerView) findViewById(R.id.test_animation_translation_list_view);
        listView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyListAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }

    class MyListAdapter extends RecyclerView.Adapter<MyListHolderView>{


        @Override
        public MyListHolderView onCreateViewHolder(ViewGroup parent, int viewType) {

            View myItemView = LayoutInflater.from(TestTransitionShareElementActivity.this).inflate(R.layout.activity_test_animation_transition_share_element_item,parent,false);

            return new MyListHolderView(myItemView);
        }

        @Override
        public void onBindViewHolder(final MyListHolderView holder, final int position) {

            holder.listItemIv.setImageResource(DRAWABLES[position]);
            holder.listItemIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TestTransitionShareElementActivity.this, TestTransitionShareElementDetailActivity.class);
                    intent.putExtra(KEY_ID,DRAWABLES[position]);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(TestTransitionShareElementActivity.this,holder.listItemIv,"share");
                    TestTransitionShareElementActivity.this.startActivity(intent,options.toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return DRAWABLES.length;
        }
    }

    class MyListHolderView extends RecyclerView.ViewHolder{

        ImageView listItemIv;

        public MyListHolderView(View itemView) {
            super(itemView);
            listItemIv = (ImageView) itemView.findViewById(R.id.test_animation_translation_list_item_iv);

        }
    }

}
