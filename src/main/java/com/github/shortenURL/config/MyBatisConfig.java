package com.github.shortenURL.config;

import com.github.shortenURL.mapper.UrlMapper;
import com.github.shortenURL.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final UrlMapper urlMapper;

    @Bean
    public UrlRepository urlRepository() { return new UrlRepository(urlMapper); }
}
