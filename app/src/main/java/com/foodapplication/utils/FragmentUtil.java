package com.foodapplication.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.foodapplication.helper.FragmentChange;

import java.util.HashMap;

public class FragmentUtil {
    public static void openFragment(Context context, Fragment fragment, boolean replace, boolean addToBackStack, boolean clearBackStack, boolean animate, HashMap<String, String> data) {
        FragmentChange fragmentChange = (FragmentChange) context;
        if (data != null) {
            Bundle bundle = new Bundle();
            for (String key : data.keySet()) {
                bundle.putString(key, data.get(key));
            }
            fragment.setArguments(bundle);
        }
        fragmentChange.replaceFragment(fragment, replace, addToBackStack, clearBackStack, animate);
    }
}
