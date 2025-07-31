package vn.com.dattb.esignservice.dto.enums;

import lombok.Getter;

/**
 * DocumentSecurityLevel
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 7/31/2025
 * Version: 1.0.0
 * <p>
 * Description: DocumentSecurityLevel is the enum class for document security level
 */
@Getter
public enum DocumentSecurityLevel {
    PUBLIC("public"),
    INTERNAL("internal"),
    PRIVATE("private"),
    RESTRICTED("restricted"),
    CONFIDENTIAL("confidential"),
    SECRET("secret"),
    TOP_SECRET("top_secret"),
    UNCLASSIFIED("unclassified");


    private final String value;

    DocumentSecurityLevel(String value) {
        this.value = value;
    }

    public static DocumentSecurityLevel fromValue(String value) {
        for (DocumentSecurityLevel level : DocumentSecurityLevel.values()) {
            if (level.value.equalsIgnoreCase(value)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Unknown DocumentSecurityLevel: " + value);
    }
}
