package com.test.demo.test.apiDemo.media;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.File;

public class TestMediaPlayerService extends Service implements
        MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener,MediaPlayer.OnBufferingUpdateListener{

    private String url = "http://192.168.253.1:8080/TestMusic/17.mp3";
    private String sdCard = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "17.mp3";

    private MediaPlayer mediaPlayer;


    @Override
    public void onCreate() {
        super.onCreate();
        initView();
        initListener();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    public void initView() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(sdCard);
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initListener() {
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Intent intent = new Intent("com.test.demo.test.apiDemo.media.TestMediaPlayerService");
        intent.putExtra("startPlay",true);
        sendBroadcast(intent);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Binder binder = new MyBinder();
        return binder;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Intent intent = new Intent("com.test.demo.test.apiDemo.media.TestMediaPlayerService");
        intent.putExtra("playCompletion",true);
        sendBroadcast(intent);
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    class MyBinder extends Binder{

        TestMediaPlayerService getService(){
            return TestMediaPlayerService.this;
        }
    }

    public void startMusic(){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }
    public void pauseMusic(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    public void releaseMusic(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public int getCurrentPosition(){
        if(mediaPlayer != null){
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }
    public void setCurrentPosition(int position){
        if(mediaPlayer != null){
            mediaPlayer.seekTo(position);
        }
    }

    public int getMusicDuration(){
        if(mediaPlayer != null){
            return mediaPlayer.getDuration();
        }
        return 0;
    }
    public boolean isPlaying(){
        if(mediaPlayer != null){
            return mediaPlayer.isPlaying();
        }
        return false;
    }
}
