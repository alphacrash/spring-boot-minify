package com.alphacrash.minify.controller;

import com.alphacrash.minify.payload.PostDTO;
import com.alphacrash.minify.service.MinifyService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class MinifyController {

    @Autowired
    public MinifyService minifyService;

    @PostMapping("/shorten")
    ResponseEntity<String> shorten(@RequestBody PostDTO postDTO) {
        String shortUrl = minifyService.shortenURL(postDTO.getLongUrl());
        return new ResponseEntity<>(shortUrl, HttpStatus.CREATED);
    }

    @GetMapping("/{shortUrl}")
    void redirect(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String longUrl = minifyService.getLongURL(shortUrl);
        if (Objects.nonNull(longUrl)) {
            response.sendRedirect(longUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
