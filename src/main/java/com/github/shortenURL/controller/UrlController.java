package com.github.shortenURL.controller;

import com.github.shortenURL.model.Url;
import com.github.shortenURL.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/Url")
@RequiredArgsConstructor
@RestController
public class UrlController {

    @Autowired
    private final UrlRepository repository;
    @GetMapping("encode/{url}")
    public String convert(@PathVariable("url") final String url) {
        Url urlModel = new Url();
        urlModel.setUrl(url);
        repository.save(urlModel);

        return urlModel.getId().toString();
    }
    @GetMapping("/decode/{id}")
    public String getId(@PathVariable("id") final Integer id) {
        Optional<Url> Url = repository.findById(id);
        if(Url.isEmpty())
        {
            return "not found";
        }

        return Url.get().getUrl();
    }
}
