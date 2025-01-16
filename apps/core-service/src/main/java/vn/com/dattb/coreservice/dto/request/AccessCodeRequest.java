package vn.com.dattb.coreservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AccessCodeRequest
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/16/2025
 * Version: 1.0.0
 * <p>
 * Description: AccessCodeRequest is the request class for access code
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessCodeRequest {
    private String username;
    private String referenceId;
}
