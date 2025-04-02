package vn.com.dattb.coreservice.entity.tenant;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Contract
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/20/2025
 * Version: 1.0.0
 * <p>
 * Description: Contract entity
 */
@Data
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_number", nullable = false, length = 50)
    private String contractNumber;

    @Column(name = "contract_name", nullable = false, length = 255)
    private String contractName;

    @Column(name = "contract_type", nullable = false, length = 255)
    private String contractType;

    @Column(name = "contract_status", nullable = false, length = 255)
    private String contractStatus;

    @Column(name = "contract_start_date", nullable = false)
    private LocalDateTime contractStartDate;

    @Column(name = "contract_end_date", nullable = false)
    private LocalDateTime contractEndDate;

    @Column(name = "contract_value", nullable = false, precision = 19, scale = 2)
    private BigDecimal contractValue;

    @Column(name = "contract_currency", nullable = false, length = 10)
    private String contractCurrency;

    @Column(name = "contract_description", columnDefinition = "TEXT")
    private String contractDescription;

    @Column(name = "file_path", nullable = false, length = 255)
    private String filePath;

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
}
