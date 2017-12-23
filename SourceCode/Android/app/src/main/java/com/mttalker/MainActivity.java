package com.mttalker;

import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mttalker.AudioController.AudioPlayer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;
    private AudioPlayer audioPlayer;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup
        btnPlay = (Button) findViewById(R.id.btnPlay);
        final MainActivity weekThis = this;

//        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        audioPlayer = new AudioPlayer(weekThis);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //audioPlayer.execute("http://192.168.1.106/Anh.mp3");

//                if (mediaPlayer.isPlaying()) {
//                    mediaPlayer.pause();
//                } else {
//                    mediaPlayer.start();
//                }

//            mediaPlayer.setDataSource("http://192.168.1.106/Anh.mp3");
                try {
                mediaPlayer.setDataSource("https://www.ssaurel.com/tmp/mymusic.mp3");
                mediaPlayer.prepare();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        try {
                            mp.start();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });




    }

    private void onButtonPlayClicked() {

    }
}
