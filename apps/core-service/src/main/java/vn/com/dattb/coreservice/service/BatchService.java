package vn.com.dattb.coreservice.service;

import org.springframework.web.multipart.MultipartFile;
import vn.com.dattb.coreservice.dto.request.InitBatchContractRequest;
import vn.com.dattb.coreservice.dto.response.UploadBatchResponse;

import java.util.List;

/**
 * BatchService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/18/2025
 * Version: 1.0.0
 * <p>
 * Description: BatchService is the service class for batch contract
 */
public interface BatchService {
    UploadBatchResponse upload(List<MultipartFile> files);

    void initBatchContracts(InitBatchContractRequest request);
}
