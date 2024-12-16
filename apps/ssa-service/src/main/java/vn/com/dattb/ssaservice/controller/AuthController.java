package vn.com.dattb.ssaservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/16/2024
 * Version: 1.0.0
 * <p>
 * Description: Controller for handling authentication requests
 */
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @PostMapping("/login")
    public void login() {
    }

    @PostMapping("/revoke")
    public void revoke() {
    }
}
