package vn.com.dattb.coreservice.dto.request;

import java.util.Map;

/**
 * InitBatchContractRequest is the request class for initializing batch contracts
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/15/2025
 * Version: 1.0.0
 * <p>
 * Description: InitBatchContractRequest is the request class for initializing batch contracts
 */
public class InitBatchContractRequest {
    private Long batchId;
    private String name;
    private String description;
    Map<Long, InitContractRequest> contracts;

}
