package com.foodapplication.mainScreen.client;


import android.support.v4.app.FragmentManager;

/**
 * Created by bijaybogati on 11/25/17.
 */

public interface MainScreenController {

    interface View {

        void setNavigationIcons(int icons[]);


        void setViewpagerAdapter(ViewPagerAdapter viewpagerAdapter);


        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        void navigate(int position);

        void onResume();

        void setFragmentManager(FragmentManager fragmentManager);


        void onDestroy();


    }


}
