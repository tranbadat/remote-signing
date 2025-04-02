package vn.com.dattb.common.util;

/**
 * CommonUtils
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/5/2025
 * Version: 1.0.0
 * <p>
 * Description: This class is used to define common utility methods
 */
public class CommonUtils {
    private CommonUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Mask the string from start to end with maskChar
     *
     * @param str      the string to be masked
     * @param start    the start index
     * @param end      the end index
     * @param maskChar the mask character
     * @return the masked string
     */
    public static String maskString(String str, int start, int end, char maskChar) {
        if (str == null) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start >= end) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = start; i < end; i++) {
            sb.setCharAt(i, maskChar);
        }
        return sb.toString();
    }

    /**
     * Mask the string from start to end with '*'
     *
     * @param str   the string to be masked
     * @param start the start index
     * @param end   the end index
     * @return the masked string
     */
    public static String maskString(String str, int start, int end) {
        return maskString(str, start, end, '*');
    }

    /**
     * Mask the whole string with '*'
     *
     * @param str the string to be masked
     * @return the masked string
     */
    public static String maskString(String str) {
        return maskString(str, 0, str.length());
    }

    public static boolean non(boolean b) {
        return !b;
    }
}
