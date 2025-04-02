package vn.com.dattb.signserver.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import vn.com.dattb.signserver.enums.ResponseCode;
import vn.com.dattb.signserver.dto.response.BaseResponse;

/**
 * BusinessExceptionHandler.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/10/2024
 * Version: 1.0.0
 * <p>
 * Description: Handle the business exception
 */
@ControllerAdvice
@Slf4j
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse> handleBusinessException(BusinessException ex, WebRequest request) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(
                BaseResponse.builder()
                        .code(ex.getError().getCode())
                        .message(ex.getError().getMessage())
                        .data(ex.getMessage())
                        .build()
                , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalArgumentException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<BaseResponse> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        log.info(ex.getMessage());

        return new ResponseEntity<>(
                BaseResponse.builder()
                        .code(ResponseCode.ERROR.getCode())
                        .message(ex.getMessage())
                        .data(null)
                        .build()
                , HttpStatus.BAD_REQUEST);
    }
}
