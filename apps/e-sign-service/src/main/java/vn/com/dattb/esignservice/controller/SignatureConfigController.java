package vn.com.dattb.esignservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import vn.com.dattb.common.dto.BaseResponse;
import vn.com.dattb.esignservice.dto.request.SignatureConfigRequest;

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
@RequestMapping("/v1/configs/signatures")
public class SignatureConfigController {

    @GetMapping
    BaseResponse<Void> getSignaturesConfig() {
        return new BaseResponse<>("00", "Success");
    }

    @GetMapping("/{id}")
    BaseResponse<Void> getSignaturesConfig(@Valid @PathVariable Long id) {
        return new BaseResponse<>("00", "Success");
    }

    @PostMapping
    BaseResponse<Void> createSignaturesConfig(@Valid @NotNull @RequestBody List<SignatureConfigRequest> request) {
        return new BaseResponse<>("00", "Success");
    }

    @PutMapping("/{id}")
    BaseResponse<Void> updateSignaturesConfig(@Valid @PathVariable Long id,
                                              @Valid @NotNull @RequestBody List<SignatureConfigRequest> request) {
        return new BaseResponse<>("00", "Success");
    }

    @DeleteMapping("/{id}")
    BaseResponse<Void> deleteSignaturesConfig(@Valid @PathVariable Long id) {
        return new BaseResponse<>("00", "Success");
    }

}
