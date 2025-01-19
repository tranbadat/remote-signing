package vn.com.dattb.coreservice.service;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private final JdbcTemplate jdbcTemplate;

    public TenantDataSourceService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HikariDataSource> getTenantDataSources() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT datasource_url, datasource_username, datasource_password, datasource_driver_class");
        sqlBuilder.append(" FROM tenant_datasource_config");
        sqlBuilder.append(" WHERE is_deleted = FALSE and is_active = TRUE");
        String sql = sqlBuilder.toString();

        List<HikariDataSource> dataSources = new ArrayList<>();

        jdbcTemplate.query(sql, rs -> {
            if (!rs.next()) {
                log.warn("No data source found");
                return;
            }
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(rs.getString("datasource_url"));
            dataSource.setUsername(rs.getString("datasource_username"));
            dataSource.setPassword(rs.getString("datasource_password"));
            dataSource.setDriverClassName(rs.getString("datasource_driver_class"));
            dataSources.add(dataSource);
        });

        return dataSources;
    }
}
