package vn.com.dattb.coreservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import vn.com.dattb.common.dto.BaseResponse;
import vn.com.dattb.coreservice.dto.request.SignatureConfigRequest;

import java.util.List;

/**
 * ConfigController
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/17/2025
 * Version: 1.0.0
 * <p>
 * Description: ConfigController is the controller class for managing the configuration
 */
@RestController
@RequestMapping("/v1/configs")
public class ConfigController {

    @GetMapping("/signatures")
    BaseResponse<Void> getSignaturesConfig() {
        return new BaseResponse<>("00", "Success");
    }

    @GetMapping("/signatures/{id}")
    BaseResponse<Void> getSignaturesConfig(@Valid @PathVariable Long id) {
        return new BaseResponse<>("00", "Success");
    }

    @PostMapping("/signatures")
    BaseResponse<Void> createSignaturesConfig(@Valid @NotNull @RequestBody List<SignatureConfigRequest> request) {
        return new BaseResponse<>("00", "Success");
    }

    @PutMapping("/signatures/{id}")
    BaseResponse<Void> updateSignaturesConfig(@Valid @PathVariable Long id,
                                              @Valid @NotNull @RequestBody List<SignatureConfigRequest> request) {
        return new BaseResponse<>("00", "Success");
    }

    @DeleteMapping("/signatures/{id}")
    BaseResponse<Void> deleteSignaturesConfig(@Valid @PathVariable Long id) {
        return new BaseResponse<>("00", "Success");
    }

}
