package ru.clevertec;

public class Utils {
    private Utils() {

    }

    public static boolean isAllPositiveNumbers(String... strs) {
        for (String str : strs) {
            if (!StringUtils.isPositiveNumber(str)) {
                return false;
            }
        }
        return true;
    }
}
