package vn.com.dattb.signserver.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * SignatureResponse.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/8/2024
 * Version: 1.0.0
 * <p>
 * Description:
 * This is response include signed data
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureResponse {

    @JsonProperty("signatures")
    private List<String> signatures;

}

