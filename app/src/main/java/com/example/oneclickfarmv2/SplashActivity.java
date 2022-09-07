package com.example.oneclickfarmv2;

import androidx.appcompat.app.AppCompatActivity;
import gr.net.maroulis.library.EasySplashScreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(WelcomeActivity.class)
                .withSplashTimeOut(1000)
                .withBackgroundResource(R.drawable.splash);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        View mySplashScreen = config.create();
        setContentView(mySplashScreen);

    }
}