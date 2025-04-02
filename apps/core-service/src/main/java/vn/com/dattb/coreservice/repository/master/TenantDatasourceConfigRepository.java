package vn.com.dattb.coreservice.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.dattb.coreservice.entity.master.TenantDatasourceConfig;

import java.util.Optional;

/**
 * TenantDatasourceConfigRepository
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/20/2025
 * Version: 1.0.0
 * <p>
 * Description: TenantDatasourceConfigRepository is the repository for TenantDatasourceConfig entity
 */
public interface TenantDatasourceConfigRepository extends JpaRepository<TenantDatasourceConfig, Long> {
    Optional<TenantDatasourceConfig> findByTenantId(String tenantId);
}
