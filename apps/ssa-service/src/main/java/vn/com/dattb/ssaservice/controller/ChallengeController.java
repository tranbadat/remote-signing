package vn.com.dattb.ssaservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.ssaservice.dto.request.CommitChallengeRequest;
import vn.com.dattb.ssaservice.dto.response.SuccessResponse;
import vn.com.dattb.ssaservice.service.ChallengeService;

/**
 * ChallengeController
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/20/2024
 * Version: 1.0.0
 * <p>
 * Description: Controller for handling challenge requests
 */
@RestController
@RequestMapping("/v1/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @RequestMapping("/commit")
    public ResponseEntity<SuccessResponse> commit(@Valid @RequestBody CommitChallengeRequest getChallengeRequest) {
        challengeService.commit(getChallengeRequest);
        return ResponseEntity.ok(new SuccessResponse());
    }
}
