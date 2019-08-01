package com.test.demo.test.apiDemo.animation.property.demo1;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.test.demo.test.R;

import java.util.List;
import java.util.Map;

/**
 * 共享元素
 */
public class TestAnimationDemo1Activity extends Activity {

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

    public static final int[] IDS = {
            R.id.ball,
            R.id.block,
            R.id.ducky,
            R.id.jellies,
            R.id.mug,
            R.id.pencil,
            R.id.scissors,
            R.id.woot,
    };

    public static final String[] NAMES = {
            "ball",
            "block",
            "ducky",
            "jellies",
            "mug",
            "pencil",
            "scissors",
            "woot",
    };

    private ImageView mHero;

    private static final String KEY_ID = "ViewTransitionValues:id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(randomColor()));
        setContentView(R.layout.activity_test_animation_demo_1);
        initView();
    }

    private void initView() {

        String name = getIntent().getStringExtra(KEY_ID);
        mHero = null;
        if(name != null){
            mHero = (ImageView) findViewById(getIdForKey(name));
            setEnterSharedElementCallback(new SharedElementCallback() {
                @Override
                public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                    super.onMapSharedElements(names, sharedElements);
                    sharedElements.put("hero",mHero);
                }
            });
        }

    }

    public static int getIdForKey(String id) {
        return IDS[getIndexForKey(id)];
    }

    public static int getDrawableIdForKey(String id) {
        return DRAWABLES[getIndexForKey(id)];
    }

    public static int getIndexForKey(String id) {
        for (int i = 0; i < NAMES.length; i++) {
            String name = NAMES[i];
            if (name.equals(id)) {
                return i;
            }
        }
        return 2;
    }

    public static int randomColor() {

        int red = (int)(Math.random() * 128);
        int green = (int)(Math.random() * 128);
        int blue = (int)(Math.random() * 128);
        return 0xFF000000 | (red << 16) | (green << 8) | blue;
    }

    public void clicked(View view) {

        mHero = (ImageView) view;
        Intent intent = new Intent(this,TestTransitionAnimationActivity.class);
        intent.putExtra(KEY_ID,mHero.getTransitionName());
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,mHero,"hero");
        startActivity(intent,options.toBundle());
    }
}
