package com.foodapplication.utils;

public class NumberUtil {
    public static Double convertToRupees(Long balance) {
        Double paisa = Double.parseDouble(balance.toString());
        return (paisa / 100);
    }

    public static String convertToPaisa(String balance) {
        Double rupees = Double.parseDouble(balance);
        return (rupees * 1) + "";
    }

    public static Integer addNumber(Object number1, Object number2) {
        Integer num = 0;
        if (number1.toString().length() > 0) {
            num = Integer.parseInt(number1.toString());
        }
        return num + Integer.parseInt(number2.toString());
    }

    public static Integer greaterNumber(Integer first, Integer second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public static Integer smallerNumber(Integer first, Integer second) {
        if (first < second) {
            return first;
        } else {
            return second;
        }
    }
}
