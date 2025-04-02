package vn.com.dattb.coreservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * SignerFlowDto
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 3/3/2025
 * Version: 1.0.0
 * <p>
 * Description: SignerFlowDto is the DTO class for signer flow
 */
@Getter
@Setter
public class SignerFlowDto {
    private Long id;
    private String name;
    private String email;
    private Long partnerId;
}
