package vn.com.dattb.signserver.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/**
 * SignaturesRequest.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/8/2024
 * Version: 1.0.0
 * <p>
 * Description:
 * This request illustrates an actual request sent to SAM to sign one or more data to be signed
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignaturesRequest {
    @JsonAlias({"signature_algorithm", "signatureAlgorithm"})
    private String signatureAlgorithm;

    @JsonAlias({"requests"})
    @NotNull
    private List<Request> requests;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        @JsonAlias({"data", "dtbs"})
        @NotNull
        private String dtbs;

        @JsonAlias({"signature_algorithm", "signatureAlgorithm"})
        private String signatureAlgorithm;
    }
}

