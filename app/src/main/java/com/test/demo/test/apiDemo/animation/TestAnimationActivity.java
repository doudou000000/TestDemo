package com.test.demo.test.apiDemo.animation;

import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.animation.property.demo.PaowuxianActivity;
import com.test.demo.test.apiDemo.animation.property.demo1.TestAnimationDemo1Activity;
import com.test.demo.test.apiDemo.animation.property.demo2.TestAnimationCloningActivity;
import com.test.demo.test.apiDemo.animation.property.demo2.TestShapeDrawableActivity;
import com.test.demo.test.apiDemo.animation.property.demo3.TestObjectAnimatorActivity;
import com.test.demo.test.apiDemo.animation.property.demo4.TestAnimatorSetActivity;
import com.test.demo.test.apiDemo.animation.property.demo5.TestAnimatorSet2Activity;
import com.test.demo.test.apiDemo.animation.property.demo6.AnimationLoadingActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestAnimationSeekingActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestAnimatorCustomEvaluatorActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestAnimatorEventsActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestAnimatorReverseActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestTransition3dActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestTransitionActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestTransitionShareElementActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestLayoutAnimations1Activity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestLayoutAnimations2Activity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestLayoutAnimations3Activity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestLayoutAnimationsActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestLayoutAnimationsFlipperActivity;
import com.test.demo.test.apiDemo.animation.property.demo7.TestLayoutAnimationsMultiPropertyActivity;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestAnimationActivity extends BaseActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_test_animation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    public void testPaWuXian(View view){

        IntentUtils.startActivity(this,PaowuxianActivity.class);

    }
    public void testDemo1(View view){

        IntentUtils.startActivity(this,TestAnimationDemo1Activity.class);

    }
    public void testDemo2(View view){

        IntentUtils.startActivity(this, TestAnimationCloningActivity.class);

    }
    public void testShapeDrawable(View view){

        IntentUtils.startActivity(this, TestShapeDrawableActivity.class);

    }
    public void testObjectAnimator(View view){

        IntentUtils.startActivity(this, TestObjectAnimatorActivity.class);

    }
    public void testAnimatorSet(View view){

        IntentUtils.startActivity(this, TestAnimatorSetActivity.class);

    }
    public void testAnimatorSet2(View view){

        IntentUtils.startActivity(this, TestAnimatorSet2Activity.class);

    }
    public void animationLoading(View view){

        IntentUtils.startActivity(this, AnimationLoadingActivity.class);

    }
    public void testAnimatorTranslationShareElement(View view){

        IntentUtils.startActivity(this, TestTransitionShareElementActivity.class);

    }
    public void testAnimationSeeking(View view){

        IntentUtils.startActivity(this, TestAnimationSeekingActivity.class);

    }
    public void testAnimatorEvents(View view){

        IntentUtils.startActivity(this, TestAnimatorEventsActivity.class);

    }

    public void testAnimatorCustomEvaluator(View view){

        IntentUtils.startActivity(this, TestAnimatorCustomEvaluatorActivity.class);

    }
    public void testLayoutAnimations(View view){

        IntentUtils.startActivity(this, TestLayoutAnimationsActivity.class);

    }
    public void testLayoutAnimations1(View view){

        IntentUtils.startActivity(this, TestLayoutAnimations1Activity.class);

    }
    public void testLayoutAnimations2(View view){

        IntentUtils.startActivity(this, TestLayoutAnimations2Activity.class);

    }
    public void testLayoutAnimations3(View view){

        IntentUtils.startActivity(this, TestLayoutAnimations3Activity.class);

    }
    public void testLayoutAnimationsFlipper(View view){

        IntentUtils.startActivity(this, TestLayoutAnimationsFlipperActivity.class);

    }
    public void testLayoutAnimationsMultiProperty(View view){

        IntentUtils.startActivity(this, TestLayoutAnimationsMultiPropertyActivity.class);

    }
    public void testTransition(View view){

        IntentUtils.startActivity(this, TestTransitionActivity.class);

    }
    public void testTransition3d(View view){

        IntentUtils.startActivity(this, TestTransition3dActivity.class);

    }
    public void testAnimatorReverse(View view){

        IntentUtils.startActivity(this, TestAnimatorReverseActivity.class);

    }


}
