package com.test.demo.test.apiDemo.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.utils.SharedPreferenceUtils;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.utils.DateFormatUtils;

public class TestMediaPlayerServiceActivity extends BaseActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener{

    private MyServiceConnection serviceConnection;

    private TextView songNameTv,songTimeTv;

    private Button playBtn;

    private SeekBar songTimeProgress;

    private TestMediaPlayerService testMediaPlayerService;

    private boolean isConnectionSucess = false;

    private boolean isRun = false;

    private MyBroadcastReceiver myBroadcastReceiver;

    private SharedPreferenceUtils sharedPerfrenceUtils;
    private boolean isPlayFinish = false;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            songTimeProgress.setProgress(testMediaPlayerService.getCurrentPosition());
            songTimeTv.setText(DateFormatUtils.format12(testMediaPlayerService.getCurrentPosition()));
        }
    };

    @Override
    public int setLayout() {
        return R.layout.activity_test_media_player_local;
    }

    @Override
    public void initView() {
        serviceConnection = new MyServiceConnection();
        Intent mediaService = new Intent(this,TestMediaPlayerService.class);
        bindService(mediaService,serviceConnection,BIND_AUTO_CREATE);
        songNameTv = (TextView) findViewById(R.id.test_media_player_local_song_name_tv);
        songTimeTv = (TextView) findViewById(R.id.test_media_player_local_time_tv);
        playBtn = (Button) findViewById(R.id.test_media_player_local_play_btn);
        songTimeProgress = (SeekBar) findViewById(R.id.test_media_player_local_time_progress);
        IntentFilter intentFilter = new IntentFilter("com.test.demo.test.apiDemo.media.TestMediaPlayerService");
        myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver,intentFilter);
        sharedPerfrenceUtils = new SharedPreferenceUtils(this,"music_progress.txt");
        sharedPerfrenceUtils.getSharedPreferences();
        sharedPerfrenceUtils.getEditor();
    }

    @Override
    public void initListener() {
        playBtn.setOnClickListener(this);
        songTimeProgress.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_media_player_local_play_btn:
                if(isConnectionSucess){
                    isPlayFinish = false;
                    if(testMediaPlayerService.isPlaying()){
                        isRun = false;
                        testMediaPlayerService.pauseMusic();
                        playBtn.setText("播放");
                    }else {
                        testMediaPlayerService.startMusic();
                        playBtn.setText("暂停");
                        setProgress();
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        testMediaPlayerService.setCurrentPosition(seekBar.getProgress());
    }

    class MyServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            TestMediaPlayerService.MyBinder myBinder = (TestMediaPlayerService.MyBinder)service;
            testMediaPlayerService = myBinder.getService();
            isConnectionSucess = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnectionSucess = false;
        }
    }

    class MyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            boolean startPlay = intent.getBooleanExtra("startPlay",false);
            boolean playCompletion = intent.getBooleanExtra("playCompletion",false);
            if(startPlay){
                songTimeProgress.setMax(testMediaPlayerService.getMusicDuration());
                songTimeTv.setText(DateFormatUtils.format12(testMediaPlayerService.getMusicDuration()));
                playBtn.setText("暂停");
                int position = sharedPerfrenceUtils.getInt2File("position",0);
                int max = testMediaPlayerService.getMusicDuration();
                if(position == testMediaPlayerService.getMusicDuration()){
                    testMediaPlayerService.setCurrentPosition(0);
                }else{
                    testMediaPlayerService.setCurrentPosition(position);
                }
                testMediaPlayerService.startMusic();
                setProgress();
            }
            if(playCompletion){
                playBtn.setText("播放");
                isRun = false;
                isPlayFinish = true;
            }
        }
    }
    public void setProgress(){
        isRun = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRun){
                    try {
                        Thread.sleep(100);
                        mHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int progress = testMediaPlayerService.getCurrentPosition();
        int max = testMediaPlayerService.getMusicDuration();
        if(isPlayFinish){
            sharedPerfrenceUtils.saveInt2File("position",max);
        }else{
            sharedPerfrenceUtils.saveInt2File("position",progress);
        }
        testMediaPlayerService.releaseMusic();
        if(isConnectionSucess){
            unbindService(serviceConnection);
        }
    }
}
