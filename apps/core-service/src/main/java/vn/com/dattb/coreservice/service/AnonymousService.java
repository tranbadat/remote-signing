package vn.com.dattb.coreservice.service;

/**
 * AnonymousService
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/18/2025
 * Version: 1.0.0
 * <p>
 * Description: AnonymousService is the service class for anonymous service
 */
public interface AnonymousService {

    /**
     * generateAccessCode is the method for generating access code
     *
     * @param username    the username
     * @param referenceId the reference id
     * @return the access code
     */
    String generateAccessCode(String username, String referenceId);

    /**
     * validateAccessCode is the method for validating access code
     *
     * @param accessCode  the access code
     * @param referenceId the reference id
     * @return true if the access code is valid, otherwise false
     */
    boolean validateAccessCode(String accessCode, String referenceId);
}
