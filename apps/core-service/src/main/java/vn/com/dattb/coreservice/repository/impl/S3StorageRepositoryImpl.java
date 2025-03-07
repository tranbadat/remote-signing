package vn.com.dattb.coreservice.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import vn.com.dattb.coreservice.repository.StorageRepository;

import java.io.IOException;

/**
 * S3StorageRepositoryImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/6/2025
 * Version: 1.0.0
 * <p>
 * Description: S3StorageRepositoryImpl
 */
@Slf4j
@Repository
public class S3StorageRepositoryImpl implements StorageRepository {
    private final S3Client s3Client;
    private static final String BUCKET_NAME = "my-bucket";

    public S3StorageRepositoryImpl(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();


        return String.format("http://localhost:9000/%s/%s", BUCKET_NAME, fileName);
    }

    @Override
    public void save(String filePath, MultipartFile file) throws IOException {
        // Create the bucket if it doesn't exist
        if (s3Client.listBuckets().buckets().stream().noneMatch(b -> b.name().equals(BUCKET_NAME))) {
            s3Client.createBucket(CreateBucketRequest.builder().bucket(BUCKET_NAME).build());
        }

        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(BUCKET_NAME)
                        .key(filePath)
                        .contentType(file.getContentType())
                        .build(),
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes())
        );


    }

    @Override
    public void save(String filePath, byte[] file) {
        // Save file to S3
        s3Client.putObject(b -> b.bucket(BUCKET_NAME)
                .key(filePath), software.amazon.awssdk.core.sync.RequestBody.fromBytes(file));
    }

    @Override
    public void delete(String filePath) {
        log.info("Deleting file: {}", filePath);
        s3Client.deleteObject(b -> b.bucket(BUCKET_NAME).key(filePath));
        log.info("Deleted file: {}", filePath);
        // Delete file from S3
    }

    @Override
    public byte[] get(String filePath) {
        log.info("Getting file: {}", filePath);
        s3Client.getObject(b -> b.bucket(BUCKET_NAME).key(filePath));
        // Get file from S3
        return new byte[0];
    }
}
