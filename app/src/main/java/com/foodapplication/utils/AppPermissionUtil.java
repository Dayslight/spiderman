package com.foodapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import com.foodapplication.helper.Constants;

public class AppPermissionUtil {
    public static boolean checkAndroidPermission(Context context, String permission) {
        int res = context.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    public static void askPermission(Activity activity, String permission, String messageBody, MyPermission myPermission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int hasPermission = ContextCompat.checkSelfPermission(activity, permission);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                if (!activity.shouldShowRequestPermissionRationale(permission)) {
                    UserInterfaceUtil.showPermissionInfo(activity, "Grant permission", messageBody, activity, permission);
                    return;
                }
                activity.requestPermissions(new String[]{permission},
                        Constants.REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
            myPermission.onPermission();
        } else {
            myPermission.onPermission();
        }
    }

    /*Interfaces*/

    public interface MyPermission {
        void onPermission();
    }
}
