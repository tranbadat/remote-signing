package vn.com.dattb.coreservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DetailContractRequest is the request class for detail contract
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/11/2025
 * Version: 1.0.0
 * <p>
 * Description: DetailContractRequest is the request class for detail contract
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailContractRequest {
    private String refId;
}
