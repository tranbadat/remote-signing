package vn.com.dattb.coreservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.dattb.common.dto.BaseResponse;
import vn.com.dattb.coreservice.dto.request.InitContractRequest;
import vn.com.dattb.coreservice.dto.response.DetailContractResponse;
import vn.com.dattb.coreservice.dto.response.InitContractResponse;
import vn.com.dattb.coreservice.dto.response.ListContractResponse;

import java.util.List;

/**
 * ContractController
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/14/2025
 * Version: 1.0.0
 * <p>
 * Description: ContractController handles the contract  API
 */
@RestController
@RequestMapping("/v1/contracts")
public class ContractController {

    @PostMapping(
            path = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public BaseResponse<InitContractResponse> initContract(@RequestPart MultipartFile file) {
        return new BaseResponse<>("00", "Success", InitContractResponse.builder()
                .contractId("123").hasSignature(false).build());
    }

    @PostMapping(
            path = "/init",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BaseResponse<InitContractResponse> createContract(@Valid @RequestBody InitContractRequest request) {
        return new BaseResponse<>("00", "Success", InitContractResponse.builder()
                .contractId("123").hasSignature(false).build());
    }

    @PostMapping("/list")
    public BaseResponse<List<ListContractResponse>> listContract() {
        return new BaseResponse<>("00", "Success", List.of(ListContractResponse.builder()
                .id("123").name("Contract 1").status("Draft").createdDate("2025-01-14").createdBy("admin").build()));
    }

    @GetMapping("/{id}")
    public BaseResponse<DetailContractResponse> getContract(@PathVariable String id) {
        return new BaseResponse<>("00", "Success", DetailContractResponse.builder()
                .id("123").name("Contract 1").status("Draft").createdDate("2025-01-14").createdBy("admin").build());
    }

    @PutMapping("/{id}")
    public BaseResponse<DetailContractResponse> updateContract(@PathVariable String id,
                                                               @Valid @RequestBody InitContractRequest request) {
        return new BaseResponse<>("00", "Success", DetailContractResponse.builder()
                .id("123").name("Contract 1").status("Draft").createdDate("2025-01-14").createdBy("admin").build());
    }

    @DeleteMapping("/{id}")
    public BaseResponse<DetailContractResponse> deleteContract(@PathVariable String id) {
        return new BaseResponse<>("00", "Success", DetailContractResponse.builder()
                .id("123").name("Contract 1").status("Draft").createdDate("2025-01-14").createdBy("admin").build());
    }


}
