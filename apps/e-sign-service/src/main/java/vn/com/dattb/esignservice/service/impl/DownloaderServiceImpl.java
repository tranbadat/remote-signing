package vn.com.dattb.esignservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.dattb.esignservice.entity.tenant.Contract;
import vn.com.dattb.esignservice.repository.StorageRepository;
import vn.com.dattb.esignservice.repository.tenant.ContractRepository;
import vn.com.dattb.esignservice.service.DownloaderService;

/**
 * DownloaderServiceImpl is the service class for downloader service
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/13/2025
 * Version: 1.0.0
 * <p>
 * Description: DownloaderServiceImpl is the service class for downloader service
 */
@Service
@Slf4j
public class DownloaderServiceImpl implements DownloaderService {
    private final StorageRepository storageRepository;
    private final ContractRepository contractRepository;

    public DownloaderServiceImpl(@Qualifier("minioStorageRepository") StorageRepository storageRepository, ContractRepository contractRepository) {
        this.storageRepository = storageRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public byte[] downloadFile(Long id) {
        log.info("Downloading file with ID: {}", id);
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Contract not found"));
        //Check authorization user can access this contract
        return storageRepository.get(contract.getFilePath());
    }
}
