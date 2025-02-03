package com.alphacrash.minify.repository;

import com.alphacrash.minify.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MinifyRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortUrl(String shortUrl);
    Optional<URL> findByLongUrl(String longUrl);
}
