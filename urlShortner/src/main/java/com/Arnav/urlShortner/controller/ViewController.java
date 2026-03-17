package com.Arnav.urlShortner.controller;

import com.Arnav.urlShortner.entity.Url;
import com.Arnav.urlShortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ui")
public class ViewController {
    @Autowired
    private UrlService urlService;
        @GetMapping
        public String home() {
            return "index"; // Returns index.html from templates
        }

        @PostMapping("/shorten")
        public String shorten(@RequestParam String originalurl, Model model) {
            Url url = urlService.shortenUrl(originalurl);
            // Construct the full clickable URL
            String fullShortUrl = "http://localhost:8080/url/" + url.getShortcode();
            model.addAttribute("shortUrl", fullShortUrl);
            return "index";
        }
    }
//This controller made using AI (Gemini)
