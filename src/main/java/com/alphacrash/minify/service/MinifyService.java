package com.alphacrash.minify.service;

import com.alphacrash.minify.model.URL;

import java.util.Optional;

public interface MinifyService {
    String shortenURL(String longUrl);
    String getLongURL(String shortUrl);
}
