package vn.com.dattb.ssaservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetChallengeResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/19/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for get challenge response
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetChallengeResponse {

    private String challenge;
}
