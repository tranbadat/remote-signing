package vn.com.dattb.ssaservice.service;

import vn.com.dattb.ssaservice.dto.request.SignaturesRquest;
import vn.com.dattb.ssaservice.dto.response.SignaturesResponse;

/**
 * SignaturesService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: Service for handling signature requests
 */
public interface SignaturesService {

    /**
     * Sign hash
     *
     * @param signaturesRquest input signature
     * @return output signature
     */
    SignaturesResponse signHash(SignaturesRquest signaturesRquest);
}
