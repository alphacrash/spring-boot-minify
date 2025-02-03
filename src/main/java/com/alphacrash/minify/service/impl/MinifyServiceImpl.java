package com.alphacrash.minify.service.impl;

import com.alphacrash.minify.model.URL;
import com.alphacrash.minify.repository.MinifyRepository;
import com.alphacrash.minify.service.MinifyService;
import com.alphacrash.minify.util.MinifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MinifyServiceImpl implements MinifyService {

    @Autowired
    MinifyRepository minifyRepository;

    @Override
    public String shortenURL(String longUrl) {
        Optional<URL> existingUrl = minifyRepository.findByLongUrl(longUrl);
        if (existingUrl.isPresent()) {
            return existingUrl.get().getShortUrl();
        }

        String shortUrl = MinifyUtil.encode(longUrl);

        URL url = new URL();
        url.setLongUrl(longUrl);
        url.setShortUrl(shortUrl);
        minifyRepository.save(url);

        return shortUrl;
    }

    @Override
    public String getLongURL(String shortUrl) {
        Optional<URL> url = minifyRepository.findByShortUrl(shortUrl);
        return url.map(URL::getLongUrl).orElse(null);
    }
}
