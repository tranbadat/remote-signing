package vn.com.dattb.coreservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.common.dto.BaseResponse;
import vn.com.dattb.coreservice.dto.request.AccessCodeRequest;
import vn.com.dattb.coreservice.dto.response.AccessCodeResponse;

/**
 * AnonymousController
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/16/2025
 * Version: 1.0.0
 * <p>
 * Description: AnonymousController is the controller for anonymous user
 */
@RestController
@RequestMapping("/v1/anonymous")
public class AnonymousController {

    @PostMapping(
            path = "/access-code",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<AccessCodeResponse> getAccessCode(@Valid @RequestBody AccessCodeRequest request) {
        return new BaseResponse<>("00", "Success", AccessCodeResponse.builder()
                .accessCode("123").build());
    }

}
