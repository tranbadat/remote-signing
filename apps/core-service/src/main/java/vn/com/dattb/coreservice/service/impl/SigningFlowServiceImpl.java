package vn.com.dattb.coreservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.coreservice.dto.SignerFlowDto;
import vn.com.dattb.coreservice.service.SigningFlowService;

import java.util.List;

/**
 * SigningFlowServiceImpl is the service class for signing flow service
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/13/2025
 * Version: 1.0.0
 * <p>
 * Description: SigningFlowServiceImpl is the service class for signing flow service
 */
@Service
@Slf4j
public class SigningFlowServiceImpl implements SigningFlowService {

    @Override
    public List<SignerFlowDto> getNextHandler(Long documentId) {
        return List.of();
    }
}
