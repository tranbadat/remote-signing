package vn.com.dattb.ssaservice.service.impl;

import com.google.auth.oauth2.GoogleCredentials;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.com.dattb.ssaservice.service.NotificationService;

import java.io.IOException;

/**
 * FirebaseNotificationServiceImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/4/2025
 * Version: 1.0.0
 * <p>
 * Description: Service for handling notification requests
 */
@Service
@Slf4j
public class FirebaseNotificationServiceImpl implements NotificationService {

    @Value("${fcm.base-url}")
    private String fcmBaseUrl= "https://fcm.googleapis.com/v1/projects";

    @Value("${fcm.project-id}")
    private String fcmProjectId ="esign-dattb";

    @Value("${fcm.notification-endpoint}")
    private String fcmNotificationEndpoint ="/messages:send";

    private final GoogleCredentials googleCredentials;

    public FirebaseNotificationServiceImpl(GoogleCredentials googleCredentials) {
        this.googleCredentials = googleCredentials;
    }


    private String getAccessToken() throws IOException {
        googleCredentials.refreshIfExpired();
        return googleCredentials.getAccessToken().getTokenValue();
    }

    public void sendNotification(String targetToken, String title, String body) throws IOException {
        // Build the notification payload
        String messagePayload = buildMessagePayload(targetToken, title, body);

        // Send the request
        sendPostRequest(messagePayload);
    }

    private String buildMessagePayload(String targetToken, String title, String body) {
        return "{\n" +
                "  \"message\": {\n" +
                "    \"token\": \"" + targetToken + "\",\n" +
                "    \"notification\": {\n" +
                "      \"title\": \"" + title + "\",\n" +
                "      \"body\": \"" + body + "\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

    private void sendPostRequest(String payload) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            log.info("Sending POST request to FCM...");
            String url = fcmBaseUrl + "/" + fcmProjectId + fcmNotificationEndpoint;
            log.info("URL: {}", url);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Authorization", "Bearer " + getAccessToken());
            httpPost.setHeader("Content-Type", "application/json");

            StringEntity entity = new StringEntity(payload);
            httpPost.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                log.info("Response status: {}", response.getStatusLine());
            }
        }
    }

}
