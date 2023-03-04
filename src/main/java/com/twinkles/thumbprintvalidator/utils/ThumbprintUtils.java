package com.twinkles.thumbprintvalidator.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

public class ThumbprintUtils {
    public static String calculateThumbprint(PublicKey publicKey) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] publicKeyBytes = publicKey.getEncoded();
            byte[] thumbprintBytes = digest.digest(publicKeyBytes);
            return Base64.getEncoder().encodeToString(thumbprintBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to calculate thumbprint.", e);
        }
    }
}


