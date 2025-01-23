package vn.com.dattb.common.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

/**
 * OkHttpClientConfig
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/23/2025
 * Version: 1.0.0
 * <p>
 * Description: This class is used to configure the OkHttpClient
 */
@Configuration
public class OkHttpClientConfig {

    @Bean
    @Primary
    public OkHttpClient okHttpClient() {
        return new OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(200, 2L, TimeUnit.MINUTES))
                .connectTimeout(30L, TimeUnit.SECONDS)
                .build();
    }
}
