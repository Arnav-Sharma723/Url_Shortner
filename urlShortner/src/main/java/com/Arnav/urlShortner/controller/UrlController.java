package com.Arnav.urlShortner.controller;

import com.Arnav.urlShortner.entity.Url;
import com.Arnav.urlShortner.repository.UrlRepository;
import com.Arnav.urlShortner.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class UrlController {
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private UrlService urlService;
    @PostMapping("/shorten")
    public Url shortenUrl (@RequestBody Url url){
        return urlService.shortenUrl(url.getOriginalurl());
    }
@SneakyThrows
@GetMapping("/{short_code}")
    public void redirect (@PathVariable String short_code, HttpServletResponse response){
        Url urlEntry = urlRepository.findByShortcode(short_code);
        if(urlEntry!=null){
            String originalUrl=urlEntry.getOriginalurl();
            if(!originalUrl.startsWith("http"))
                originalUrl="https://"+originalUrl;

        response.sendRedirect(originalUrl);}
        else{
            response.sendError(404,"Short Url not Found");}
}}

