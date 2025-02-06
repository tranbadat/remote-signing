package vn.com.dattb.common.util;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

/**
 * EncryptUtils
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/24/2024
 * Version: 1.0.0
 * <p>
 * Description: Utility class for handling encrypt
 */
public class EncryptUtils {
    private EncryptUtils() {
        throw new IllegalStateException("EncryptUtils class");
    }

    public static final int GCM_IV_LENGTH = 16;
    private static final int GCM_TAG_LENGTH = 128;
    public static final String AES = "AES";

    public static SecretKey stringToSecretKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, AES);
    }

    public static String secretKeyToString(SecretKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    private static byte[] decrypt(String cipherText, SecretKey key, String transformation)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException {
        byte[] decodedIvAndCipher = Base64.getDecoder().decode(cipherText);
        byte[] iv = Arrays.copyOfRange(decodedIvAndCipher, 0, GCM_IV_LENGTH);
        byte[] rawCipherText = Arrays.copyOfRange(decodedIvAndCipher, GCM_IV_LENGTH, decodedIvAndCipher.length);

        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance(transformation);

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), AES);

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);

        // Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Decryption
        return cipher.doFinal(rawCipherText);
    }

    public static String encrypt(String plaintext, SecretKey key, String transformation)
            throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException, InvalidKeyException {
        // Gen Salt
        byte[] iv = genIV();

        // Get Cipher Instance with padding
        Cipher cipher = Cipher.getInstance(transformation);

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), AES);

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);

        // Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(concat(iv, cipherText));
    }

    public static byte[] concat(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }
        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, pos, array.length);
            pos += array.length;
        }
        return result;
    }

    public static byte[] genIV() {
        byte[] iv = new byte[GCM_IV_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return iv;
    }
}
