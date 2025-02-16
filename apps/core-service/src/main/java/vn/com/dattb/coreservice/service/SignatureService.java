package vn.com.dattb.coreservice.service;

import vn.com.dattb.coreservice.dto.response.SignatureResponse;

import java.util.List;

/**
 * SignatureService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/18/2025
 * Version: 1.0.0
 * <p>
 * Description: SignatureService is the service class for signature
 */
public interface SignatureService {
    SignatureResponse getDetailSignature(Long signatureId);

    List<SignatureResponse> getAllSignatures();
}
