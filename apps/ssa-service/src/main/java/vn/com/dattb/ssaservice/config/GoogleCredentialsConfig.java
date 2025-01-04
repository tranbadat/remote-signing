package vn.com.dattb.ssaservice.config;

import com.google.auth.oauth2.GoogleCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * GoogleCredentialsConfig
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/4/2025
 * Version: 1.0.0
 * <p>
 * Description: Configuration for Google credentials
 */
@Configuration
@Slf4j
public class GoogleCredentialsConfig {

    @Value("${fcm.path-to-service-account-key}")
    private String pathToServiceAccountKey;

    @Bean
    public GoogleCredentials googleCredentials() throws IOException {
        // Load the service account key JSON file
        log.info("Loading Firebase service account key...");
        try (FileInputStream serviceAccount
                     = new FileInputStream(pathToServiceAccountKey)) {
            return GoogleCredentials.fromStream(serviceAccount)
                    .createScoped("https://www.googleapis.com/auth/firebase.messaging");
        } catch (IOException e) {
            log.error("Error loading Firebase service account key: {}", e.getMessage());
            throw e;
        }

    }
}
