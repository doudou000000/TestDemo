package com.test.demo.test.apiDemo.animation.property.demo7;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestTransitionActivity extends BaseActivity {

    LinearLayout container;
    Scene scene_1,scene_2,scene_3;
    TransitionManager transitionManager;
    @Override
    public int setLayout() {
        return R.layout.activity_test_animation_transition;
    }

    @Override
    public void initView() {
        container = (LinearLayout) findViewById(R.id.test_animation_transition_scene_root_view);
        scene_1 = Scene.getSceneForLayout(container,R.layout.activity_test_animation_transition_scene_1,this);
        scene_2 = Scene.getSceneForLayout(container,R.layout.activity_test_animation_transition_scene_2,this);
        scene_3 = Scene.getSceneForLayout(container,R.layout.activity_test_animation_transition_scene_3,this);
        transitionManager = TransitionInflater.from(this).inflateTransitionManager(R.transition.transitions_mgr,container);
    }

    public void selectScene(View view){
        switch (view.getId()){

            case R.id.test_animation_transition_scene_1_rb:
                transitionManager.transitionTo(scene_1);
                break;
            case R.id.test_animation_transition_scene_2_rb:
                transitionManager.transitionTo(scene_2);
                break;
            case R.id.test_animation_transition_scene_3_rb:
                transitionManager.transitionTo(scene_3);
                break;
            case R.id.test_animation_transition_scene_4_rb:
                TransitionManager.beginDelayedTransition(container);
                setNewSize(R.id.test_animation_transition_scene_1_view1,150,25);
                setNewSize(R.id.test_animation_transition_scene_1_view2,150,25);
                setNewSize(R.id.test_animation_transition_scene_1_view3,150,25);
                setNewSize(R.id.test_animation_transition_scene_1_view4,150,25);
                break;
            default:
                break;

        }
    }

    private void setNewSize(int id, int width, int height) {
        View view = findViewById(id);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = width;
        lp.height = height;
        view.setLayoutParams(lp);
    }

    @Override
    public void initListener() {

    }
}
