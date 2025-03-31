package vn.com.dattb.coreservice.service;

import vn.com.dattb.coreservice.dto.PageDto;
import vn.com.dattb.coreservice.dto.request.InitContractRequest;
import vn.com.dattb.coreservice.dto.response.DetailContractResponse;
import vn.com.dattb.coreservice.dto.response.HistoriesContractResponse;
import vn.com.dattb.coreservice.dto.response.InitContractResponse;
import vn.com.dattb.coreservice.dto.response.ListContractResponse;

import java.util.List;

/**
 * ContractService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/18/2025
 * Version: 1.0.0
 * <p>
 * Description: ContractService is the service class for contract
 */
public interface ContractService {

    InitContractResponse init(InitContractRequest request);

    PageDto<ListContractResponse> getList();

    DetailContractResponse getDetail(Long id);

    DetailContractResponse update(Long id, InitContractRequest request);

    void delete(Long id);

    String getObjectPreview(Long id);

    List<HistoriesContractResponse> getHistories(Long id);
}
