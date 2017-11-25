package com.foodapplication.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.foodapplication.R;

public class HomeActivity extends AppCompatActivity implements HomeController.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
