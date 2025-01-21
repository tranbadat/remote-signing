package vn.com.dattb.coreservice.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import vn.com.dattb.coreservice.context.TenantContext;

/**
 * TenantRoutingDataSource
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/21/2025
 * Version: 1.0.0
 * <p>
 * Description: TenantRoutingDataSource is the class for routing data source
 */
public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TenantContext.getCurrentTenant(); // Determine the current tenant dynamically
    }
}

