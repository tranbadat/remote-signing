package vn.com.dattb.coreservice.service.impl;

import org.springframework.web.multipart.MultipartFile;
import vn.com.dattb.coreservice.dto.request.InitBatchContractRequest;
import vn.com.dattb.coreservice.dto.response.UploadBatchResponse;
import vn.com.dattb.coreservice.service.BatchService;

import java.util.List;

/**
 * BatchServiceImpl is the service class for batch contracts
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/15/2025
 * Version: 1.0.0
 * <p>
 * Description: BatchServiceImpl is the service class for batch contracts
 */
public class BatchServiceImpl implements BatchService {


    /**
     * uploadBatchContract is the method for uploading batch contracts
     *
     * @param request the request for uploading batch contracts
     * @return the response for uploading batch contracts
     */
    @Override
    public UploadBatchResponse upload(List<MultipartFile> request) {
        return null;
    }

    /**
     * initBatchContracts is the method for initializing batch contracts
     *
     * @param request the request for initializing batch contracts
     */
    @Override
    public void initBatchContracts(InitBatchContractRequest request) {

    }
}
