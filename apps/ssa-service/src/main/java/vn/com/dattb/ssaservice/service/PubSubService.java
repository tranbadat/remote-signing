package vn.com.dattb.ssaservice.service;

import redis.clients.jedis.Jedis;

/**
 * PubSubService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/1/2025
 * Version: 1.0.0
 * <p>
 * Description: Service for Jedis
 */
public interface PubSubService {
    Jedis subscribe(String channel);

    void publish(String channel, String message);

    void close(Jedis jedis);
}
