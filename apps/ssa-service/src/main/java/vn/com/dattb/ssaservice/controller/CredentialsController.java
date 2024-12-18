package vn.com.dattb.ssaservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.ssaservice.dto.request.InputCredentials;
import vn.com.dattb.ssaservice.dto.request.InputCredentialsAuthorize;
import vn.com.dattb.ssaservice.dto.response.OutputCredentials;
import vn.com.dattb.ssaservice.dto.response.OutputCredentialsAuthorize;
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
    public ResponseEntity<OutputCredentials> list(@Valid @RequestBody InputCredentials inputCredentials) {
        return ResponseEntity.ok(credentialsService.getCredentialsList(inputCredentials));
    }

    @PostMapping("/info")
    public String info() {
        return "Info credentials";
    }

    @PostMapping("/authorize")
    public ResponseEntity<OutputCredentialsAuthorize> authorize(@Valid @RequestBody InputCredentialsAuthorize inputCredentialsAuthorize) {
        return ResponseEntity.ok(credentialsService.authorize(inputCredentialsAuthorize));
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
