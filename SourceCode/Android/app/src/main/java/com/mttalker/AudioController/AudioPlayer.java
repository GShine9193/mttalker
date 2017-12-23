package com.mttalker.AudioController;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;

public class AudioPlayer extends AsyncTask <String, Void, Boolean> {

    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;

    public AudioPlayer(Context context) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        progressDialog = new ProgressDialog(context);
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        Boolean prepared = false;

        try {
            System.out.println("@@@" + strings[0]);
            mediaPlayer.setDataSource(strings[0]);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });

            mediaPlayer.prepare();
            prepared = true;

        } catch (Exception e) {
            System.out.println("MyAudioStreamingApp: " + e.getMessage());
            e.printStackTrace();
            prepared = false;
        }

        return prepared;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog.setMessage("Buffering...");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        if (progressDialog.isShowing()) {
            progressDialog.cancel();
        }

        mediaPlayer.start();
    }
}