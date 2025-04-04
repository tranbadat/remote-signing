package vn.com.dattb.coreservice.repository;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * StorageRepository
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/6/2025
 * Version: 1.0.0
 * <p>
 * Description:
 */
public interface StorageRepository {
    void save(String filePath, MultipartFile file) throws IOException;

    void save(String filePath, byte[] file);

    void delete(String filePath);

    byte[] get(String filePath);
}
