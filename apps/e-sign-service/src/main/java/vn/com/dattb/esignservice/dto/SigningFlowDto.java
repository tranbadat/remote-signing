package vn.com.dattb.esignservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * SignerFlowDto
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 07/31/2025
 * Version: 1.0.0
 * <p>
 * Description: SigningFlowDto is the DTO class for signing flow
 */
@Getter
@Setter
public class SigningFlowDto {
    private List<PartnerFlowDto> partners;
}
