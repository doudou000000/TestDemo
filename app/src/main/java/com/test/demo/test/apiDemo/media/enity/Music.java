package com.test.demo.test.apiDemo.media.enity;

import android.provider.MediaStore;

public class Music {

    private String title;
    private long id;
    private String displayName;
    private String album;
    private int duration;
    private long size;
    private String artist;
    private String url;

    public Music() {
    }

    public Music(String title, long id, String displayName, String album, int duration, long size, String artist, String url) {
        this.title = title;
        this.id = id;
        this.displayName = displayName;
        this.album = album;
        this.duration = duration;
        this.size = size;
        this.artist = artist;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
