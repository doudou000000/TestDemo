package com.test.demo.test.apiDemo.animation.property.demo7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.property.FixedGridLayout;

public class TestLayoutAnimationsFlipperActivity extends Activity {

    private static final String[] LIST_STRINGS_EN = new String[] {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six"
    };
    private static final String[] LIST_STRINGS_FR = new String[] {
            "Un",
            "Deux",
            "Trois",
            "Quatre",
            "Le Five",
            "Six"
    };

    private ListView mEnglishList;
    private ListView mFrenchList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout_animations_flipper);
        initView();
    }

    public void initView() {
        mEnglishList = (ListView) findViewById(R.id.test_layout_animations_flipper_list_en);
        mFrenchList = (ListView) findViewById(R.id.test_layout_animations_flipper_list_fr);

        ArrayAdapter<String> englishAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,LIST_STRINGS_EN);
        ArrayAdapter<String> frenchAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,LIST_STRINGS_FR);

        mEnglishList.setAdapter(englishAdapter);
        mFrenchList.setAdapter(frenchAdapter);
        mFrenchList.setRotationY(-90f);

        Button flipperBtn = (Button) findViewById(R.id.test_layout_animations_flipper_btn);
        flipperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper();
            }
        });

    }

    private void flipper() {
        final ListView visibleList;
        final ListView invisibleList;

        if(mEnglishList.getVisibility() == View.GONE){
            visibleList = mFrenchList;
            invisibleList = mEnglishList;
        }else{
            visibleList = mEnglishList;
            invisibleList = mFrenchList;
        }

        ObjectAnimator visibleAnim = ObjectAnimator.ofFloat(visibleList,"rotationY",0f,90f);
        visibleAnim.setDuration(500);
        visibleAnim.setInterpolator(new AccelerateInterpolator());

        final ObjectAnimator invisibleAnim = ObjectAnimator.ofFloat(visibleList,"rotationY",-90f,0f);
        invisibleAnim.setDuration(500);
        invisibleAnim.setInterpolator(new DecelerateInterpolator());

        visibleAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                visibleList.setVisibility(View.GONE);
                invisibleAnim.start();
                invisibleList.setVisibility(View.VISIBLE);
            }
        });
        visibleAnim.start();
    }

}
