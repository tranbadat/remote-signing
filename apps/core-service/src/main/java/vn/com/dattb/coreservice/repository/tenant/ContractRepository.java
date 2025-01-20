package vn.com.dattb.coreservice.repository.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.dattb.coreservice.entity.tenant.Contract;

/**
 * ContractRepository
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/20/2025
 * Version: 1.0.0
 * <p>
 * Description: ContractRepository is the repository for Contract entity
 */
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
