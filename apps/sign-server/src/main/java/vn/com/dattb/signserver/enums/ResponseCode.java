package vn.com.dattb.signserver.enums;

import lombok.Getter;

/**
 * ResponseCode.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/10/2024
 * Version: 1.0.0
 * <p>
 * Description: Define the response code
 */
@Getter
public enum ResponseCode {
    SUCCESS("0000", "Success"),
    ERROR("9999", "Error");

    private final String code;
    private final String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
