package vn.com.dattb.ssaservice.service;

import vn.com.dattb.ssaservice.dto.request.CredentialsRequest;
import vn.com.dattb.ssaservice.dto.request.CredentialsAuthorizeRequest;
import vn.com.dattb.ssaservice.dto.request.CredentialsInfoRequest;
import vn.com.dattb.ssaservice.dto.request.GetChallengeRequest;
import vn.com.dattb.ssaservice.dto.response.CredentialsResponse;
import vn.com.dattb.ssaservice.dto.response.CredentialsAuthorizeResponse;
import vn.com.dattb.ssaservice.dto.response.CredentialsInfoResponse;
import vn.com.dattb.ssaservice.dto.response.GetChallengeResponse;

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
     * @param credentialsAuthorizeRequest inputCredentialsAuthorize
     * @return SAD and expiresIn in OutputCredentialsAuthorize
     */
    CredentialsAuthorizeResponse authorize(CredentialsAuthorizeRequest credentialsAuthorizeRequest);

    /**
     * Get credentials list
     *
     * @param credentialsRequest inputCredentials
     * @return credentials list in OutputCredentials
     */
    CredentialsResponse getCredentialsList(CredentialsRequest credentialsRequest);

    /**
     * Get credentials info
     *
     * @param credentialsInfoRequest inputCredentialsInfo
     * @return credentials info in OutputCredentialsInfo
     */
    CredentialsInfoResponse getCredentialsInfo(CredentialsInfoRequest credentialsInfoRequest);

    /**
     * Get challenge
     *
     * @param getChallengeRequest inputGetChallenge
     * @return challenge in GetChallengeResponse
     */
    GetChallengeResponse getChallenge(GetChallengeRequest getChallengeRequest);
}
