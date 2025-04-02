package vn.com.dattb.coreservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.com.dattb.coreservice.context.ClientContext;
import vn.com.dattb.coreservice.context.TenantContext;
import vn.com.dattb.coreservice.context.UserContext;
import vn.com.dattb.coreservice.dto.response.InitContractResponse;
import vn.com.dattb.coreservice.repository.StorageRepository;
import vn.com.dattb.coreservice.service.UploaderService;
import vn.com.dattb.coreservice.util.StorageUtils;

import static java.util.Objects.isNull;

/**
 * UploaderServiceImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/6/2025
 * Version: 1.0.0
 * <p>
 * Description: UploaderServiceImpl is the service class for uploader service
 */
@Service
@Slf4j
public class UploaderServiceImpl implements UploaderService {

    private final StorageRepository storageRepository;

    public UploaderServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public InitContractResponse uploadFile(MultipartFile file) {
        try {
            if (isNull(file) || file.isEmpty()) {
                log.warn("File is empty");
                throw new IllegalArgumentException("File is empty");
            }
            log.info("Uploading file: {}", file.getOriginalFilename());
            String tenantId = TenantContext.getCurrentTenant();
            String clientId = ClientContext.getCurrentClient();
            String userId = UserContext.getCurrentUser();
            String filePath = StorageUtils.generatePath(tenantId, clientId, userId, file.getOriginalFilename());
            storageRepository.save(filePath, file);
            log.info("Client ID: {}", clientId);
            // Do something
        } catch (Exception e) {
            log.error("Error uploading file", e);
        }
        return InitContractResponse.builder().build();
    }
}
