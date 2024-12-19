package vn.com.dattb.ssaservice.service;

import vn.com.dattb.ssaservice.dto.request.InputCredentials;
import vn.com.dattb.ssaservice.dto.request.InputCredentialsAuthorize;
import vn.com.dattb.ssaservice.dto.request.InputCredentialsInfo;
import vn.com.dattb.ssaservice.dto.response.OutputCredentials;
import vn.com.dattb.ssaservice.dto.response.OutputCredentialsAuthorize;
import vn.com.dattb.ssaservice.dto.response.OutputCredentialsInfo;

/**
 * CredentialsService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: Service for handling credentials
 */
public interface CredentialsService {

    /**
     * Authorize credentials
     *
     * @param inputCredentialsAuthorize inputCredentialsAuthorize
     * @return SAD and expiresIn in OutputCredentialsAuthorize
     */
    OutputCredentialsAuthorize authorize(InputCredentialsAuthorize inputCredentialsAuthorize);

    /**
     * Get credentials list
     *
     * @param inputCredentials inputCredentials
     * @return credentials list in OutputCredentials
     */
    OutputCredentials getCredentialsList(InputCredentials inputCredentials);

    /**
     * Get credentials info
     *
     * @param inputCredentialsInfo inputCredentialsInfo
     * @return credentials info in OutputCredentialsInfo
     */
    OutputCredentialsInfo getCredentialsInfo(InputCredentialsInfo inputCredentialsInfo);
}
