package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AccessCodeResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/16/2025
 * Version: 1.0.0
 * <p>
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessCodeResponse {
    private String accessCode;
    private long expiredIn;
}
