package vn.com.dattb.ssaservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.ssaservice.dto.request.InputCredentialsAuthorize;
import vn.com.dattb.ssaservice.dto.response.OutputCredentialsAuthorize;
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
    public OutputCredentialsAuthorize authorize(InputCredentialsAuthorize inputCredentialsAuthorize) {
        return null;
    }
}
