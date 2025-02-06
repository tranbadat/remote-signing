package vn.com.dattb.coreservice.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import vn.com.dattb.coreservice.repository.StorageRepository;

/**
 * S3StorageRepositoriImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/6/2025
 * Version: 1.0.0
 * <p>
 * Description:
 */
@Slf4j
@Repository
public class S3StorageRepositoryImpl implements StorageRepository {
    @Override
    public void save(String filePath, byte[] file) {
        // Save file to S3
    }

    @Override
    public void delete(String filePath) {
        // Delete file from S3
    }

    @Override
    public byte[] get(String filePath) {
        // Get file from S3
        return new byte[0];
    }
}
