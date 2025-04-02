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
@ConfigurationProperties(prefix = "spring.datasource.tenant.hikari")
@ToString
public class TenantHikariDatasourceProperties {
    private int minimumIdle = 5;
    private int maximumPoolSize = 10;
    private int idleTimeout = 30000;
    private String poolName = "Tenant-HikariPool-1";
    private long maxLifetime = 1800000;
    private long connectionTimeout = 30000;
    private String driverClassName;

}
