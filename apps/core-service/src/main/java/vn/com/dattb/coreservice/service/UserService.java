package vn.com.dattb.coreservice.service;

import vn.com.dattb.coreservice.dto.response.UserDetailResponse;

/**
 * UserService is the service class for user
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/19/2025
 * Version: 1.0.0
 * <p>
 * Description: UserService is the service class for user
 */
public interface UserService {
    UserDetailResponse getDetail(Long id);

}
