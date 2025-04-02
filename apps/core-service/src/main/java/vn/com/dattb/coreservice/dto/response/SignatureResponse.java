package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SignatureResponse is the response class for signature
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/16/2025
 * Version: 1.0.0
 * <p>
 * Description: SignatureResponse is the response class for signature
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureResponse {
    private String id;
    private String signatureContent;
    private String type;
    private String name;
    private boolean isDefault;
}
