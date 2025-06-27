package vn.com.dattb.esignservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MinioStorageProperties
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 6/27/2025
 * Version: 1.0.0
 * <p>
 * Description: MinioStorageProperties is the properties class for Minio storage configuration.
 */
@ConfigurationProperties(prefix = "minio.storage")
@Data
public class MinioStorageProperties {
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String kmsKeyId; // KMS Key ID for encryption
    private String encryptionAlgorithm; // Encryption algorithm, e.g., "AES/GCM/NoPadding"
    private String kmsKey; // Base64 encoded KMS key for encryption
    private String region; // Optional, if your Minio server is region-specific
}
