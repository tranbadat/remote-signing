package vn.com.dattb.esignservice.context;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

/**
 * UserContext
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/23/2025
 * Version: 1.0.0
 * <p>
 * Description: UserContext is the class for managing the user context
 */
@UtilityClass
public class UserContext {

    private static final ThreadLocal<UserContextInfo> CURRENT_USER = new ThreadLocal<>();

    public static void setCurrentUser(UserContextInfo info) {
        CURRENT_USER.set(info);
    }

    public static UserContextInfo getCurrentUser() {
        return CURRENT_USER.get();
    }

    public static String getCurrentUserId() {
        UserContextInfo userContextInfo = CURRENT_USER.get();
        return userContextInfo != null ? userContextInfo.getUserId() : "anonymous";
    }

    public static String getCurrentLanguage() {
        UserContextInfo userContextInfo = CURRENT_USER.get();
        return userContextInfo != null ? userContextInfo.getLanguage() : null;
    }

    public static void clear() {
        CURRENT_USER.remove();
    }
}
