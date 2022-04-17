package com.example.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${value:100}")
    Integer version;

    @GetMapping(value = "/version",produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer retrieveVersion(){
       // return configuration.getValue();
        return version;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    String greeting(){
        return "Hello from " + activeProfile;
    }
}
