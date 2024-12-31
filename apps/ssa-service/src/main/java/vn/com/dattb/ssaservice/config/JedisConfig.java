package vn.com.dattb.ssaservice.config;

import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * JedisConfig
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/31/2024
 * Version: 1.0.0
 * <p>
 * Description: Jedis configuration
 */
public class JedisConfig {
    @Bean
    public JedisPoolConfig buildPoolConfig() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setTimeBetweenEvictionRuns(Duration.ofSeconds(30));
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }
}
