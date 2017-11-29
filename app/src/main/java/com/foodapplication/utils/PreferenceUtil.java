package com.foodapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtil {
    private static SharedPreferences sharedPreference;

    public static SharedPreferences getSharedPreference(Context context) {
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreference;
    }

    public static SharedPreferences.Editor getPreferenceEditor(Context context) {
        if (EmptyUtil.isNotNull(sharedPreference)) {
            return sharedPreference.edit();
        } else {
            return getSharedPreference(context).edit();
        }
    }
}
