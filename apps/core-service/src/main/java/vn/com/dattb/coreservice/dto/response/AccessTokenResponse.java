package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AccessTokenResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/11/2025
 * Version: 1.0.0
 * <p>
 * Description: AccessTokenResponse is the response class for access token
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessTokenResponse {
    private String accessToken;
    private long expiredIn;
}
