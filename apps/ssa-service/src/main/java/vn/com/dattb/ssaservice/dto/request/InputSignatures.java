package vn.com.dattb.ssaservice.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * InputSignatureHash
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for input signature hash
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InputSignatures {

    @JsonAlias({"credential_id", "credentialId"})
    private String credentialId;

    @JsonAlias({"hashes", "hashes"})
    @NotNull
    private List<String> hashes;

    @JsonAlias({"sad", "SAD"})
    private String SAD;

    @JsonAlias({"hash_algorithm_OID", "hashAlgorithmOID"})
    private String hashAlgorithmOID;

    @JsonAlias({"sign_algo", "signAlgo"})
    private String signAlgo;

    @JsonAlias({"sign_algo_params", "signAlgoParams"})
    private String signAlgoParams;

    @JsonAlias({"operation_mode", "operationMode"})
    private String operationMode = "S";

    @JsonAlias({"validity_period", "validityPeriod"})
    private Integer validityPeriod;

    @JsonAlias({"response_uri", "responseUri"})
    private String responseUri;

    @JsonAlias({"client_data", "clientData"})
    private String clientData;
}
