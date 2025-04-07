package vn.com.dattb.esignservice.service.impl;

import org.springframework.stereotype.Service;
import vn.com.dattb.esignservice.dto.response.UserDetailResponse;
import vn.com.dattb.esignservice.service.UserService;

/**
 * UserServiceImpl
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/19/2025
 * Version: 1.0.0
 * <p>
 * Description: UserServiceImpl is the service class for user
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * getDetail is the method for getting detail of a user
     *
     * @param id the id of the user
     * @return the response for getting detail of a user
     */
    @Override
    public UserDetailResponse getDetail(Long id) {
        return null;
    }
}
