package com.github.shortenURL.controller;

import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.shortenURL.service.UrlService;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {
    @Autowired
    private final UrlService service;

    @GetMapping("encode/{url}")
    public String encodeUrl(@PathVariable("url") final String url) {
        final Integer encodedId = service.encodeUrl(url);
        return encodedId.toString();
    }

    @GetMapping("/decode/{id}")
    public ResponseEntity<Object> decodeId(@PathVariable("id") final Integer id) {
        final Optional<String> decodedUrl = service.decodeUrl(id);
        if(decodedUrl.isEmpty()) {
            return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            httpHeaders.setLocation(new URI("http://" + decodedUrl.get()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
