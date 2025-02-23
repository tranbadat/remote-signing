package vn.com.dattb.coreservice.service;

import org.springframework.web.multipart.MultipartFile;
import vn.com.dattb.coreservice.dto.response.InitContractResponse;

/**
 * UploaderService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/18/2025
 * Version: 1.0.0
 * <p>
 * Description: UploaderService is the service class for uploader service
 */
public interface UploaderService {
    InitContractResponse uploadFile(MultipartFile file);
}
