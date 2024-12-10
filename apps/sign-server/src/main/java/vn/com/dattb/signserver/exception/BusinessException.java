package vn.com.dattb.signserver.exception;

import lombok.Getter;
import lombok.Setter;
import vn.com.dattb.signserver.enums.ResponseCode;

/**
 * BusinessException.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/10/2024
 * Version: 1.0.0
 * <p>
 * Description: Define the business exception
 */
@Setter
@Getter
public class BusinessException extends RuntimeException{
    protected final ResponseCode error;

    public BusinessException(ResponseCode error, String message) {
        super(message);
        this.error = error;
    }
}
