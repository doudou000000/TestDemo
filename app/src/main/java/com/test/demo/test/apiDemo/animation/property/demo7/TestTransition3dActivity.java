package com.test.demo.test.apiDemo.animation.property.demo7;

import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.Rotate3dAnimation;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestTransition3dActivity extends BaseActivity implements AdapterView.OnItemClickListener,View.OnClickListener{

    ListView listView;
    ImageView picIv;
    ViewGroup container;

    // Names of the photos we show in the list
    private static final String[] PHOTOS_NAMES = new String[] {
            "Lyon",
            "Livermore",
            "Tahoe Pier",
            "Lake Tahoe",
            "Grand Canyon",
            "Bodie"
    };

    // Resource identifiers for the photos we want to display
    private static final int[] PHOTOS_RESOURCES = new int[] {
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
            R.drawable.photo6
    };

    @Override
    public int setLayout() {
        return R.layout.activity_test_animation_transition_3d;
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(android.R.id.list);
        container = (ViewGroup) findViewById(R.id.test_animation_transition_3d_container);
        picIv = (ImageView) findViewById(R.id.test_animation_transition_3d_pic);
        ArrayAdapter<String> listData = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,PHOTOS_NAMES);
        listView.setAdapter(listData);

        picIv.setClickable(true);
        picIv.setFocusable(true);
        container.setPersistentDrawingCache(ViewGroup.PERSISTENT_ANIMATION_CACHE);

    }

    @Override
    public void initListener() {
        listView.setOnItemClickListener(this);
        picIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        applyRotation(-1,180,90);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        picIv.setImageResource(PHOTOS_RESOURCES[position]);
        applyRotation(position,0,90);
    }

    private void applyRotation(int position, int start, int end) {

        Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(start,end,container.getWidth()/2,container.getHeight()/2,310.0f,true);
        rotate3dAnimation.setDuration(500);
        rotate3dAnimation.setFillAfter(true);
        rotate3dAnimation.setInterpolator(new AccelerateInterpolator());
        rotate3dAnimation.setAnimationListener(new DisplayNextView(position));
        container.startAnimation(rotate3dAnimation);
    }

    class DisplayNextView implements Animation.AnimationListener{

        private int position;

        public DisplayNextView(int position) {
            this.position = position;
        }

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            container.post(new SwapViews(position));
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    class SwapViews implements Runnable{

        private int position;

        private Rotate3dAnimation rotate3dAnimation;

        public SwapViews(int position) {
            this.position = position;
        }

        @Override
        public void run() {

            if(position > -1){
                picIv.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                rotate3dAnimation = new Rotate3dAnimation(90,180,container.getWidth()/2,container.getHeight()/2,310.0f,true);
            }else{
                picIv.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                rotate3dAnimation = new Rotate3dAnimation(90,0,container.getWidth()/2,container.getHeight()/2,310.0f,true);
            }
            rotate3dAnimation.setDuration(500);
            rotate3dAnimation.setFillAfter(true);
            rotate3dAnimation.setInterpolator(new AccelerateInterpolator());
            container.startAnimation(rotate3dAnimation);
        }
    }

}
