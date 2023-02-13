package com.github.shortenURL.repository;

import com.github.shortenURL.mapper.UrlMapper;
import com.github.shortenURL.model.Url;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class UrlRepository {
    private final UrlMapper urlMapper;

    public void save(final Url url) {
        log.info("before: {}", url);
        urlMapper.save(url);
        log.info("after: {}", url);
    }

    public Optional<Url> findById(final Integer id) {
        return urlMapper.findById(id);
    }
}
