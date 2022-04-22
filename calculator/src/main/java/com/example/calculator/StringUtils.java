package com.example.calculator;

public final class StringUtils {

    public StringUtils() {
    }

    public static String removeLastElement(String string) {
        StringBuffer trimmedString = new StringBuffer(string);
        trimmedString = trimmedString.deleteCharAt(string.length() - 1);
        return trimmedString.toString();
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
