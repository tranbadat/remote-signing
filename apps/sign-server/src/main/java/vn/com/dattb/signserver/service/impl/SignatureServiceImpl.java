package vn.com.dattb.signserver.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.signserver.dto.request.SignaturesRequest;
import vn.com.dattb.signserver.dto.response.SignatureResponse;
import vn.com.dattb.signserver.service.SignaturesService;

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

    /**
     * Sign the data that needs to be signed
     *
     * @param request the request to sign the data
     * @return the response that includes the signed data
     */
    @Override
    public SignatureResponse sign(SignaturesRequest request) {
        return null;
    }
}
