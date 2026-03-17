package com.Arnav.urlShortner.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Update;

import java.time.LocalDateTime;

@Document(collection="url")
@Data
public class Url {
 @Id
 private String id;
 private String originalurl;
 private String shortcode;
 @CreatedDate
 private LocalDateTime created;
 @LastModifiedDate
 private LocalDateTime updated;
}
