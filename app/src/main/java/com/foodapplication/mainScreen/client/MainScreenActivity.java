package com.foodapplication.mainScreen.client;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
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
    MainScreenController.Presenter presenter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ButterKnife.bind(this);

        presenter = new MainScreenPresenter(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setFragmentManager(getSupportFragmentManager());
        presenter.onResume();
    }


    @Override
    public void setNavigationIcons(int icons[]) {
        for (int i = 0; i < icons.length; i++) {
            tabs.getTabAt(i).setIcon(icons[i]);

        }

    }


    @Override
    public void setViewpagerAdapter(ViewPagerAdapter viewpagerAdapter) {

        viewpager.setAdapter(viewpagerAdapter);
        tabs.setupWithViewPager(viewpager);


    }


    @Override
    public void setPresenter(MainScreenController.Presenter presenter) {
        this.presenter = presenter;


    }
}
