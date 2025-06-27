package vn.com.dattb.esignservice.repository.impl;

import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import vn.com.dattb.common.util.EncryptUtils;
import vn.com.dattb.esignservice.config.properties.MinioStorageProperties;
import vn.com.dattb.esignservice.repository.StorageRepository;

import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Repository
@Qualifier("minioStorageRepository")
@Slf4j
public class MinioStorageRepositoryImpl implements StorageRepository {

    private final MinioStorageProperties properties;
    private final MinioClient client;

    public MinioStorageRepositoryImpl(MinioStorageProperties properties, MinioClient client) {
        this.properties = properties;
        this.client = client;
    }

    private void ensureBucketExists() throws Exception {
        if (!client.bucketExists(BucketExistsArgs.builder().bucket(properties.getBucketName()).build())) {
            log.info("Creating bucket: {}", properties.getBucketName());
            client.makeBucket(MakeBucketArgs.builder().bucket(properties.getBucketName()).build());
        }
    }

    private ServerSideEncryption createEncryption() throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKey key = EncryptUtils.stringToSecretKey(properties.getKmsKey());
        log.info("Using KMS key: {}", properties.getKmsKeyId());
        return new ServerSideEncryptionCustomerKey(key);
    }

    @Override
    public void save(String filePath, MultipartFile file) {
        try {
            ensureBucketExists();
            client.putObject(PutObjectArgs.builder()
                    .bucket(properties.getBucketName())
                    .object(filePath)
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .userMetadata(Map.of("x-amz-server-side-encryption", "aws:kms"))
                    .sse(createEncryption())
                    .build());
            log.info("File saved: {}", filePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }

    @Override
    public void save(String filePath, byte[] file) {
        try {
            ensureBucketExists();
            client.putObject(PutObjectArgs.builder()
                    .bucket(properties.getBucketName())
                    .object(filePath)
                    .stream(new java.io.ByteArrayInputStream(file), file.length, -1)
                    .contentType("application/octet-stream")
                    .userMetadata(Map.of("x-amz-server-side-encryption", "aws:kms"))
                    .sse(createEncryption())
                    .build());
            log.info("Byte array saved: {}", filePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save byte array", e);
        }
    }

    @Override
    public void delete(String filePath) {
        try {
            client.removeObject(RemoveObjectArgs.builder()
                    .bucket(properties.getBucketName())
                    .object(filePath)
                    .build());
            log.info("File deleted: {}", filePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete file", e);
        }
    }

    @Override
    public byte[] get(String filePath) {
        try {
            return client.getObject(GetObjectArgs.builder()
                    .bucket(properties.getBucketName())
                    .object(filePath)
                    .build()).readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get file", e);
        }
    }
}