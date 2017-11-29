package com.foodapplication.mainScreen.client;

import android.support.v4.app.FragmentManager;

import com.foodapplication.R;
import com.foodapplication.mainScreen.client.order.OrderFragment;
import com.foodapplication.mainScreen.client.profile.ProfileFragment;
import com.foodapplication.mainScreen.client.publicFeed.PublicFeedFragment;

/**
 * Created by bijaybogati on 11/25/17.
 */

public class MainScreenPresenter implements MainScreenController.Presenter {

    MainScreenController.View view;
    ViewPagerAdapter viewPagerAdapter;
    FragmentManager fragmentManager;


    public MainScreenPresenter(MainScreenController.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void navigate(int position) {

    }

    @Override
    public void onResume() {
        setAdapter();
        setIcons();

    }

    @Override
    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;

    }


    private void setIcons() {
        int[] icons = {
                R.drawable.ic_rss_house, R.drawable.ic_order_food,R.drawable.ic_profile
        };

        view.setNavigationIcons(icons);
    }

    private void setAdapter() {

        viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.addFrag(new PublicFeedFragment(), "Feed");
        viewPagerAdapter.addFrag(new OrderFragment(), "Order");
        viewPagerAdapter.addFrag(new ProfileFragment(), "Profile");
        view.setViewpagerAdapter(viewPagerAdapter);
    }

    @Override
    public void onDestroy() {
        view = null;
    }


}
