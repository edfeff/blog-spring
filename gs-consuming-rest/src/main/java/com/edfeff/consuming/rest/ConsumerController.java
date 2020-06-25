package com.edfeff.consuming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/quote")
    public Quote getQuote() {
        return restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

}
