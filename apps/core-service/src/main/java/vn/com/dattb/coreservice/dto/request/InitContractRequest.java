package vn.com.dattb.coreservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * InitContractRequest
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/14/2025
 * Version: 1.0.0
 * <p>
 * Description: InitContractRequest is the request class for initializing the document
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InitContractRequest {
    private String name;
    private String description;
    private LocalDateTime effectiveDate;
}
