package vn.com.dattb.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * RestUtils
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/23/2024
 * Version: 1.0.0
 * <p>
 * Description: This util is used to call rest api
 */

@Slf4j
public class RestUtils {
    public static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static OkHttpClient okHttpClient = new OkHttpClient();

    public enum Action {
        GET, POST, PUT, DELETE
    }

    private RestUtils() {
    }

    public static <T, R> R doPost(
            OkHttpClient okHttpClient,
            String url,
            T requestBody,
            Map<String, String> headers,
            TypeReference<R> responseType
    ) throws IOException {
        if (okHttpClient != null)
            RestUtils.okHttpClient = okHttpClient;
        Request request = buildRequest(url, requestBody, headers, Action.POST);
        return execute(request, responseType);
    }

    public static <T, R> R doPut(
            OkHttpClient okHttpClient,
            String url,
            T requestBody,
            Map<String, String> headers,
            TypeReference<R> responseType
    ) throws IOException {
        if (okHttpClient != null)
            RestUtils.okHttpClient = okHttpClient;
        Request request = buildRequest(url, requestBody, headers, Action.PUT);
        return execute(request, responseType);
    }

    public static <R> R doGet(
            OkHttpClient okHttpClient,
            String url,
            Map<String, String> headers,
            TypeReference<R> responseType
    ) throws IOException {
        if (okHttpClient != null)
            RestUtils.okHttpClient = okHttpClient;
        Request request = buildRequest(url, null, headers, Action.GET);
        return execute(request, responseType);
    }

    public static <T> Request buildRequest(String url, T requestBody, Map<String, String> headers,
                                           Action action) throws JsonProcessingException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .headers(Headers.of(headers));
        if (action == Action.GET) {
            return requestBuilder.get().build();
        }

        String reqBodyInString = objectMapper.writeValueAsString(requestBody);
        RequestBody body = RequestBody.create(reqBodyInString, MediaType.parse(APPLICATION_JSON_VALUE));
        Request request = null;
        if (action == Action.POST) {
            request = requestBuilder.post(body).build();
        } else if (action == Action.PUT) {
            request = requestBuilder.put(body).build();
        }
        log.info("Call Rest Api with {} : {}", action, url);
        log.info(reqBodyInString);
        return request;
    }

    private static <R> R execute(Request request, TypeReference<R> responseType) throws IOException {
        Call call = okHttpClient.newCall(request);
        try (Response response = call.execute()) {
            final ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return null;
            }
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String resBody = responseBody.string();
            return objectMapper.readValue(resBody, responseType);
        }
    }

    @NotNull
    public static <T> TypeReference<T> getNewTypeReference() {
        return new TypeReference<T>() {
        };
    }
}
