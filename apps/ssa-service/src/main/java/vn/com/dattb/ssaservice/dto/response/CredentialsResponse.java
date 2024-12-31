package vn.com.dattb.ssaservice.dto.response;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * OutputCredentials
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/18/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for output credentials
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CredentialsResponse {
    @Valid
    @Builder.Default
    private List<String> credentialIDs = new ArrayList<>();

    @Valid
    private List<@Valid CredentialsInfoResponse> credentialInfos;

    private Boolean onlyValid;

}
