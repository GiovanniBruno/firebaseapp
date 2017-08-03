package com.example.admin.firebaseapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withSplashTimeOut(5000)
                .withTargetActivity(activity_login.class)
                .withBackgroundColor(Color.parseColor("#EE4000"))
                .withLogo(R.mipmap.estudante1)
                .withHeaderText("Bem vindo ao APP CLASS")
                .withFooterText("COPYRIGHT 2017")
                .withAfterLogoText("App disponível para alunos");

        config.getHeaderTextView().setTextColor(android.graphics.Color.WHITE);
        config.getFooterTextView().setTextColor(android.graphics.Color.WHITE);
        config.getAfterLogoTextView().setTextColor(android.graphics.Color.WHITE);

        View view = config.create();
        setContentView(view);

    }
}
