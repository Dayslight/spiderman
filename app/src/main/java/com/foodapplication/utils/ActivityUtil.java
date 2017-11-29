package com.foodapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.HashMap;

public class ActivityUtil {

    private static Intent intent;

    public static void openActivity(Class className, Activity activity, boolean hasData, HashMap<String, String> data, boolean animate) {
        intent = new Intent(activity, className);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (animate) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }

        if (hasData) {
            for (String key : data.keySet()) {
                intent.putExtra(key, data.get(key));
            }
        }

        activity.startActivity(intent);
    }

    public static void openActivity(Class className, Context context, boolean hasData, HashMap<String, String> data, boolean animate) {
        intent = new Intent(context, className);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (animate) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }

        if (hasData) {
            for (String key : data.keySet()) {
                intent.putExtra(key, data.get(key));
            }
        }

        context.startActivity(intent);
    }


}
