package vn.com.dattb.coreservice.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * TenantDatabaseConfig
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/20/2025
 * Version: 1.0.0
 * <p>
 * Description: TenantDatabaseConfig is the class for configuring the tenant database
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "vn.com.dattb.coreservice.repository.tenant", // Replace with your tenant repository package
        entityManagerFactoryRef = "tenantEntityManagerFactory",
        transactionManagerRef = "tenantTransactionManager"
)
@EnableConfigurationProperties({TenantHikariDatasourceProperties.class})
public class TenantDatabaseConfig {

    @Bean(name = "tenantEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean tenantEntityManagerFactory(
            @Qualifier("tenantDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("vn.com.dattb.coreservice.entity.tenant") // Replace with your tenant entity package
                .persistenceUnit("tenant")
                .build();
    }

    @Bean(name = "tenantTransactionManager")
    public PlatformTransactionManager tenantTransactionManager(
            @Qualifier("tenantEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "tenantDataSource")
    public DataSource tenantDataSource(TenantDataSourceService tenantDataSourceService) {
        TenantRoutingDataSource tenantRoutingDataSource = new TenantRoutingDataSource();

        // Set the preloaded tenant data sources
        tenantRoutingDataSource.setTargetDataSources(
                new HashMap<>(tenantDataSourceService.getTenantDataSourcesMap())
        );

        // Default DataSource (optional)
        tenantRoutingDataSource.setDefaultTargetDataSource(tenantDataSourceService.getDataSource("default"));

        tenantRoutingDataSource.afterPropertiesSet();
        return tenantRoutingDataSource;
    }

}
