package vn.com.dattb.coreservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.coreservice.dto.response.SignatureResponse;
import vn.com.dattb.coreservice.service.SignatureService;

import java.util.List;

/**
 * SignatureServiceImpl is the service class for signature service
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/13/2025
 * Version: 1.0.0
 * <p>
 * Description: SignatureServiceImpl is the service class for signature service
 */
@Service
@Slf4j
public class SignatureServiceImpl implements SignatureService {
    @Override
    public SignatureResponse getDetailSignature(Long signatureId) {
        return null;
    }

    @Override
    public List<SignatureResponse> getAllSignatures() {
        return List.of();
    }
}
