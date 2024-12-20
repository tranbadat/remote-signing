package vn.com.dattb.ssaservice.service;

import vn.com.dattb.ssaservice.dto.request.CommitChallengeRequest;

/**
 * ChallengeService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/20/2024
 * Version: 1.0.0
 * <p>
 * Description: Service for handling challenge requests
 */
public interface ChallengeService {
    void commit(CommitChallengeRequest request);
}
