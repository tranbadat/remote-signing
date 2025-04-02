package vn.com.dattb.ssaservice.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.dattb.ssaservice.dto.AuthObject;

import java.util.List;

/**
 * InputCredentialsAuthorize
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for input credentials authorize
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CredentialsAuthorizeRequest {

    @JsonAlias({"credential_id", "credentialID"})
    private String credentialID;

    @JsonAlias({"num_signatures", "numSignatures"})
    private Integer numSignatures;

    @Valid
    @JsonAlias({"hashes"})
    private List<String> hashes;

    @JsonAlias({"hash_algorithm_OID", "hashAlgorithmOID"})
    private String hashAlgorithmOID;

    @Valid
    @JsonAlias({"auth_data", "authData"})
    private List<@Valid AuthObject> authData;

    @JsonAlias("description")
    private String description;

    @JsonAlias({"client_data", "clientData"})
    private String clientData;
}
