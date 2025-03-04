package vn.com.dattb.coreservice.service;

import vn.com.dattb.coreservice.dto.SignerFlowDto;

import java.util.List;

/**
 * SigningFlowService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/18/2025
 * Version: 1.0.0
 * <p>
 * Description: SigningFlowService is the service class for signing flow service
 */
public interface SigningFlowService {

    List<SignerFlowDto> getNextHandler(Long documentId);

    List<SignerFlowDto> getPreviousHandler(Long documentId);

    List<SignerFlowDto> getSignerFlow(Long documentId);
}
