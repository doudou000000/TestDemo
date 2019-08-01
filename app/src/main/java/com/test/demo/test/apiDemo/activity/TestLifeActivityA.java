package com.test.demo.test.apiDemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.media.TestMediaPlayerActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestLifeActivityA extends Activity {

    public static final String TAG = "TEST_LIFE";

    private FloatingActionButton floatingActionButton;

    private boolean isRote = true;

    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_life_a);
        Log.i(TAG,"TestLifeActivityA=====onCreate===" );
        TextView textView = (TextView) findViewById(R.id.test_life_tv);
        textView.setText("我是A,我有Button,来启动B");
        Button btn = (Button) findViewById(R.id.test_life_btn);
        Button dialogBtn = (Button) findViewById(R.id.test_life_dialog_btn);
        dialogBtn.setVisibility(View.VISIBLE);
        btn.setVisibility(View.VISIBLE);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.test_floating_action_button);

        relativeLayout = (RelativeLayout) findViewById(R.id.test_floating_action_button_rl);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRote){
                    isRote = false;
                    relativeLayout.setVisibility(View.VISIBLE);
                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(floatingActionButton,"rotation",0,45);

//                    ObjectAnimator scaleX = ObjectAnimator.ofFloat(relativeLayout, "scaleX", 0, 1f);
                    ObjectAnimator scaleY = ObjectAnimator.ofFloat(relativeLayout, "scaleY", 0, 1f);

                    animatorSet.setDuration(500);
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                    animatorSet.play(rotation).with(scaleY);//.with(scaleX);//两个动画同时开始
                    animatorSet.start();
                }else{
                    isRote = true;

                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(floatingActionButton,"rotation",45,0);

                    ObjectAnimator scaleX = ObjectAnimator.ofFloat(relativeLayout, "scaleX", 1, 0f);
                    ObjectAnimator scaleY = ObjectAnimator.ofFloat(relativeLayout, "scaleY", 1, 0f);

                    animatorSet.setDuration(500);
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                    animatorSet.play(rotation).with(scaleY).with(scaleX);//两个动画同时开始
                    animatorSet.start();
                }

            }
        });
    }

    public void showDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(TestLifeActivityA.this);
        builder.setTitle("弹框").setMessage("测试Activity生命周期").setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"TestLifeActivityA=====onStart===" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"TestLifeActivityA=====onResume===" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"TestLifeActivityA=====onPause===" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"TestLifeActivityA=====onStop===" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"TestLifeActivityA=====onRestart===" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"TestLifeActivityA=====onDestroy===" );
    }

    public void testLifeB(View view) {
        IntentUtils.startActivity(this,TestLifeActivityB.class);
    }
}
