package vn.com.dattb.ssaservice.service;

import java.io.IOException;

/**
 * NotificationService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/4/2025
 * Version: 1.0.0
 * <p>
 * Description: Service for handling notification requests
 */
public interface NotificationService {

    void sendNotification(String targetToken, String title, String body) throws IOException;
}
