package vn.com.dattb.ssaservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CommitChallengeRequest
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/20/2024
 * Version: 1.0.0
 * <p>
 * Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CommitChallengeRequest {
    private String requestAuth;

    private Boolean confirm;

    private String challengeResponse;
}
