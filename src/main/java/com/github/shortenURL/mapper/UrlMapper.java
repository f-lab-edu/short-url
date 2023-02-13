package com.github.shortenURL.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.github.shortenURL.model.Url;

@Mapper
public interface UrlMapper {
    void save(final Url url);

    Optional<Url> findById(final Integer id);
}
