package vn.com.dattb.coreservice.service;

/**
 * DownloaderService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/18/2025
 * Version: 1.0.0
 * <p>
 * Description: DownloaderService is the service class for downloader service
 */
public interface DownloaderService {
    byte[] downloadFile(Long id);
}
