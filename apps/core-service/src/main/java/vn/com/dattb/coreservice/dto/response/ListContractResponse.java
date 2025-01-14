package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ListContractResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/14/2025
 * Version: 1.0.0
 * <p>
 * Description: ListContractResponse is the response class for listing all contracts
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListContractResponse {
    private String id;
    private String name;
    private String status;
    private String createdDate;
    private String createdBy;

}
