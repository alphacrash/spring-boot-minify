# Minify

A URL shortener application.

## Notes

1. Why 302 is used and not 301?
   - 301 redirect: Permanently moves the URL to the long URL. 
      - The browser caches the response, so subsequent requests go directly to the long URL server. 
      - If the priority is to reduce the server load, use 301.
   - 302 redirect: Temporarily moves the URL to the long URL. 
     - Subsequent requests go to the URL shortening service first, then to the long URL server. This is used to track click rate and source.
     - If analytics is important, 302 can track click rate and source of the click more easily.

2. Why encode returns only 7 or fewer characters?
   - The URL shortening service uses a base62 encoding scheme.