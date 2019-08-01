package com.test.demo.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by DEV002 on 2018/5/21.
 */

public class RecordVideoActivity extends AppCompatActivity {

    public static final int REQUEST_VIDEO_CAPTURE = 0;

    VideoView mVideoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_video);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        MediaController controller = new MediaController(this);//实例化控制器
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);
        dispatchTakeVideoIntent();

    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {

            Uri videoUri = data.getData();
            mVideoView.setVideoURI(videoUri);

        }
    }

}
