package vn.com.dattb.coreservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.com.dattb.coreservice.dto.PageDto;
import vn.com.dattb.coreservice.dto.request.InitContractRequest;
import vn.com.dattb.coreservice.dto.response.DetailContractResponse;
import vn.com.dattb.coreservice.dto.response.HistoriesContractResponse;
import vn.com.dattb.coreservice.dto.response.InitContractResponse;
import vn.com.dattb.coreservice.dto.response.ListContractResponse;
import vn.com.dattb.coreservice.service.ContractService;

import java.util.List;

/**
 * ContractServiceImpl is the service class for contract
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/10/2025
 * Version: 1.0.0
 * <p>
 * Description: ContractServiceImpl is the service class for contract
 */
@Service
@Slf4j
public class ContractServiceImpl implements ContractService {

    @Override
    public InitContractResponse init(InitContractRequest request) {
        return null;
    }

    @Override
    public PageDto<ListContractResponse> getList() {
        return null;
    }

    @Override
    public DetailContractResponse getDetail(Long id) {
        return null;
    }

    @Override
    public DetailContractResponse update(Long id, InitContractRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<HistoriesContractResponse> getHistories(Long id) {
        return List.of();
    }
}
