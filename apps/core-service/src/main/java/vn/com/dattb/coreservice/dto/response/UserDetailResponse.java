package vn.com.dattb.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDetailResponse
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/19/2025
 * Version: 1.0.0
 * <p>
 * Description: UserDetailResponse is the response class for getting detail of a user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailResponse {
    private String id;
    private String username;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String status;
    private String role;
    private String avatar;
}
