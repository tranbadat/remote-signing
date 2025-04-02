package vn.com.dattb.ssaservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.ssaservice.dto.request.CredentialsRequest;
import vn.com.dattb.ssaservice.dto.request.CredentialsAuthorizeRequest;
import vn.com.dattb.ssaservice.dto.request.CredentialsInfoRequest;
import vn.com.dattb.ssaservice.dto.request.GetChallengeRequest;
import vn.com.dattb.ssaservice.dto.response.CredentialsResponse;
import vn.com.dattb.ssaservice.dto.response.CredentialsAuthorizeResponse;
import vn.com.dattb.ssaservice.dto.response.CredentialsInfoResponse;
import vn.com.dattb.ssaservice.dto.response.GetChallengeResponse;
import vn.com.dattb.ssaservice.service.CredentialsService;

/**
 * CredentialsServiceImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: Service impl for handling credentials
 */
@Service
@Slf4j
public class CredentialsServiceImpl implements CredentialsService {
    @Override
    public CredentialsAuthorizeResponse authorize(CredentialsAuthorizeRequest credentialsAuthorizeRequest) {
        return null;
    }

    @Override
    public CredentialsResponse getCredentialsList(CredentialsRequest credentialsRequest) {
        return null;
    }

    @Override
    public CredentialsInfoResponse getCredentialsInfo(CredentialsInfoRequest credentialsInfoRequest) {
        return null;
    }

    @Override
    public GetChallengeResponse getChallenge(GetChallengeRequest getChallengeRequest) {
        return null;
    }
}
