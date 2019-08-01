package com.test.demo.test.comment;

import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.comment.recycleview.TestRecycleViewActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestCommentActivity extends BaseActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_test_comment;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    public void testRecycleView(View view){

        IntentUtils.startActivity(this,TestRecycleViewActivity.class);

    }
//    public void testDemo1(View view){
//
//        IntentUtils.startActivity(this,TestAnimationDemo1Activity.class);
//
//    }
//    public void testDemo2(View view){
//
//        IntentUtils.startActivity(this, TestAnimationCloningActivity.class);
//
//    }
//    public void testShapeDrawable(View view){
//
//        IntentUtils.startActivity(this, TestShapeDrawableActivity.class);
//
//    }
//    public void testObjectAnimator(View view){
//
//        IntentUtils.startActivity(this, TestObjectAnimatorActivity.class);
//
//    }
//    public void testAnimatorSet(View view){
//
//        IntentUtils.startActivity(this, TestAnimatorSetActivity.class);
//
//    }
//    public void testAnimatorSet2(View view){
//
//        IntentUtils.startActivity(this, TestAnimatorSet2Activity.class);
//
//    }
//    public void animationLoading(View view){
//
//        IntentUtils.startActivity(this, AnimationLoadingActivity.class);
//
//    }
//    public void testAnimatorTranslation(View view){
//
//        IntentUtils.startActivity(this, TestAnimatorTranslationActivity.class);
//
//    }
//    public void testAnimationSeeking(View view){
//
//        IntentUtils.startActivity(this, TestAnimationSeekingActivity.class);
//
//    }
//    public void testAnimatorEvents(View view){
//
//        IntentUtils.startActivity(this, TestAnimatorEventsActivity.class);
//
//    }
//
//    public void testAnimatorCustomEvaluator(View view){
//
//        IntentUtils.startActivity(this, TestAnimatorCustomEvaluatorActivity.class);
//
//    }
}
