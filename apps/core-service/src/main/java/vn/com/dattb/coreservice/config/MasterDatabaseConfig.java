package vn.com.dattb.coreservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * MasterDatabaseConfig
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/20/2025
 * Version: 1.0.0
 * <p>
 * Description: MasterDatabaseConfig is the class for configuring the master database
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "vn.com.dattb.coreservice.repository.master", // Replace with your master repository package
        entityManagerFactoryRef = "masterEntityManagerFactory",
        transactionManagerRef = "masterTransactionManager"
)
@EnableConfigurationProperties({MasterDatasourceProperties.class, MasterHikariDatasourceProperties.class})
public class MasterDatabaseConfig {
    private static final Logger log = LoggerFactory.getLogger(MasterDatabaseConfig.class);

    MasterHikariDatasourceProperties masterHikariDatasourceProperties;
    MasterDatasourceProperties masterDatasourceProperties;

    @Autowired
    public MasterDatabaseConfig(MasterDatasourceProperties masterDatasourceProperties,
                                MasterHikariDatasourceProperties masterHikariDatasourceProperties) {
        this.masterDatasourceProperties = masterDatasourceProperties;
        this.masterHikariDatasourceProperties = masterHikariDatasourceProperties;
    }
    @Bean
    @Primary
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
                new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource() {
        log.info("Configuring master datasource");
        log.info("Master datasource properties: {}", masterDatasourceProperties);
        log.info("Master Hikari datasource properties: {}", masterHikariDatasourceProperties);
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(masterDatasourceProperties.getUrl());
        hikariConfig.setUsername(masterDatasourceProperties.getUsername());
        hikariConfig.setPassword(masterDatasourceProperties.getPassword());
        hikariConfig.setDriverClassName(masterDatasourceProperties.getDriverClassName());
        hikariConfig.setMinimumIdle(masterHikariDatasourceProperties.getMinimumIdle());
        hikariConfig.setMaximumPoolSize(masterHikariDatasourceProperties.getMaximumPoolSize());
        hikariConfig.setIdleTimeout(masterHikariDatasourceProperties.getIdleTimeout());
        hikariConfig.setPoolName(masterHikariDatasourceProperties.getPoolName());
        hikariConfig.setMaxLifetime(masterHikariDatasourceProperties.getMaxLifetime());
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        log.info("Master datasource configured successfully");
        return dataSource;

    }

    @Bean(name = "masterEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(
            @Qualifier("masterDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("vn.com.dattb.coreservice.entity.master") // Replace with your master entity package
                .persistenceUnit("master")
                .build();
    }

    @Bean(name = "masterTransactionManager")
    public PlatformTransactionManager masterTransactionManager(
            @Qualifier("masterEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
