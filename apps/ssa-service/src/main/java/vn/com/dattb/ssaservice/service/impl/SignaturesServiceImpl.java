package vn.com.dattb.ssaservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.ssaservice.dto.request.SignaturesRequest;
import vn.com.dattb.ssaservice.dto.response.SignaturesResponse;
import vn.com.dattb.ssaservice.service.SignaturesService;

/**
 * SignaturesServiceImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: Service for handling signature requests
 */

@Service
@Slf4j
public class SignaturesServiceImpl implements SignaturesService {
    @Override
    public SignaturesResponse signHash(SignaturesRequest signaturesRquest) {
        try {
            String credentialId = signaturesRquest.getCredentialId();
            log.info("Start sign hash for credentialId: {}", credentialId);
            String sad = signaturesRquest.getSAD();
            //get certificate from credentialId
            //request sign hash with certificate and sad to sign server
            //store log signature to database
            //increase counter for credentialId
            //send notification to client
            log.info("End sign hash for credentialId: {}", credentialId);
            return SignaturesResponse.builder().build();
        } catch (Exception e) {
            log.error("Error sign hash", e);
            throw e;
        }
    }
}
