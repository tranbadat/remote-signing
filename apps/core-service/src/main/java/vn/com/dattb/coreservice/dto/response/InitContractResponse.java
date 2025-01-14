package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InitContractResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/14/2025
 * Version: 1.0.0
 * <p>
 * Description: InitContractResponse is the response class for uploading the document
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InitContractResponse {
    private String contractId;
    private boolean hasSignature;
}
