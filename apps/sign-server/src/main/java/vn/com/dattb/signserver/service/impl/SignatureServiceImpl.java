package vn.com.dattb.signserver.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.com.dattb.signserver.dto.request.SignaturesRequest;
import vn.com.dattb.signserver.dto.response.SignatureResponse;
import vn.com.dattb.signserver.enums.ResponseCode;
import vn.com.dattb.signserver.exception.BusinessException;
import vn.com.dattb.signserver.service.SignaturesService;
import vn.com.dattb.signserver.utils.SignatureUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

/**
 * SignatureServiceImpl.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/8/2024
 * Version: 1.0.0
 * <p>
 * Description: This service is used to sign the data that needs to be signed
 */
@Service
@Slf4j
public class SignatureServiceImpl implements SignaturesService {

    public static final String JKS = "JKS";
    @Value("${signature.algorithm:SHA256withRSA}")
    private String signatureAlgorithm;

    @Value("${signing.key-store.location}")
    private String keyStoreLocation;

    @Value("${signing.key-store.password}")
    private String keyStorePassword;

    @Value("${signing.key-store.alias:dattb}")
    private String keyStoreAlias;

    /**
     * Sign the data that needs to be signed
     *
     * @param request the request to sign the data
     * @return the response that includes the signed data
     */
    @Override
    public SignatureResponse sign(SignaturesRequest request) {

        try {
            log.info("Start sign the data");
            String algorithm = request.getSignatureAlgorithm();
            if (StringUtils.isBlank(algorithm)) {
                algorithm = signatureAlgorithm;
            }

            List<SignaturesRequest.Request> requests = request.getRequests();

            validateRequests(requests);

            PrivateKey privateKey = getPrivateKey();
            String finalAlgorithm = algorithm;
            SignatureResponse response = processSignData(requests, finalAlgorithm, privateKey);
            log.info("End sign the data");
            return response;

        } catch (Exception e) {
            if (e instanceof BusinessException ex) {
                throw ex;
            }
            log.error("Error when process the request", e);
            throw new BusinessException(ResponseCode.ERROR, e.getMessage());
        }
    }

    private static SignatureResponse processSignData(List<SignaturesRequest.Request> requests,
                                                     String finalAlgorithm,
                                                     PrivateKey privateKey) {
        SignatureResponse response = new SignatureResponse();
        response.setSignatures(requests.stream()
                .map(data -> {
                    try {
                        String privateAlgorithm = data.getSignatureAlgorithm();
                        if (StringUtils.isBlank(privateAlgorithm)) {
                            privateAlgorithm = finalAlgorithm;
                        }
                        return SignatureUtils.sign(data.getDtbs(), privateKey, privateAlgorithm);
                    } catch (Exception e) {
                        log.error("Error when sign the data", e);
                        throw new BusinessException(ResponseCode.ERROR, "Error when sign the data");
                    }
                })
                .toList());
        return response;
    }

    private PrivateKey getPrivateKey() throws KeyStoreException, IOException,
            NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {

        KeyStore keyStore = loadKeyStore(keyStoreLocation, keyStorePassword);
        String alias = "";

        Enumeration<String> aliases = keyStore.aliases();
        while (!alias.equals(keyStoreAlias) && aliases.hasMoreElements()) {
            alias = aliases.nextElement();
        }

        log.info("Alias: {}", alias);
        return (PrivateKey) keyStore.getKey(alias, keyStorePassword.toCharArray());
    }

    private void validateRequests(List<SignaturesRequest.Request> requests) {
        if (requests.stream().anyMatch(request -> StringUtils.isBlank(request.getDtbs()))) {
            throw new BusinessException(ResponseCode.ERROR, "Data to be signed must not be null");
        }
    }

    private KeyStore loadKeyStore(String keyStoreLocation, String keyStorePassword)
            throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        Objects.requireNonNull(keyStoreLocation, "Key store location must not be null");
        Objects.requireNonNull(keyStorePassword, "Key store password must not be null");
        KeyStore ks = KeyStore.getInstance(JKS);
        ks.load(new FileInputStream(keyStoreLocation), keyStorePassword.toCharArray());
        return ks;
    }
}
