package com.alphacrash.minify.util;

import java.util.Base64;

public class MinifyUtil {
    public static String encode(String input) {
        String encoded = Base64.getUrlEncoder().encodeToString(input.getBytes());
        if (encoded.length() > 7) {
            return encoded.substring(0, 7);
        }
        return encoded;
    }
}
