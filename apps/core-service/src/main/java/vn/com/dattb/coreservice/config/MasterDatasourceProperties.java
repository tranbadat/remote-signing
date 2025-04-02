package vn.com.dattb.coreservice.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MasterDatasourceProperties
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/21/2025
 * Version: 1.0.0
 * <p>
 * Description: MasterDatasourceProperties is the class for configuring the master datasource properties
 */
@Setter
@ConfigurationProperties(prefix = "spring.datasource.master")
@Getter
@ToString
public class MasterDatasourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

}
