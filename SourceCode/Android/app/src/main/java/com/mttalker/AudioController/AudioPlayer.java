package com.mttalker.AudioController;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

import java.io.IOException;

public class AudioPlayer implements OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;

    public AudioPlayer(Context context, int streamType) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(streamType);
        progressDialog = new ProgressDialog(context);
    }

    public void preparePlayer(String dataSource) {
        try {
            mediaPlayer.setDataSource(dataSource);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    /*
    * OnPreparedListener
    */
    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}