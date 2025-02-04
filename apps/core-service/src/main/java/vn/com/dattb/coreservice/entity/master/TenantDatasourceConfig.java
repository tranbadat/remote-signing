package vn.com.dattb.coreservice.entity.master;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * TenantDatasourceConfig
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/20/2025
 * Version: 1.0.0
 * <p>
 * Description: TenantDatasourceConfig
 */
@Data
@Entity
@Table(name = "tenant_datasource_config")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantDatasourceConfig {

    @Id
    private Long id;

    @Column(name = "tenant_id", nullable = false, length = 50)
    private String tenantId;

    @Column(name = "datasource_name", nullable = false, length = 255)
    private String datasourceName;

    @Column(name = "datasource_url", nullable = false, length = 255)
    private String url;

    @Column(name = "datasource_username", nullable = false, length = 255)
    private String username;

    @Column(name = "datasource_password", nullable = false, length = 255)
    private String password;

    @Column(name = "datasource_driver_class", nullable = false, length = 255)
    private String driverClass;

    @Column(name = "datasource_max_pool_size", nullable = false)
    @Builder.Default
    private Integer maxPoolSize = 10;

    @Column(name = "datasource_min_idle", nullable = false)
    @Builder.Default
    private Integer minIdle = 1;

    @Column(name = "datasource_max_life_time", nullable = false)
    @Builder.Default
    private Integer maxLifeTime = 1800000;

    @Column(name = "datasource_connection_timeout", nullable = false)
    @Builder.Default
    private Integer connectionTimeout = 30000;

    @Column(name = "datasource_idle_timeout", nullable = false)
    @Builder.Default
    private Integer idleTimeout = 600000;

    @Column(name = "datasource_pool_name", length = 100)
    private String poolName;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "database_type", length = 10)
    private String databaseType = "postgres";

    @Column(name = "is_shared")
    private Boolean isShared = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false, length = 255)
    private String createdBy = "system";

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", nullable = false, length = 255)
    private String updatedBy = "system";

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by", length = 255)
    private String deletedBy;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
