package vn.com.dattb.ssaservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.ssaservice.dto.request.CredentialsRequest;
import vn.com.dattb.ssaservice.dto.request.CredentialsAuthorizeRequest;
import vn.com.dattb.ssaservice.dto.request.CredentialsInfoRequest;
import vn.com.dattb.ssaservice.dto.response.CredentialsResponse;
import vn.com.dattb.ssaservice.dto.response.CredentialsAuthorizeResponse;
import vn.com.dattb.ssaservice.dto.response.CredentialsInfoResponse;
import vn.com.dattb.ssaservice.service.CredentialsService;

/**
 * CredentialsController.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/16/2024
 * Version: 1.0.0
 * <p>
 * Description: Controller for credentials
 */
@RestController
@RequestMapping("/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @PostMapping("/list")
    public ResponseEntity<CredentialsResponse> list(@Valid @RequestBody CredentialsRequest credentialsRequest) {
        return ResponseEntity.ok(credentialsService.getCredentialsList(credentialsRequest));
    }

    @PostMapping("/info")
    public ResponseEntity<CredentialsInfoResponse> info(@Valid @RequestBody CredentialsInfoRequest credentialsInfoRequest) {
        return ResponseEntity.ok(credentialsService.getCredentialsInfo(credentialsInfoRequest));
    }

    @PostMapping("/authorize")
    public ResponseEntity<CredentialsAuthorizeResponse> authorize(@Valid @RequestBody CredentialsAuthorizeRequest credentialsAuthorizeRequest) {
        return ResponseEntity.ok(credentialsService.authorize(credentialsAuthorizeRequest));
    }

    @PostMapping("/authorizeCheck")
    public String authorizeCheck() {
        return "Authorize check credentials";
    }

    @PostMapping("/getChallenge")
    public String getChallenge() {
        return "Get challenge credentials";
    }

    @PostMapping("/extendTransaction")
    public String extendTransaction() {
        return "Extend transaction credentials";
    }
}
