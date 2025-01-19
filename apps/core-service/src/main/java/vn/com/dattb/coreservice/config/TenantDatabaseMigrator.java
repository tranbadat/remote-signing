package vn.com.dattb.coreservice.config;

import com.zaxxer.hikari.HikariDataSource;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vn.com.dattb.coreservice.service.TenantDataSourceService;

import java.sql.Connection;
import java.util.List;

/**
 * TenantDatabaseMigrator
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/19/2025
 * Version: 1.0.0
 * <p>
 * Description: TenantDatabaseMigrator is the class for migrating the tenant database
 */
@Component
@Slf4j
public class TenantDatabaseMigrator {
    private final TenantDataSourceService tenantDataSourceService;

    public TenantDatabaseMigrator(TenantDataSourceService tenantDataSourceService) {
        this.tenantDataSourceService = tenantDataSourceService;
    }

    public void migrateTenants() {
        log.info("Migrating tenant databases");
        List<HikariDataSource> tenantDataSources = tenantDataSourceService.getTenantDataSources();
        log.info("Found {} tenant databases", tenantDataSources.size());
        for (HikariDataSource dataSource : tenantDataSources) {
            log.info("Migrating tenant database: {}", dataSource.getJdbcUrl());
            try (dataSource; Connection connection = dataSource.getConnection()) {
                Database database = DatabaseFactory.getInstance()
                        .findCorrectDatabaseImplementation(new JdbcConnection(connection));

                Liquibase liquibase = new Liquibase(
                        "classpath:db/tenant/tenant-changelog.xml",
                        new ClassLoaderResourceAccessor(),
                        database
                );
                liquibase.update("");
            } catch (Exception e) {
                throw new RuntimeException("Failed to migrate tenant database", e);
            }
        }
    }
}
