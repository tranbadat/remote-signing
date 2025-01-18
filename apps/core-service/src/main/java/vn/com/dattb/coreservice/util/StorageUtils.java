package vn.com.dattb.coreservice.util;

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

    public static String generatePath(String... paths) {
        StringBuilder path = new StringBuilder();
        for (String p : paths) {
            path.append(p).append("/");
        }
        return path.toString();
    }
}
