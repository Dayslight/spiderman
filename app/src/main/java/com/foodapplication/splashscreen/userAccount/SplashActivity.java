package com.foodapplication.splashScreen.userAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.foodapplication.R;
import com.foodapplication.splashScreen.userAccount.owner.signupOwner.SignupOwnerFragment;

import butterknife.BindView;

public class SplashActivity extends AppCompatActivity implements SplashController.View {

    @BindView(R.id.mainContainer)
    FrameLayout mainContainer;

    Fragment fragment;
    FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        fragmentManager = getSupportFragmentManager();
        fragment = new SignupOwnerFragment();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit();

    }
}
