package vn.com.dattb.coreservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.com.dattb.common.dto.BaseResponse;
import vn.com.dattb.coreservice.dto.request.AccessCodeRequest;
import vn.com.dattb.coreservice.dto.response.AccessCodeResponse;
import vn.com.dattb.coreservice.dto.response.AccessTokenResponse;
import vn.com.dattb.coreservice.service.AnonymousService;

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

    private final AnonymousService anonymousService;

    public AnonymousController(AnonymousService anonymousService) {
        this.anonymousService = anonymousService;
    }

    @PostMapping(
            path = "/access-code",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<AccessCodeResponse> getAccessCode(@Valid @RequestBody AccessCodeRequest request) {
        return new BaseResponse<>("00", "Success", AccessCodeResponse.builder()
                .accessCode("123").build());
    }

    @PostMapping(
            path = "/verify",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<AccessTokenResponse> verifyAccessCode(@Valid @RequestBody AccessCodeRequest request) {
        return new BaseResponse<>("00", "Success", anonymousService.verify(request));
    }

    @PostMapping(
            path = "/contracts/{referenceId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<String> getDocuments(@Valid @PathVariable String referenceId) {
        return new BaseResponse<>("00", "Success", "Document 1, Document 2");
    }

    @PostMapping(
            path = "/contracts/{referenceId}/sign",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<String> signDocument(@Valid @PathVariable String referenceId) {
        return new BaseResponse<>("00", "Success", "Document 1, Document 2");
    }

    @PostMapping(
            path = "/contracts/{referenceId}/download",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<String> downloadDocument(@Valid @PathVariable String referenceId) {
        return new BaseResponse<>("00", "Success", "Document 1, Document 2");
    }

    @PostMapping(
            path = "/contracts/{referenceId}/preview",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<String> previewDocument(@Valid @PathVariable String referenceId) {
        return new BaseResponse<>("00", "Success", "Document 1, Document 2");
    }

}
