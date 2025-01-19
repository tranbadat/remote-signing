package vn.com.dattb.coreservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * DatabaseInitializer
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/19/2025
 * Version: 1.0.0
 * <p>
 * Description: DatabaseInitializer is the class for initializing the database
 */
@Component
@Slf4j
public class DatabaseInitializer implements CommandLineRunner {
    private final TenantDatabaseMigrator tenantDatabaseMigrator;

    public DatabaseInitializer(TenantDatabaseMigrator tenantDatabaseMigrator) {
        this.tenantDatabaseMigrator = tenantDatabaseMigrator;
    }

    @Override
    public void run(String... args) {
        // Migrate tenant databases
        tenantDatabaseMigrator.migrateTenants();
    }
}
