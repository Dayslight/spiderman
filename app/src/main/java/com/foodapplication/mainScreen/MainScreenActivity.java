package com.foodapplication.mainScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.foodapplication.R;

public class MainScreenActivity extends AppCompatActivity implements MainScreenController.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
}
