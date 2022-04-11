package com.example.service1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Logger LOG = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "Brasov") String name,
                                           @RequestHeader Map<String, String> headers) {
            headers.forEach((key, value) -> {
                LOG.info(String.format("Header '%s' = %s", key, value));
            });
        return new ResponseEntity<String>(String.format(template, name), HttpStatus.OK);
    }
}