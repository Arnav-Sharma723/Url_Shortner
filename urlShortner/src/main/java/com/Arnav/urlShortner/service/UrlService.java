package com.Arnav.urlShortner.service;

import com.Arnav.urlShortner.entity.Url;
import com.Arnav.urlShortner.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;
    private static final String ALLOWED_CHARACTERS="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
public String encode(String originalurl){
    StringBuilder sb=new StringBuilder();
long number=Math.abs((long)originalurl.hashCode());
int base=ALLOWED_CHARACTERS.length();
while(number>0){
    int index=(int)(number%base);
    sb.insert(0,ALLOWED_CHARACTERS.charAt(index));
    number=number/base;
}
return sb.toString();}
    public Url shortenUrl(String originalurl){
        Url urlEntry=new Url();
        urlEntry.setOriginalurl(originalurl);
        urlEntry.setId(UUID.randomUUID().toString().substring(0,5));
        String code=encode(originalurl);
        urlEntry.setShortcode(code);
        urlEntry.setCreated(LocalDateTime.now());
       return urlRepository.save(urlEntry);
    }
}
