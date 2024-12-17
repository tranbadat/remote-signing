package vn.com.dattb.ssaservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * AuthObject
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/17/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for auth object
 */
public class AuthObject {

    @JsonAlias({"id", "ID"})
    private String id;

    @JsonAlias({"value", "value"})
    private String value;
}
