package com.mttalker;

import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mttalker.AudioController.AudioPlayer;
import com.mttalker.AudioController.AudioRecorder;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;
    private Button btnRecord;
    private EditText txtServer;
    private AudioPlayer audioPlayer;
    private AudioRecorder audioRecorder;
    private TextView labelLocalIP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup
        labelLocalIP = (TextView) findViewById(R.id.lableLocalIP);
        txtServer = (EditText) findViewById(R.id.txtServerAddress);

        audioPlayer = new AudioPlayer(this, AudioManager.STREAM_MUSIC);
        audioRecorder = new AudioRecorder(this);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioPlayer.preparePlayer(txtServer.getText().toString());
                audioPlayer.play();
            }
        });

        btnRecord = (Button) findViewById(R.id.btnRecord);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioRecorder.starRecording();
            }
        });

    }

    public void setLabelLocalIP(String newValue) {
        labelLocalIP.setText(newValue);
    }
}
