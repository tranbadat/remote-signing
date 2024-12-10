package vn.com.dattb.signserver.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.signserver.dto.request.SignaturesRequest;
import vn.com.dattb.signserver.dto.response.SignatureResponse;
import vn.com.dattb.signserver.service.SignaturesService;

/**
 * SignaturesController.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/8/2024
 * Version: 1.0.0
 * <p>
 * Description:
 * This controller is used to sign the data that needs to be signed
 */
@RestController
@RequestMapping("/v1/signatures")
public class SignaturesController {

    private final SignaturesService signaturesService;

    public SignaturesController(SignaturesService signaturesService) {
        this.signaturesService = signaturesService;
    }

    @PostMapping
    ResponseEntity<SignatureResponse> sign(@Valid @RequestBody SignaturesRequest request) {
        return ResponseEntity.ok(signaturesService.sign(request));
    }
}
