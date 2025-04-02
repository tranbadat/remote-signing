package vn.com.dattb.coreservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import vn.com.dattb.coreservice.entity.master.TenantDatasourceConfig;
import vn.com.dattb.coreservice.repository.master.TenantDatasourceConfigRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.isNull;

/**
 * TenantDataSourceService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/19/2025
 * Version: 1.0.0
 * <p>
 * Description: TenantDataSourceService is the service class for managing the tenant data source
 */
@Service
@Slf4j
public class TenantDataSourceService {
    private static final Map<String, DataSource> tenantDataSources = new ConcurrentHashMap<>();
    private final TenantHikariDatasourceProperties properties;
    private final TenantDatasourceConfigRepository tenantDatasourceConfigRepository;

    public TenantDataSourceService(TenantHikariDatasourceProperties tenantHikariDatasourceProperties,
                                   TenantDatasourceConfigRepository tenantDatasourceConfigRepository) {
        this.properties = tenantHikariDatasourceProperties;
        this.tenantDatasourceConfigRepository = tenantDatasourceConfigRepository;
    }

    private DataSource createDataSource(TenantDatasourceConfig config) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(config.getUrl());
        hikariConfig.setUsername(config.getUsername());
        hikariConfig.setPassword(config.getPassword());
        hikariConfig.setDriverClassName(StringUtils.isBlank(config.getDriverClass()) ?
                properties.getDriverClassName() : config.getDriverClass());
        hikariConfig.setMaximumPoolSize(isNull(config.getMaxPoolSize()) ?
                properties.getMaximumPoolSize() : config.getMaxPoolSize());
        hikariConfig.setMinimumIdle(isNull(config.getMinIdle()) ?
                properties.getMinimumIdle() : config.getMinIdle());
        hikariConfig.setMaxLifetime(isNull(config.getMaxLifeTime()) ?
                properties.getMaxLifetime() : config.getMaxLifeTime());
        hikariConfig.setConnectionTimeout(isNull(config.getConnectionTimeout()) ?
                properties.getConnectionTimeout() : config.getConnectionTimeout());
        hikariConfig.setIdleTimeout(isNull(config.getIdleTimeout()) ?
                properties.getIdleTimeout() : config.getIdleTimeout());
        hikariConfig.setPoolName(StringUtils.isBlank(config.getPoolName()) ?
                properties.getPoolName() : config.getPoolName());
        return new HikariDataSource(hikariConfig);
    }

    @PostConstruct
    public void initializeTenantDataSources() {
        // Assume this method fetches tenant configuration from a central source (e.g., database, config file)
        log.info("Initializing tenant data sources first time from configuration");
        List<TenantDatasourceConfig> tenantConfigs = fetchTenantConfigs();

        for (TenantDatasourceConfig config : tenantConfigs) {
            DataSource dataSource = createDataSource(config);
            tenantDataSources.put(config.getTenantId(), dataSource);
        }
        log.info("Initialized {} tenant data sources", tenantDataSources.size());
    }

    public DataSource getDataSource(String tenantId) {
        return tenantDataSources.get(tenantId);
    }

    private List<TenantDatasourceConfig> fetchTenantConfigs() {
        // Mock implementation, replace with your logic to fetch tenant configuration
        List<TenantDatasourceConfig> tenantConfigs = tenantDatasourceConfigRepository.findAll();
//        for (TenantDatasourceConfig config : tenantConfigs) {
//            HikariDataSource dataSource = new HikariDataSource();
//            dataSource.setJdbcUrl(config.getUrl());
//            dataSource.setUsername(config.getUsername());
//            dataSource.setPassword(config.getPassword());
//            dataSource.setDriverClassName(config.getDriverClass());
//            dataSource.setMaximumPoolSize(config.getMaxPoolSize());
//            dataSource.setMinimumIdle(config.getMinIdle());
//            dataSource.setMaxLifetime(config.getMaxLifeTime());
//            dataSource.setConnectionTimeout(config.getConnectionTimeout());
//            dataSource.setIdleTimeout(config.getIdleTimeout());
//            dataSource.setPoolName(config.getPoolName());
//            tenantDataSources.put(config.getTenantId(), dataSource);
//        }
//        TenantDatasourceConfig tenant1 = TenantDatasourceConfig.builder()
//                .tenantId("tenant1")
//                .url("jdbc:postgresql://postgres:5432/e-contract-tenant")
//                .username("dattb")
//                .password("dattb123")
//                .driverClass("org.postgresql.Driver")
//                .build();
        return tenantConfigs;
    }

    public Map<String, DataSource> getTenantDataSourcesMap() {
        return tenantDataSources;
    }

    public List<HikariDataSource> getTenantDataSources() {
        log.info("Getting all tenant data sources from configuration");
        return tenantDataSources.values().stream()
                .map(HikariDataSource.class::cast)
                .toList();
    }
}
