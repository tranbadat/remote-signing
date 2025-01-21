package vn.com.dattb.coreservice.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MasterHikariDatasourceProperties
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/21/2025
 * Version: 1.0.0
 * <p>
 * Description: MasterHikariDatasourceProperties is the class for configuring the master Hikari datasource properties
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.datasource.master.hikari")
@ToString
public class MasterHikariDatasourceProperties {
    private int minimumIdle;
    private int maximumPoolSize;
    private int idleTimeout;
    private String poolName;
    private long maxLifetime;
    private long connectionTimeout;

}
