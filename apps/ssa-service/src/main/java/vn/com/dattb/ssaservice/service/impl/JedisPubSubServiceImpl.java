package vn.com.dattb.ssaservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;
import vn.com.dattb.ssaservice.service.PubSubService;

import static java.util.Objects.nonNull;

/**
 * JedisPubSubServiceImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/1/2025
 * Version: 1.0.0
 * <p>
 * Description: Implementation for Jedis PubSub service
 */
@Service
@Slf4j
public class JedisPubSubServiceImpl implements PubSubService {

    private final JedisPoolConfig jedisPoolConfig;

    @Value("${spring.redis.host:localhost}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.timeout:100}")
    private int timeout;

    public JedisPubSubServiceImpl(JedisPoolConfig jedisPoolConfig) {
        this.jedisPoolConfig = jedisPoolConfig;
    }

    @Override
    public Jedis subscribe(String channelSub) {
        try (JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout)) {
            Jedis jSubscriber = jedisPool.getResource();
            JedisPubSub jedisPubSub = new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    log.info("Received message: {} from channel: {}", message, channel);
                    this.unsubscribe();

                }
            };
            jSubscriber.subscribe(jedisPubSub, channelSub);
            return jSubscriber;
        }
    }

    @Override
    public void publish(String channel, String message) {
        try (Jedis jedis = new Jedis()) {
            jedis.publish(channel, message);
        }
    }

    @Override
    public void close(Jedis jedis) {
        log.info("Closing jedis");
        if (nonNull(jedis)) {
            jedis.close();
        }
        log.info("Jedis closed");

    }
}
