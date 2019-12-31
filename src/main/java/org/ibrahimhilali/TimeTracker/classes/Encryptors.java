package org.ibrahimhilali.TimeTracker.classes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Encryptors {
    public static String encrypt(final String data, final String key) {
        byte[] decodedKey = Base64.getDecoder().decode(key);

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String decrypt(final String encrypted, final String key) {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encrypted));
            return new String(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String generate() throws NoSuchAlgorithmException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 256;
        keyGenerator.init(keyBitSize, secureRandom);

        SecretKey secretKey = keyGenerator.generateKey();

        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

}
