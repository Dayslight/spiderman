package com.foodapplication.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String getNameIcon(String name) {
        String[] splitName = name.split("\\s+");
        String icon;
        if (splitName.length > 1) {
            String iconName = splitName[0].substring(0, 1) + splitName[splitName.length - 1].substring(0, 1);
            icon = (iconName.toUpperCase());
        } else {
            icon = splitName[0].substring(0, 1).toUpperCase();
        }
        return icon;
    }

    public static String formatBalance(Double balance) {
        return String.format("%.2f", balance);
    }

    public static String getFormattedHint(String hint) {
        return "<small><small>" + hint + "</small></small>";
    }

    public static String replaceIdx(String url, String idx) {
        return url.replaceAll(":.*?/", idx + "/");
    }

    public static String addCommas(String digits) {

        String result = digits;

        if (digits.length() <= 3) return digits;

        for (int i = 0; i < (digits.length() - 1) / 3; i++) {

            int commaPos = digits.length() - 3 - (3 * i);

            result = result.substring(0, commaPos) + "," + result.substring(commaPos);
        }
        return result;
    }

    public static String processNotificationTemplate(String template, JSONObject fillerJson) throws JSONException {
        List<String> keys = new ArrayList<>();
        HashMap<String, String> fillerMap = new HashMap<>();
        Pattern pattern = Pattern.compile("\\{.*?\\}");
        Matcher matcher = pattern.matcher(template);

        while (matcher.find()) {
            keys.add(matcher.group().subSequence(1, matcher.group().length() - 1).toString());
        }

        for (String key : keys) {
            if (EmptyUtil.isNotNull(fillerJson.get(key))) {
                if ("amount".equals(key)) {
                    fillerMap.put("{" + key + "}", NumberUtil.convertToRupees(fillerJson.getLong(key)).toString());
                } else {
                    fillerMap.put("{" + key + "}", fillerJson.getString(key));
                }
            } else {
                fillerMap.put("{" + key + "}", "");
            }
        }

        for (String key : fillerMap.keySet()) {
            template = template.replace(key, fillerMap.get(key));
        }
        return template;
    }

    public static String processBasicTransactionTemplate(String template, String recordJson) throws JSONException {
        List<String> keys = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{.*?\\}");
        HashMap<String, String> fillerMap = new HashMap<>();
        Matcher matcher = pattern.matcher(template);

        while (matcher.find()) {
            keys.add(matcher.group().subSequence(1, matcher.group().length() - 1).toString());
        }

        for (String key : keys) {
            String[] split = key.split("\\.");

            String value = recordJson;
            for (String part : split) {
                JSONObject x = JsonUtil.convertStringToJSONObject(value);
                if ("amount".equals(part)) {
                    value = NumberUtil.convertToRupees(x.getLong(part)).toString();
                } else {
                    value = x.getString(part);
                }
            }

            if (EmptyUtil.isNotNull(value)) {
                fillerMap.put("{" + key + "}", value);
            } else {
                fillerMap.put("{" + key + "}", "");
            }
        }

        for (String key : fillerMap.keySet()) {
            template = template.replace(key, fillerMap.get(key));
        }

        return template;
    }
}