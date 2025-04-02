package vn.com.dattb.coreservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.coreservice.dto.request.AccessCodeRequest;
import vn.com.dattb.coreservice.dto.response.AccessTokenResponse;
import vn.com.dattb.coreservice.service.AnonymousService;

/**
 * AnonymousServiceImpl is the service class for anonymous service
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/13/2025
 * Version: 1.0.0
 * <p>
 * Description: AnonymousServiceImpl is the service class for anonymous service
 */
@Service
@Slf4j
public class AnonymousServiceImpl implements AnonymousService {
    @Override
    public String generateAccessCode(String username, String referenceId) {
        return "";
    }

    @Override
    public boolean validateAccessCode(String accessCode, String referenceId) {
        return false;
    }

    @Override
    public AccessTokenResponse verify(AccessCodeRequest request) {
        return AccessTokenResponse.builder()
                .accessToken("123").build();
    }
}
