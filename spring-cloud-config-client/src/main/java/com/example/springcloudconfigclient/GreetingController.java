package com.example.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Profile("{default,prod}")
public class GreetingController {

    @Value("${my.greeting}")
    String greet;
    @Autowired
    Environment env;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    String greeting(){
        return greet + "from" + env.getProfiles().toString();
    }
}
