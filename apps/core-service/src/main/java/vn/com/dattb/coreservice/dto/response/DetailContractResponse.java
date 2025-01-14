package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DetailContractResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/14/2025
 * Version: 1.0.0
 * <p>
 * Description: DetailContractResponse is the response class for getting detail of a contract
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailContractResponse {
    private String id;
    private String name;
    private String status;
    private String createdDate;
    private String createdBy;

}
