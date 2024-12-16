package vn.com.dattb.ssaservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/signHash")
    public void signHash() {
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
