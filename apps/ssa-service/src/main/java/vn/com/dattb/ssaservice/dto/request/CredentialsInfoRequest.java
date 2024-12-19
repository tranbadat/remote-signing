package vn.com.dattb.ssaservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InputCredentials
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/18/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for input credentials
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CredentialsInfoRequest {

    private String credentialID;

    private String certificates;

    private Boolean certInfo;

    private Boolean authInfo;

    private String lang;

    private String clientData;
}
