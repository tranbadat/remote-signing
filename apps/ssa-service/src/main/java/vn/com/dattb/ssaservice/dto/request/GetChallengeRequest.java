package vn.com.dattb.ssaservice.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetChallengeRequest
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/19/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for get challenge request
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetChallengeRequest {

    @JsonAlias({"credentialID", "credentialId", "credential_id"})
    private String credentialID;

    @JsonAlias({"authObjectID", "authObjectId", "auth_object_id"})
    private String authObjectID;

}
