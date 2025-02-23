package vn.com.dattb.coreservice.exception;

import lombok.Getter;
import vn.com.dattb.common.exception.ResponseCode;

/**
 * ErrorCode
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/23/2025
 * Version: 1.0.0
 * <p>
 * Description:
 */
@Getter
public enum ErrorCode implements ResponseCode {
    SUCCESS("00", "Success"),
    ;

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}

