package vn.com.dattb.common;

/**
 * Constants
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/27/2024
 * Version: 1.0.0
 * <p>
 * Description: This class is used to define the constants
 */
public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TRACE_ID = "trace_id";
    public static final String TSL_PROTOCOL = "TLSv1.2";
    public static final String PKCS_12 = "PKCS12";

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String X_REQUEST_ID = "X-Request-Id";
    public static final String USER_AGENT = "User-Agent";
    public static final String APPLICATION_JSON = "application/json";
    public static final String AUTHORIZATION = "Authorization";
}
