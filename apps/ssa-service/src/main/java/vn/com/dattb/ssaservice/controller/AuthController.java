package vn.com.dattb.ssaservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.ssaservice.service.NotificationService;

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
    private final NotificationService notificationService;

    public AuthController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        try {
            notificationService.sendNotification(
                    "TARGET_DEVICE_TOKEN", // Replace with your target device token
                    "Test Title",
                    "Test Body"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Login from SSA service");
    }

    @PostMapping("/revoke")
    public void revoke() {
    }
}
