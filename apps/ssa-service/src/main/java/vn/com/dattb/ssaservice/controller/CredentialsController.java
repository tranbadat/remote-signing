package vn.com.dattb.ssaservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/list")
    public String list() {
        return "List credentials";
    }

    @PostMapping("/info")
    public String info() {
        return "Info credentials";
    }

    @PostMapping("/auhorize")
    public String authorize() {
        return "Authorize credentials";
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
