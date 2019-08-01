package com.test.demo.test.apiDemo.media;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.test.demo.test.R;
import com.test.demo.test.utils.SharedPreferenceUtils;
import com.test.demo.test.apiDemo.base.BaseActivity;
import com.test.demo.test.apiDemo.media.enity.Music;
import com.test.demo.test.utils.DateFormatUtils;
import com.test.demo.test.utils.StrToDecoder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestMediaPlayerLocalActivity extends BaseActivity implements
        View.OnClickListener, MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener,SeekBar.OnSeekBarChangeListener,MediaPlayer.OnBufferingUpdateListener{

    private String url = "http://192.168.253.1:8080/TestMusic/17.mp3";

    private String sdCard = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "17.mp3";

    private TextView songNameTv,songTimeTv;

    private Button playBtn;

    private SeekBar songTimeProgress;

    private MediaPlayer mediaPlayer;

    private boolean isRun = false;

    private SharedPreferenceUtils sharedPerfrenceUtils;

    private int seekToPosition  = 0;

    private boolean isPlayFinish = false;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mediaPlayer != null){
                songTimeProgress.setProgress(mediaPlayer.getCurrentPosition());
                songTimeTv.setText(DateFormatUtils.format12(mediaPlayer.getCurrentPosition()));
            }
        }
    };

    private List<Music> musicList;

    private MusicIntentReceiver musicIntentReceiver;

    @Override
    public int setLayout() {
        return R.layout.activity_test_media_player_local;
    }
    @Override
    public void initView() {
        musicList = new ArrayList<>();
        songNameTv = (TextView) findViewById(R.id.test_media_player_local_song_name_tv);
        songTimeTv = (TextView) findViewById(R.id.test_media_player_local_time_tv);
        playBtn = (Button) findViewById(R.id.test_media_player_local_play_btn);
        songTimeProgress = (SeekBar) findViewById(R.id.test_media_player_local_time_progress);
        mediaPlayer = new MediaPlayer();
        getUriFromSDCard();
        Uri contentUri = null;
        if(musicList.size() > 0){
            contentUri = ContentUris.withAppendedId(
                    android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, 35035);//musicList.get(0).getId());//35035);
            songNameTv.setText("十七岁");
        }
        try {
            mediaPlayer.setDataSource(this,contentUri);
//            mediaPlayer.setDataSource(sdCard);
//            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sharedPerfrenceUtils = new SharedPreferenceUtils(this,"歌曲播放位置.txt");
        sharedPerfrenceUtils.getSharedPreferences();
        sharedPerfrenceUtils.getEditor();
        seekToPosition = sharedPerfrenceUtils.getInt2File(url,0);

        musicIntentReceiver = new MusicIntentReceiver();
        IntentFilter filter = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
        registerReceiver(musicIntentReceiver,filter);

//        Uri uri = getUriFromSDCard();
//
//        System.out.println("uri====" + uri.toString());

    }

    @Override
    public void initListener() {
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
        playBtn.setOnClickListener(this);
        songTimeProgress.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_media_player_local_play_btn:
                if(mediaPlayer.isPlaying()){
                    isRun = false;
                    mediaPlayer.pause();
                    playBtn.setText("播放");
                }else {
                    mediaPlayer.start();
                    isPlayFinish = false;
                    playBtn.setText("暂停");
                    setProgress();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.i("MediaPlayer","MediaPlayer=getCurrentPosition==" + mp.getDuration());
        songTimeProgress.setMax(mp.getDuration());
        songTimeTv.setText(DateFormatUtils.format12(mp.getDuration()));
        if(seekToPosition == mp.getDuration()){
            seekToPosition = 0;
        }
        mp.seekTo(seekToPosition);
        mp.start();
        playBtn.setText("暂停");
        setProgress();
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
    public boolean onError(MediaPlayer mp, int what, int extra) {

        playBtn.setText("播放");
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            if(isPlayFinish){
                sharedPerfrenceUtils.saveInt2File(url,mediaPlayer.getDuration());
            }else{
                sharedPerfrenceUtils.saveInt2File(url,mediaPlayer.getCurrentPosition());
            }
            mediaPlayer.release();
            mediaPlayer = null;
            isRun = false;
        }
        if(musicIntentReceiver != null){
            unregisterReceiver(musicIntentReceiver);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        isPlayFinish = true;
        playBtn.setText("播放");
        isRun = false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(mediaPlayer != null){
            mediaPlayer.seekTo(seekBar.getProgress());
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        Log.i("MediaPlayer","MediaPlayer=onBufferingUpdate==" + percent);
    }

    class MusicIntentReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context ctx, Intent intent) {
            if (intent.getAction().equals(
                    android.media.AudioManager.ACTION_AUDIO_BECOMING_NOISY)) {
                if(mediaPlayer != null){
                    isRun = false;
                    mediaPlayer.pause();
                    playBtn.setText("播放");
                }
            }
        }
    }

    public void getUriFromSDCard(){
        ContentResolver resolver = getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = resolver.query(uri,null,null,null,null);
        if(cursor == null){
            Toast.makeText(this,"sd卡不存在",Toast.LENGTH_SHORT).show();
        }else if(!cursor.moveToFirst()){
            Toast.makeText(this,"sd卡上没有找到音频文件",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                int title = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                int id = cursor.getColumnIndex(MediaStore.Audio.Media._ID);

                int displayName = cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME);
                int album = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
                int duration = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
                int size = cursor.getColumnIndex(MediaStore.Audio.Media.SIZE);
                int artist = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
                int url = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);

                Music music  = new Music(
                        StrToDecoder.strToDecoder2(cursor.getString(title))
                        ,cursor.getLong(id)
                        , StrToDecoder.strToDecoder2(cursor.getString(displayName))
                        ,StrToDecoder.strToDecoder2(cursor.getString(album))
                        ,cursor.getInt(duration)
                        ,cursor.getLong(size)
                        ,StrToDecoder.strToDecoder2(cursor.getString(artist))
                        ,StrToDecoder.strToDecoder2(cursor.getString(url)));

                musicList.add(music);
            }
        }

    }



}
