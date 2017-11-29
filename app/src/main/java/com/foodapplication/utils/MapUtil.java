package com.foodapplication.utils;

import java.util.HashMap;

public class MapUtil {

    public static HashMap<String, Object> getSubscriptionMap(String url) {
        HashMap<String, Object> stringMap = new HashMap<>();
        stringMap.put("type", "subscribe");
        stringMap.put("params", new Object());
        stringMap.put("url", url);

        return stringMap;
    }

    public static HashMap<String, Object> getUnSubscriptionMap(String url) {
        HashMap<String, Object> stringMap = new HashMap<>();
        stringMap.put("type", "unsubscribe");
        stringMap.put("params", new Object());
        stringMap.put("url", url);
        return stringMap;
    }
}
