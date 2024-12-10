package vn.com.dattb.signserver.utils;

import java.security.*;
import java.util.Base64;

/**
 * SignatureUtil.java
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/10/2024
 * Version: 1.0.0
 * <p>
 * Description: This util is used to sign the data
 */
public class SignatureUtils {
    public static String sign(String data, PrivateKey privateKey, String signatureAlgorithm)
            throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        byte[] byteDataTobeSign = Base64.getEncoder().encode(data.getBytes());
        Signature signature = Signature.getInstance(signatureAlgorithm);
        signature.initSign(privateKey);
        signature.update(byteDataTobeSign);
        byte[] signatureBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

}
