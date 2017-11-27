package com.foodapplication.splashScreen.userAccount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.foodapplication.R;

public class SplashActivity extends AppCompatActivity implements SplashController.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
