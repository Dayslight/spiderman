package com.foodapplication.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorUtil {

    public static String parseJsonError(String json) {
        LogUtil.log("Error Json", json);
        try {
            JSONObject root = new JSONObject(json);
            if (root.has("detail")) {
                return root.getString("detail");
            } else if (root.has("message")) {
                return root.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (json.toLowerCase().contains("failed to connect")) {
            return "Something went wrong. Please, check your internet connection and try again";
        } else {
            return "Something went wrong.";
        }
    }

    public static String parseStringError(String message) {
        LogUtil.log("Error message", message);
        if (message.contains("failed to connect")) {
            return "Something went wrong. Please, check your internet connection and try again";
        }
        return message;
    }
}
