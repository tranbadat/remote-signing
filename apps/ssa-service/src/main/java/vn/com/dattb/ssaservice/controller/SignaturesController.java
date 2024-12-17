package vn.com.dattb.ssaservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.ssaservice.dto.request.InputSignatures;
import vn.com.dattb.ssaservice.dto.response.OutputSignatures;
import vn.com.dattb.ssaservice.service.SignaturesService;

/**
 * SignaturesController
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/16/2024
 * Version: 1.0.0
 * <p>
 * Description: Controller for handling signature requests
 */
@RestController
@RequestMapping("/v1/signatures")
public class SignaturesController {

    private final SignaturesService signaturesService;

    public SignaturesController(SignaturesService signaturesService) {
        this.signaturesService = signaturesService;
    }

    @PostMapping("/signHash")
    public ResponseEntity<OutputSignatures> signHash(@Valid @RequestBody InputSignatures inputSignatures) {
        return ResponseEntity.ok(signaturesService.signHash(inputSignatures));
    }

    @PostMapping("/signDoc")
    public void signDoc() {
    }

    @PostMapping("/signPolling")
    public void signPolling() {
    }

    @PostMapping("/timestamp")
    public void timestamp() {
    }
}
