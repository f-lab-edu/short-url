package com.github.shortenURL.service;

import lombok.RequiredArgsConstructor;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.shortenURL.model.Url;
import com.github.shortenURL.repository.UrlRepository;


@Service
@RequiredArgsConstructor
public class UrlService {

    @Autowired
    private final UrlRepository repository;

    public Integer encodeUrl(final String url) {
        Url urlModel = new Url();
        urlModel.setUrl(url);
        repository.save(urlModel);

        return urlModel.getId();
    }

    public Optional<String> decodeUrl(final Integer id) {
        Optional<Url> url = repository.findById(id);
        if(url.isEmpty())
        {
            return Optional.empty();
        }

        return Optional.of(url.get().getUrl());
    }
}
