package vn.com.dattb.coreservice.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ListContractsRequest
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/14/2025
 * Version: 1.0.0
 * <p>
 * Description: ListContractsRequest is the request class for listing all contracts
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListContractsRequest {

    @Positive(message = "Page must be positive")
    @Min(value = 1, message = "Page must be greater than or equal to 1")
    private int page;

    @Positive(message = "Size must be positive")
    @Min(value = 1, message = "Size must be greater than or equal to 1")
    @Max(value = 100, message = "Size must be less than or equal to 100")
    private int size;

    private String keyword;
}
