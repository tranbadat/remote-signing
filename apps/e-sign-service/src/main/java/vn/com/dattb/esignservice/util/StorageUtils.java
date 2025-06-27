package vn.com.dattb.esignservice.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * StorageUtils
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/16/2025
 * Version: 1.0.0
 * <p>
 * Description: StorageUtils is the utility class for storage common functions
 */
public class StorageUtils {
    private StorageUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final String TEMP_PATH = "temp/";

    public static String generatePath(String... paths) {
        LocalDateTime now = LocalDateTime.now();
        String year = String.valueOf(now.getYear());
        String month = String.valueOf(now.getMonthValue());
        String day = String.valueOf(now.getDayOfMonth());
        StringBuilder path = new StringBuilder();
        path.append(year).append("/").append(month).append("/").append(day);
        for (String p : paths) {
            if (StringUtils.isBlank(p)) continue; // Skip empty or null paths
            path.append("/");
            path.append(p);
        }
        return path.toString();
    }

    public static String makeLocalTempPath(String path) {
        LocalDateTime now = LocalDateTime.now();
        String year = String.valueOf(now.getYear());
        String month = String.valueOf(now.getMonthValue());
        String day = String.valueOf(now.getDayOfMonth());
        String unique = String.valueOf(System.currentTimeMillis());
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        return TEMP_PATH + year + "/" + month + "/" + day + "/" + unique + "_" + fileName;
    }
}
