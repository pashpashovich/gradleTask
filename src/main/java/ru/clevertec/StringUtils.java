package ru.clevertec;

public class StringUtils {

    private StringUtils() {

    }

    public static boolean isPositiveNumber(String str) {
        if (str == null || str.isEmpty())
            return false;
        try {
            double number = Double.parseDouble(str);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}