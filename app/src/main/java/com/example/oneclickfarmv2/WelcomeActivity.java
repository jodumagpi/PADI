package com.example.oneclickfarmv2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity  {

    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        videoBG = (VideoView) findViewById(R.id.videoWelcome);
        Uri uri = Uri.parse("android.resource://"
                + getPackageName()
                + "/"
                + R.raw.background1);
        videoBG.setVideoURI(uri);
        videoBG.requestFocus();
        videoBG.start();

        videoBG.setOnPreparedListener((mediaPlayer -> {
            mMediaPlayer = mediaPlayer;
            mMediaPlayer.setLooping(true);
            float videoRatio = (float) mediaPlayer.getVideoWidth() / mediaPlayer.getVideoHeight();
            float screenRatio = videoBG.getWidth() / (float) videoBG.getHeight();
            float scaleX = videoRatio / screenRatio;
            if (scaleX >= 1f) {
                videoBG.setScaleY(1.25f);
            } else {
                videoBG.setScaleY(1f/scaleX);
            }
            if (mCurrentVideoPosition != 0){
                mMediaPlayer.seekTo(mCurrentVideoPosition);
                mMediaPlayer.start();
            }
        }));
    }
}
