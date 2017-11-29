package com.foodapplication.helper;

import java.util.HashMap;

public class Constants {



    public static final String rootUrl = "";
    public static String socketUrl = "";

    public static final boolean Test = false;

    public final static int REQUEST_CODE_ASK_PERMISSIONS = 123;
    public static final HashMap<Integer, String> MONTH = new HashMap<Integer, String>() {{
        put(1, "Jan");
        put(2, "Feb");
        put(3, "Mar");
        put(4, "Apr");
        put(5, "May");
        put(6, "Jun");
        put(7, "Jul");
        put(8, "Aug");
        put(9, "Sep");
        put(10, "Oct");
        put(11, "Nov");
        put(12, "Dec");
    }};
    public static final HashMap<Integer, String> MONTH_FULL = new HashMap<Integer, String>() {{
        put(1, "January");
        put(2, "February");
        put(3, "March");
        put(4, "April");
        put(5, "May");
        put(6, "June");
        put(7, "July");
        put(8, "August");
        put(9, "September");
        put(10, "October");
        put(11, "November");
        put(12, "December");
    }};
    public static final HashMap<Integer, String> ALPHABET = new HashMap<Integer, String>() {{
        put(0, "A");
        put(1, "B");
        put(2, "C");
        put(3, "D");
        put(4, "E");
        put(5, "F");
        put(6, "G");
        put(7, "H");
        put(8, "I");
        put(9, "J");
        put(10, "K");
        put(11, "L");
        put(12, "M");
        put(13, "N");
        put(14, "O");
        put(15, "P");
        put(16, "Q");
        put(17, "R");
        put(18, "S");
        put(19, "T");
        put(20, "U");
        put(21, "V");
        put(22, "W");
        put(23, "X");
        put(24, "Y");
        put(25, "Z");
    }};
}
