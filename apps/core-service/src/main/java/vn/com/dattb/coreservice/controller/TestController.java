package vn.com.dattb.coreservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dattb.coreservice.repository.master.TenantDatasourceConfigRepository;
import vn.com.dattb.coreservice.repository.tenant.ContractRepository;

/**
 * TestController
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/20/2025
 * Version: 1.0.0
 * <p>
 * Description: TestController
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    private final TenantDatasourceConfigRepository tenantDatasourceConfigRepository;
    private final ContractRepository contractRepository;

    public TestController(TenantDatasourceConfigRepository tenantDatasourceConfigRepository, ContractRepository contractRepository) {
        this.tenantDatasourceConfigRepository = tenantDatasourceConfigRepository;
        this.contractRepository = contractRepository;
    }

    @RequestMapping("/hello")
    public String hello() {
        log.info("Test get data from tenant datasource");
        log.info("Tenant datasource config: {}", tenantDatasourceConfigRepository.findAll());
        log.info("Tenant contract: {}", contractRepository.findAll());
        return "Hello world";
    }
}
