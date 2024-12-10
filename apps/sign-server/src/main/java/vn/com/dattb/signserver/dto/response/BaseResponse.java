package vn.com.dattb.signserver.dto.response;

import lombok.*;

/**
 * BaseResponse.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/10/2024
 * Version: 1.0.0
 * <p>
 * Description: The base response for all responses
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
