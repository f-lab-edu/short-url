package com.github.shortenURL.repository;

import com.github.shortenURL.model.Url;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@SpringBootTest
public class UrlRepositoryTest {

    @Autowired
    private UrlRepository repository;

    @Test
    void save() {
        Url url = new Url();
        url.setUrl("url");

        repository.save(url);

        Assertions.assertTrue(url.getId() != 0);
    }

    @Test
    void findById() {
        Url url = new Url();
        url.setUrl("url");

        repository.save(url);

        Optional<Url> result = repository.findById(url.getId());
        Assertions.assertTrue(result.isPresent());
    }
}
