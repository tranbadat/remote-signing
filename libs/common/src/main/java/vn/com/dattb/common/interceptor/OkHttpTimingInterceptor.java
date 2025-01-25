package vn.com.dattb.common.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.Objects;

import static vn.com.dattb.common.Constants.TRACE_ID;
import static vn.com.dattb.common.Constants.X_REQUEST_ID;

/**
 * OkHttpTimingInterceptor
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/23/2025
 * Version: 1.0.0
 * <p>
 * Description: This class is used to intercept the request and response of the OkHttp client
 */
public class OkHttpTimingInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpTimingInterceptor.class);

    @NotNull
    @Override
    public Response intercept(Interceptor.Chain chain) {

        long startTime = System.currentTimeMillis();
        Request request = chain.request();
        String traceId = MDC.get(TRACE_ID);
        if (Objects.nonNull(traceId)) {
            request = request.newBuilder()
                    .header(X_REQUEST_ID, traceId)
                    .build();
        }
        LOGGER.info("New OkHttp request: uri={}, method={}", request.url(), request.method());

        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (IOException e) {
            LOGGER.error("Occurred error during HTTP call", e);
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            LOGGER.info("OkHttp response: uri={}, response_code={}, process_time={}ms",
                    request.url(), Objects.requireNonNull(response).code(), duration);
        }

        return response;
    }
}
