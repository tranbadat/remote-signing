package vn.com.dattb.coreservice.dto;

import lombok.Getter;
import lombok.Setter;
import vn.com.dattb.coreservice.PartnerType;

/**
 * PartnerFlowDto
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 3/3/2025
 * Version: 1.0.0
 * <p>
 * Description: PartnerFlowDto is the DTO class for partner flow
 */
@Getter
@Setter
public class PartnerFlowDto {
    private Long id;
    private String name;
    private PartnerType partnerType;
}
