package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HistoriesContractResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/12/2025
 * Version: 1.0.0
 * <p>
 * Description: HistoriesContractResponse is the response class for histories contract
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoriesContractResponse {
    private String id;
    private String name;
    private String status;
    private String createdDate;
    private String createdBy;
    private String action;
    private String description;
}
