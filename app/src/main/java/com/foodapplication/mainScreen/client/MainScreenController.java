package com.foodapplication.mainScreen.client;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

/**
 * Created by bijaybogati on 11/25/17.
 */

public interface MainScreenController {

    interface View {

        void navigate(int position);

        void setupViewPager(ViewPager viewPager);

        void setViewpagerAdapter(FragmentManager fragmentManager);

        void setPresenter(Presenter presenter);
    }

    interface Presenter {

    }
}
