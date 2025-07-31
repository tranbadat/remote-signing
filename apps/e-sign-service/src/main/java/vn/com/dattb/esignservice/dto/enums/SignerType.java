package vn.com.dattb.esignservice.dto.enums;

import lombok.Getter;

/**
 * PartnerType
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 07/31/2025
 * Version: 1.0.0
 * <p>
 * Description: SignerType is the enum class for signer type
 */
@Getter
public enum SignerType {
    SIGNER("Signer"),
    APPROVED("Approve"),
    VIEWER("Viewer"),
    REVIEWER("Reviewer"),
    COLLABORATOR("Collaborator");
    private final String value;

    SignerType(String value) {
        this.value = value;
    }
}
