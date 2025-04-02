package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * UploadBatchResponse is the response class for uploading batch contracts
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/15/2025
 * Version: 1.0.0
 * <p>
 * Description: UploadBatchResponse is the response class for uploading batch contracts
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadBatchResponse {
    String batchId;
    List<String> contractIds;
}
