package com.github.shortenURL.controller;

import lombok.RequiredArgsConstructor;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.shortenURL.service.UrlService;

@RestController

@RequestMapping("/Url")
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
    public String getId(@PathVariable("id") final Integer id) {
        final Optional<String> decodedUrl = service.decodeUrl(id);
        if(decodedUrl.isEmpty()) {
            return "Not found";
        }

        return decodedUrl.get();
    }
}
