package com.foodapplication.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    private static boolean validMobileNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("([9][678][0-9]{8})");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }

    private static boolean validLandLineNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("(\\d{5}|\\d{6}|\\d{7})");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }

    public static String formatMobileNumber(String phoneNumber) {
        String formattedPhoneNumber;
        if (phoneNumber.length() > 0) {
            formattedPhoneNumber = phoneNumber.replaceAll("\\D+", "");
            formattedPhoneNumber = formattedPhoneNumber.substring(formattedPhoneNumber.length() - 10, formattedPhoneNumber.length());
            if (validMobileNumber(formattedPhoneNumber)) {
                return formattedPhoneNumber;
            }
        }
        return "";
    }

    public static String formatLandLineNumber(String phoneNumber) {
        String formattedPhoneNumber;
        if (phoneNumber.length() > 0) {
            formattedPhoneNumber = phoneNumber.replaceAll("\\D+", "");
            formattedPhoneNumber = formattedPhoneNumber.substring(formattedPhoneNumber.length() - 7, formattedPhoneNumber.length());

            if (validLandLineNumber(formattedPhoneNumber)) {
                return formattedPhoneNumber;
            }
        }
        return "";
    }

    public static boolean validateTelecom(String phoneNumber, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }

    public static boolean validateDate(String value, String x, String y, String z) {
        String a = "[" + x;
        String regex = "(1[9]?[0]?" + a + "-9]?|1[9][1-9]?[0-9]?|2[0]?[0-" + y + "][0-" + z + "]?)-?(0[1-9]?|1[0-2]?)?-?([0-2][1-9]?|3?[0-2]?)?";
        LogUtil.log("Regex", regex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
