package com.foodapplication.helper;

import android.support.v4.app.Fragment;

public interface FragmentChange {
    void replaceFragment(Fragment fragment, boolean replace, boolean addToBackStack, boolean clearBackStack, boolean animate);
}
