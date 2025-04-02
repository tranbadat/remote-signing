package vn.com.dattb.coreservice.context;

/**
 * ClientContext
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/23/2025
 * Version: 1.0.0
 * <p>
 * Description: ClientContext is the class for managing the client context
 */
public class ClientContext {

    private static final ThreadLocal<String> CURRENT_CLIENT = new ThreadLocal<>();

    public static void setCurrentClient(String clientId) {
        CURRENT_CLIENT.set(clientId);
    }

    public static String getCurrentClient() {
        return CURRENT_CLIENT.get();
    }

    public static void clear() {
        CURRENT_CLIENT.remove();
    }
}
