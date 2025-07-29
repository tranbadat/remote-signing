package vn.com.dattb.esignservice.context;

import lombok.Data;

/**
 * UserContextInfo
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 7/29/2025
 * Version: 1.0.0
 * <p>
 * Description: UserContextInfo is the class for managing user context information
 */
@Data
public class UserContextInfo {
    private String userId;
    private String language;

    public UserContextInfo(String userId, String language) {
        this.userId = userId;
        this.language = language;
    }
}
