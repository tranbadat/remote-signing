package vn.com.dattb.signserver.service;

import vn.com.dattb.signserver.dto.request.SignaturesRequest;
import vn.com.dattb.signserver.dto.response.SignatureResponse;

/**
 * <SignaturesService>.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/8/2024
 * Version: 1.0.0
 * <p>
 * Description:
 */
public interface SignaturesService {

    /**
     * Sign the data that needs to be signed
     *
     * @param request the request to sign the data
     * @return the response that includes the signed data
     */
    SignatureResponse sign(SignaturesRequest request);
}
