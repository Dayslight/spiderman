package com.foodapplication.mainScreen.client;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.foodapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainScreenActivity extends AppCompatActivity implements MainScreenController.View {


    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    MainScreenController.Presenter presenter ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ButterKnife.bind(this);

        presenter = new MainScreenPresenter(this);

    }


    @Override
    public void navigate(int position) {

    }

    @Override
    public void setupViewPager(ViewPager viewPager) {

    }

    @Override
    public void setViewpagerAdapter(FragmentManager fragmentManager) {

    }

    @Override
    public void setPresenter(MainScreenController.Presenter presenter) {

    }
}
