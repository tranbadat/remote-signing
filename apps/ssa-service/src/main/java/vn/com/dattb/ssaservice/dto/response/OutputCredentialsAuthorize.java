package vn.com.dattb.ssaservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OutputCredentialsAuthorize
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for output credentials authorize
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OutputCredentialsAuthorize {

    private String SAD;

    private Long expiresIn;
}
