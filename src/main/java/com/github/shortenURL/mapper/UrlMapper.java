package com.github.shortenURL.mapper;

import com.github.shortenURL.model.Url;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UrlMapper {
    void save(final Url url);

    Optional<Url> findById(final Integer id);
}
