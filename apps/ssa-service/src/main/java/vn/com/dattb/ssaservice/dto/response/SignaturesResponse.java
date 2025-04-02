package vn.com.dattb.ssaservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * OutputSignatures
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for output signature
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignaturesResponse {

    @JsonProperty("signatures")
    private List<String> signatures;

    @JsonProperty("responseID")
    private String responseId;
}
