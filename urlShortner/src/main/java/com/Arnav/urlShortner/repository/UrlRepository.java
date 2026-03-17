package com.Arnav.urlShortner.repository;

import com.Arnav.urlShortner.entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url,String> {
    Url findByShortcode(String short_code);
}
