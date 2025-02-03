package com.alphacrash.minify.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MinifyUtil {
    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(String url) {
        try {
            // Create SHA-256 hash of the URL
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(url.getBytes());

            // Convert the byte array into a BigInteger
            BigInteger bigInt = new BigInteger(1, hashBytes);

            // Encode the BigInteger in Base62
            StringBuilder shortenedUrl = new StringBuilder();
            while (bigInt.compareTo(BigInteger.ZERO) > 0) {
                int remainder = bigInt.mod(BigInteger.valueOf(62)).intValue();
                shortenedUrl.append(BASE62.charAt(remainder));
                bigInt = bigInt.divide(BigInteger.valueOf(62));
            }

            // Return the first 7 characters from the Base62 encoded string
            return shortenedUrl.reverse().substring(0, 7);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}