package vn.com.dattb.ssaservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SuccessResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/20/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for success response
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SuccessResponse {
    @Builder.Default
    private String code = "00";

    @Builder.Default
    private String message = "success";
}
