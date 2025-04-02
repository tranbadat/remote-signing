package vn.com.dattb.coreservice.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import vn.com.dattb.coreservice.context.ClientContext;
import vn.com.dattb.coreservice.context.TenantContext;
import vn.com.dattb.coreservice.context.UserContext;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static vn.com.dattb.coreservice.context.ClientContext.getCurrentClient;
import static vn.com.dattb.coreservice.context.ClientContext.setCurrentClient;
import static vn.com.dattb.coreservice.context.TenantContext.getCurrentTenant;
import static vn.com.dattb.coreservice.context.TenantContext.setCurrentTenant;
import static vn.com.dattb.coreservice.context.UserContext.getCurrentUser;
import static vn.com.dattb.coreservice.context.UserContext.setCurrentUser;

/**
 * AsyncFutureExecutor is the utility class for executing asynchronous tasks
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/7/2025
 * Version: 1.0.0
 * <p>
 * Description: This class is used to execute the asynchronous tasks
 */
public class AsyncFutureExecutor {
    private static final Logger logger = LoggerFactory.getLogger(AsyncFutureExecutor.class);

    private AsyncFutureExecutor() {
        throw new IllegalStateException("Utility class");
    }

    public static void runAsync(Runnable task) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        String currentTenant = getCurrentTenant();
        String clientId = getCurrentClient();
        String userId = getCurrentUser();

        CompletableFuture.runAsync(() -> {
            try {
                if (contextMap != null) {
                    MDC.setContextMap(contextMap);
                }
                setCurrentTenant(currentTenant);
                setCurrentClient(clientId);
                setCurrentUser(userId);
                task.run();
            } catch (Exception e) {
                logger.error("Error when run async task", e);
            } finally {
                MDC.clear();
                TenantContext.clear();
                ClientContext.clear();
                UserContext.clear();
            }
        }).handle((result, resultException) -> {
            if (resultException != null) {
                logger.error("Error when run async task", resultException);
            }
            return result;
        });
    }
}
