package com.example.service1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Logger LOG = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/api/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "Brasov") String name,
                                           @RequestHeader Map<String, String> headers) {
            headers.forEach((key, value) -> {
                LOG.info(String.format("Header '%s' = %s", key, value));
            });
        return new ResponseEntity<String>(String.format(template, name), HttpStatus.OK);
    }
}