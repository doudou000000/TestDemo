package com.test.demo.test.apiDemo.media;

import android.view.View;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.utils.IntentUtils;

public class TestMediaPlayerActivity extends BaseActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_test_media_player;
    }

    @Override
    public void initView() {

    }

    public void testMediaPlayerLocal(View view){

        IntentUtils.startActivity(this,TestMediaPlayerLocalActivity.class);

    }


    public void testMediaPlayerService(View view){

        IntentUtils.startActivity(this,TestMediaPlayerServiceActivity.class);

    }


    @Override
    public void initListener() {

    }
}
