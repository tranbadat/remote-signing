package vn.com.dattb.common.dto;

import lombok.Builder;
import lombok.Data;

/**
 * BaseResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/14/2025
 * Version: 1.0.0
 * <p>
 * Description: BaseResponse is the base class for all response
 */
@Data
@Builder
public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public boolean isSuccess() {
        return "00".equals(code);
    }

    public boolean isFail() {
        return !"00".equals(code);
    }

}
