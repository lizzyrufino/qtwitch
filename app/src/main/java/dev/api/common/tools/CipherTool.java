package dev.api.common.tools;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class CipherTool {

    private static final String ALGORITHM = "AES";
    private static final String CHARSET = "UTF-8";

    public static Key generateSecretKey(String key) {
        return new SecretKeySpec(key.getBytes(), ALGORITHM);
    }

    public static String encode(String password, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, generateSecretKey(key));
        byte[] encrypted = cipher.doFinal(password.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decode(String encryptedPassword, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, generateSecretKey(key));
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, CHARSET);
    }
}