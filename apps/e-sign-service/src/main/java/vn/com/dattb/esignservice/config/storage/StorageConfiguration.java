package vn.com.dattb.esignservice.config.storage;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.com.dattb.esignservice.config.properties.MinioStorageProperties;

/**
 * MinioClientImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 6/27/2025
 * Version: 1.0.0
 * <p>
 * Description: StorageConfiguration is the configuration class for storage services.
 */
@Configuration
public class StorageConfiguration {
    // This class can be used to configure storage services like Minio, AWS S3, etc.
    // You can define beans for MinioClient, S3Client, etc. here if needed.
    // For example, you can create a bean for MinioClient using MinioStorageProperties.

    @Bean
    public MinioClient minioClient(MinioStorageProperties properties) {
        return MinioClient.builder()
                .endpoint(properties.getEndPoint())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
    }
}
