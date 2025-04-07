package vn.com.dattb.esignservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.dattb.esignservice.entity.master.TenantDatasourceConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
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
    @Qualifier("masterDataSource")  // Inject master data source to query tenant data
    private final DataSource masterDataSource;

    public TenantDataSourceService(TenantHikariDatasourceProperties tenantHikariDatasourceProperties, DataSource masterDataSource) {
        this.properties = tenantHikariDatasourceProperties;

        this.masterDataSource = masterDataSource;
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
        // Fetch tenant configurations from master database
        try (Connection connection = masterDataSource.getConnection()) {
            // Use the connection to query the tenant configuration table
            // This is a simplified approach; you can use JDBC template, JPA, etc.
            String sql = "SELECT * FROM tenant_datasource_config";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<TenantDatasourceConfig> configs = new ArrayList<>();
            while (resultSet.next()) {
                TenantDatasourceConfig config = new TenantDatasourceConfig();
                config.setTenantId(resultSet.getString("tenant_id"));
                config.setUrl(resultSet.getString("datasource_url"));
                config.setUsername(resultSet.getString("datasource_username"));
                config.setPassword(resultSet.getString("datasource_password"));
                config.setDriverClass(resultSet.getString("datasource_driver_class"));
                // Set other properties as needed
                configs.add(config);
            }
            return configs;
        } catch (SQLException e) {
            log.error("Error fetching tenant configurations from the master database", e);
            return Collections.emptyList();
        }
//        return tenantConfigs;
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
